package ru.otus.java.basic.lesson12;

public class Cat {
    private String name;
    private int appetite;
    private boolean isSatiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isSatiety = false;
    }

    public void eat(Plate plate) {
        if (isSatiety) {
            return;
        }

        isSatiety = plate.decreaseFood(appetite);
    }

    public void info() {
        System.out.println("Котик " + name + (isSatiety ? " сыт" : " голоден"));
    }
}