package ru.otus.java.basic.lesson14;

public class MainApp {

    private static final String[][] ARRAY_NON_VALID_SIZE = new String[3][4];

    private static final String[][] ARRAY_NON_VALID_DATA = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "3", "s", "4"},
            {"1", "3", "0", "2"}
    };

    private static final String[][] ARRAY_VALID_DATA_AND_SIZE = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
    };

    public static void main(String[] args) {
        runLogic(ARRAY_NON_VALID_SIZE);
        runLogic(ARRAY_NON_VALID_DATA);
        runLogic(ARRAY_VALID_DATA_AND_SIZE);
    }

    private static void runLogic(String[][] stringArray) {
        try {
            checkSizeArray(stringArray);
            int[][] intArray = convertStringArrayToIntArray(stringArray);
            int sumElements = getSumElements(intArray);
            System.out.println("Сумма элементов массива = " + sumElements);
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    private static int getSumElements(int[][] intArray) throws AppArrayDataException {
        int sum = 0;
        for (int[] ints : intArray) {
            for (int values : ints) {
                sum += values;
            }
        }

        return sum;
    }

    private static int[][] convertStringArrayToIntArray(String[][] stringArray) throws AppArrayDataException {
        int[][] intArray = new int[4][4];

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray.length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Ячейка [" + i + "]" + "[" + j + "]" + " с неверными данными = " + stringArray[i][j]);
                }
            }
        }

        return intArray;
    }

    private static void checkSizeArray(String[][] array) throws AppArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new AppArraySizeException();
        }
    }
}
