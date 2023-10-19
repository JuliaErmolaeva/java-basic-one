package ru.otus.java.basic.lesson30;

public class ArrayChecker {
    public static boolean existOnlyNumberOneAndTwo(int[] array) {
        boolean isNumberOne = false;
        boolean isNumberTwo = false;
        for (int j : array) {
            if (j == 1) {
                isNumberOne = true;
            } else if (j == 2) {
                isNumberTwo = true;
            } else {
                return false;
            }
        }
        return isNumberTwo && isNumberOne;
    }
}
