package ru.otus.java.basic.lesson30;

public class ArrayTrimmer {
    public int[] trimArrayAfterLastNumberOne(int[] array) {
        int lastIndexOfOne = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastIndexOfOne = i + 1;
            }
        }

        if (lastIndexOfOne == 0) {
            throw new RuntimeException();
        }

        int[] result = new int[array.length - lastIndexOfOne];
        for (int i = 0, j = lastIndexOfOne; i < result.length; i++, j++) {
            result[i] = array[j];
        }
        return result;
    }
}
