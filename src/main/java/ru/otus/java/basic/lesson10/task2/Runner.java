package ru.otus.java.basic.lesson10.task2;

public class Runner {
    public static void main(String[] args) {
        Box box = new Box("Pink", 50);
        box.printInfo();
        box.showItem();
        box.open();
        box.putItem("Плавленный сырок");
        box.showItem();
        box.close();
        box.open();
        box.throwItem();
        box.putItem("Колбаска");
        box.close();
        box.setColor("Orange");
        box.printInfo();
    }

}
