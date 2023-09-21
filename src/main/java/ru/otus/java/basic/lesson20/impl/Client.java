package ru.otus.java.basic.lesson20.impl;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements AutoCloseable {

    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    private Client(String host, int port) throws IOException {
        clientSocket = new Socket(host, port);
        out = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
    }

    public static void run(String host, int port) {
        try (Client client = new Client(host, port)) {

            System.out.println("Client is running");
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Для продолжения нажмите n: ");
                if (!scanner.next().contains("n")) {
                    break;
                }

                StringBuilder stringBuilder = new StringBuilder();
                System.out.print("Введите первое число: ");
                int firstNumber = scanner.nextInt();
                stringBuilder.append(firstNumber).append(" ");

                System.out.print("Введите второе число: ");
                String secondNumber = scanner.next();
                stringBuilder.append(secondNumber).append(" ");

                System.out.print("Введите операцию (+, -, *, /): ");
                String operation = scanner.next();
                stringBuilder.append(operation);

                client.push(stringBuilder.toString());
                System.out.println("Результат: " + firstNumber + " " + operation + " " + secondNumber + " = " + client.pull());
                System.out.println();
            } while (true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void push(String expression) throws IOException {
        out.writeBytes(expression + "\n");
        out.flush();
    }

    private String pull() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader.readLine();
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
        clientSocket.close();
    }
}