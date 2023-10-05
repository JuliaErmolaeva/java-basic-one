package ru.otus.java.basic.lesson29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrinterAbc {

    private volatile int state = 1;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        PrinterAbc p = new PrinterAbc();

        service.submit(new PrinterA(p));
        service.submit(new PrinterB(p));
        service.submit(new PrinterC(p));

        service.shutdown();
    }


    private static class PrinterA extends Thread {
        private PrinterAbc p1;

        PrinterA(PrinterAbc p) {
            this.p1 = p;
        }

        @Override
        public void run() {

            try {
                synchronized (p1) {
                    for (int i = 0; i < 5; i++) {
                        while (p1.state != 1) {
                            try {
                                p1.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("A");
                        p1.state = 2;
                        p1.notifyAll();
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception 1 :" + e.getMessage());
            }
        }
    }

    private static class PrinterB extends Thread {

        private PrinterAbc p2;

        PrinterB(PrinterAbc p2) {
            this.p2 = p2;
        }

        @Override
        public void run() {
            try {
                synchronized (p2) {
                    for (int i = 0; i < 5; i++) {
                        while (p2.state != 2) {
                            try {
                                p2.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        p2.state = 3;
                        p2.notifyAll();
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception 2 :" + e.getMessage());
            }
        }
    }

    private static class PrinterC extends Thread {

        private PrinterAbc p3;

        PrinterC(PrinterAbc p) {
            this.p3 = p;
        }

        @Override
        public void run() {
            try {
                synchronized (p3) {
                    for (int i = 0; i < 5; i++) {
                        while (p3.state != 3) {
                            try {
                                p3.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("C");
                        Thread.sleep(1000);
                        p3.state = 1;
                        p3.notifyAll();
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception 3 :" + e.getMessage());
            }
        }
    }
}
