package ru.otus.java.basic.lesson21;

public class MainApp {

    private static final int COUNT_PART = 4;
    private static final int SIZE_ARRAY = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        unparallelOperation();
        parallelOperation();
    }

    private static void unparallelOperation() {
        double[] arrayDouble = new double[SIZE_ARRAY];
        long startTime = System.nanoTime();
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println(System.nanoTime() - startTime);
    }

    private static void parallelOperation() throws InterruptedException {
        double[] arrayDouble = new double[SIZE_ARRAY];

        int endFirstPart = SIZE_ARRAY / COUNT_PART;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < endFirstPart; i++) {
                arrayDouble[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        int endSecondPart = SIZE_ARRAY / 2;
        Thread t2 = new Thread(() -> {
            for (int i = endFirstPart; i < endSecondPart; i++) {
                arrayDouble[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        int endThirdPart = SIZE_ARRAY / 2 + SIZE_ARRAY / COUNT_PART;
        Thread t3 = new Thread(() -> {
            for (int i = endSecondPart; i < endThirdPart; i++) {
                arrayDouble[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = endThirdPart; i < SIZE_ARRAY; i++) {
                arrayDouble[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        long startTime = System.nanoTime();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println(System.nanoTime() - startTime);
    }
}
