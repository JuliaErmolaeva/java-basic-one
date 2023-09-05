package ru.otus.java.basic.lesson14;

public class AppArraySizeException extends Exception {

    private static final String MESSAGE_ERROR_SIZE = "Передан массив другого размера";

    public AppArraySizeException() {
        super(MESSAGE_ERROR_SIZE);
    }
}
