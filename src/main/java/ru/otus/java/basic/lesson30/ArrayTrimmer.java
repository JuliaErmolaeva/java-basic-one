package ru.otus.java.basic.lesson30;

import java.util.Arrays;

public class ArrayTrimmer {
    public static int[] trimArrayAfterLastNumberOne(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }

        throw new RuntimeException();
    }
}
