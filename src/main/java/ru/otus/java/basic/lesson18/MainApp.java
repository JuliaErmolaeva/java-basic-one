package ru.otus.java.basic.lesson18;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        for (File file : currentDirectory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(file.getName());
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = scanner.nextLine();

        try (InputStreamReader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)))) {
            System.out.println("Содержимое файла: ");
            int ch = in.read();
            while (ch != -1) {
                System.out.print((char) ch);
                ch = in.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл " + fileName + " не найден.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nВведите текст: ");
        String addString = scanner.nextLine();

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            byte[] buff = ("\n" + addString).getBytes(StandardCharsets.UTF_8);

            out.write(buff, 0, buff.length);

            out.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Текст добавлен в файл.");
    }
}
