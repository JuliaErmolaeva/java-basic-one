package ru.otus.java.basic.lesson29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrinterAbc {

    private final Object monitor = new Object();

    private static int state = 1;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        PrinterAbc p = new PrinterAbc();

        service.submit(() -> p.print('A'));
        service.submit(() -> p.print('B'));
        service.submit(() -> p.print('C'));

        service.shutdown();
    }

    private void print(char symbol) {
        try {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {
                    switch (symbol) {
                        case 'A' -> {
                            while (state != 1) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.print(symbol);
                            state = 2;
                            monitor.notifyAll();
                        }
                        case 'B' -> {
                            while (state != 2) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.print("B");
                            state = 3;
                            monitor.notifyAll();
                        }
                        case 'C' -> {
                            while (state != 3) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.print("C");
                            Thread.sleep(1000);
                            state = 1;
                            monitor.notifyAll();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        }
    }
}
