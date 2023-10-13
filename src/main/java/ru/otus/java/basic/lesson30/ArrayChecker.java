package ru.otus.java.basic.lesson30;

public class ArrayChecker {
    public boolean existOnlyNumberOneAndTwo(int[] array) {
        boolean isNumberOne = false;
        boolean isNumberTwo = false;
        for (int j : array) {
            if (j == 1 && !isNumberOne) {
                isNumberOne = true;
            } else if (j == 2 && !isNumberTwo) {
                isNumberTwo = true;
            } else if (j < 1 || j > 2) {
                return false;
            }
        }
        return isNumberTwo && isNumberOne;
    }
}
