package ru.otus.java.basic.lesson7;

public class MainApp {
    public static void main(String[] args) {
        int[][] arraySum = {{2, 1}, {2, 5, -2}};
        System.out.println(sumOfPositiveElements(arraySum));
        square(4);
        int[][] arrayDiagonal = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        diagonal(arrayDiagonal);
        int[][] arrayMax = {{6, 10, -8}, {3, 7, 8}};
        System.out.println(findMax(arrayMax));
        int[][] arrayWithoutSecondLine = {{1, 2, 3, 4}};
        System.out.println(sumSecondLine(arrayWithoutSecondLine));
        int[][] arraySecondLinesIsEmpty = {{1, 2, 3, 4}, {}};
        System.out.println(sumSecondLine(arraySecondLinesIsEmpty));
        int[][] arraySumSecondLine = {{1, 2, 3, 4}, {3, 2, -1, 8}, {2, -3}};
        System.out.println(sumSecondLine(arraySumSecondLine));
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }
    public static void square(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '*';
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void diagonal(int[][] array) {
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = number;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int findMax(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }

            }

        }
        return max;
    }

    public static int sumSecondLine(int[][] array) {
        int sum = 0;
        int secondIndex = 1;
        if (array.length == secondIndex || array[secondIndex].length == 0) {
            return -1;
        }
        for (int j = 0; j < array[secondIndex].length; j++) {
            sum += array[secondIndex][j];
        }
        return sum;
    }
}
