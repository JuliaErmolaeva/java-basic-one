package ru.otus.java.basic.lesson27;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        Path path = Paths.get(fileName);
        if (Files.notExists(path)) {
            System.err.println("Имя файла: " + fileName + " не найдено");
            return;
        }

        System.out.print("Введите искомую последовательность символов: ");
        String searchedString = scanner.nextLine();
        int countMatches = 0;
        for (String line : Files.readAllLines(path)) {
            countMatches += countMatchesInLine(line, searchedString);
        }
        System.out.println("Символы: " + searchedString + " повторяются " + countMatches + " раз/а");
    }

    private static int countMatchesInLine(String str, String findStr) {
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }
}
