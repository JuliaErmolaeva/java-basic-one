package ru.otus.java.basic.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        greetings();
        checkSign(10, 1, 2);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(5, 8, true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5");
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> greetings();
            case 2 -> checkSign(getRandomInt(), getRandomInt(), getRandomInt());
            case 3 -> selectColor();
            case 4 -> compareNumbers();
            case 5 -> {
                Random random = new Random();
                addOrSubtractAndPrint(getRandomInt(), getRandomInt(), random.nextBoolean());
            }
            default -> System.out.println("Вы ввели не число от 1 до 5");
        }

    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 12;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Жёлтый");
        } else if (data > 20) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 4;
        String res = a >= b ? "a >= b" : "a < b";
        System.out.println(res);
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result = increment ? initValue + delta : initValue - delta;
        System.out.println(result);
    }

    private static int getRandomInt() {
        return (int) (Math.random() * 10000);
    }
}
