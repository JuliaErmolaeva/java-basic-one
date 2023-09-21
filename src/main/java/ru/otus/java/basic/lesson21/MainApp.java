package ru.otus.java.basic.lesson21;

public class MainApp {

    private static final int COUNT_THREADS = 4;
    private static final int SIZE_ARRAY = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        unparallelOperation();
        parallelOperation();
    }

    private static void unparallelOperation() {
        double[] arrayDouble = new double[SIZE_ARRAY];
        long startTime = System.nanoTime();
        for (int i = 0; i < SIZE_ARRAY; i++) {
            arrayDouble[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println(System.nanoTime() - startTime);
    }

    private static void parallelOperation() throws InterruptedException {
        Thread[] threads = new Thread[COUNT_THREADS];

        double[] arrayDouble = new double[SIZE_ARRAY];

        for (int i = 0; i < COUNT_THREADS; i++) {
            int step = i;
            threads[i] = new Thread(() -> {
                for (int j = SIZE_ARRAY / COUNT_THREADS * step; j < SIZE_ARRAY / COUNT_THREADS * (step + 1); j++) {
                    arrayDouble[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                }
            });
        }

        long startTime = System.nanoTime();

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(System.nanoTime() - startTime);
    }
}
