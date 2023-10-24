package ru.otus.java.basic.lesson29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrinterAbc {

    private final Object monitor = new Object();

    private static char currentState = 'A';

    private static final char SYMBOL_A = 'A';
    private static final char SYMBOL_B = 'B';
    private static final char SYMBOL_C = 'C';

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        PrinterAbc printer = new PrinterAbc();

        service.submit(() -> printer.print(SYMBOL_A, SYMBOL_A, SYMBOL_B));
        service.submit(() -> printer.print(SYMBOL_B, SYMBOL_B, SYMBOL_C));
        service.submit(() -> printer.print(SYMBOL_C, SYMBOL_C, SYMBOL_A));

        service.shutdown();
    }

    public void print(char symbol, char expectedState, char nextState) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentState != expectedState) {
                        monitor.wait();
                    }
                    System.out.print(symbol);
                    System.out.println(" " + Thread.currentThread());
                    currentState = nextState;
                    Thread.sleep(500);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
