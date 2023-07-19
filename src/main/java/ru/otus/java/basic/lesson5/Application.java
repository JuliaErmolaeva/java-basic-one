package ru.otus.java.basic.lesson5;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        printing(3, "Let it be");

        int[] day = {10, 1, 12, 20, 3};
        arraySum(day);

        int[] array = new int[3];
        number(2, array);

        int[] box = {10, 12, 5};
        increase(1, box);
        System.out.println(Arrays.toString(box));

        int[] sum = {1, 5, 8, 3, 9, 10, 1};
        sumLarger(sum);

    }

    public static void printing(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void arraySum(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 5) {
                sum = sum + data[i];
            }
        }
        System.out.println(sum);
    }

    public static void number(int n, int[] array) {
        Arrays.fill(array, n);
        System.out.println(Arrays.toString(array));
    }

    public static void increase(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number + array[i];
        }
    }

    public static void sumLarger(int[] array) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length / 2 + 1; i++) {
            sum = sum + array[i];
        }
        for (int j = array.length / 2; j < array.length; j++) {
            sum2 = sum2 + array[j];
        }
        System.out.println(Math.max(sum, sum2));
    }
}

