package ru.otus.java.basic.lesson14;

public class MainApp {

    private static final int SIZE_CUBE = 4;

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
            int sumElements = getSumElements(stringArray);
            System.out.println("Сумма элементов массива = " + sumElements);
        } catch (AppArrayDataException | AppArraySizeException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    private static int getSumElements(String[][] stringArray) throws AppArrayDataException, AppArraySizeException {
        int sum = 0;

        if (stringArray.length != SIZE_CUBE) {
            throw new AppArraySizeException();
        }

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != SIZE_CUBE) {
                throw new AppArraySizeException();
            }

            for (int j = 0; j < stringArray.length; j++) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Ячейка [" + i + "]" + "[" + j + "]" + " с неверными данными = " + stringArray[i][j]);
                }
            }
        }
        
        return sum;
    }
}
