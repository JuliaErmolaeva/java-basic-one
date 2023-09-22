package ru.otus.java.basic.lesson20.impl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements AutoCloseable {

    private static ServerSocket serverSocket;
    private static DataInputStream in;
    private static DataOutputStream out;

    private Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running");

        Socket socket = serverSocket.accept();
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        System.out.println("Client connected to server");
        out.writeBytes("List available operations +, -, *, /" + "\n");
        out.flush();
        System.out.println();
    }

    public static void run(int port) {
        try (Server server = new Server(port)) {

            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String message = reader.readLine();
                if (message != null && message.trim().length() > 0) {
                    System.out.println("Server received a message: " + message);

                    String result = Server.logicHandler(message);
                    System.out.println("Result: " + message + " = " + result);

                    out.writeBytes(result + "\n");
                    out.flush();
                    System.out.println("Result is sending to client");
                    System.out.println();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Server stopped");
        }
    }

    private static String logicHandler(String message) {
        String[] splitMessage = message.split(" ");

        return switch (splitMessage[2]) {
            case "+" -> String.valueOf(Integer.parseInt(splitMessage[0]) + Integer.parseInt(splitMessage[1]));
            case "-" -> String.valueOf(Integer.parseInt(splitMessage[0]) - Integer.parseInt(splitMessage[1]));
            case "/" -> String.valueOf(Integer.parseInt(splitMessage[0]) / Integer.parseInt(splitMessage[1]));
            case "*" -> String.valueOf(Integer.parseInt(splitMessage[0]) * Integer.parseInt(splitMessage[1]));
            default -> null;
        };
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
        serverSocket.close();
    }
}
