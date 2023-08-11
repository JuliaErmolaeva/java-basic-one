package ru.otus.java.basic.lesson11.animals;

public class Cat extends Animal {

    public Cat(String name, int speedRun, int endurance) {
        super(name, speedRun, 0, endurance);
    }

    public float swim(int distance) {
        System.out.println("Киски не умеют плавать!");
        return 0;
    }

    @Override
    public void info() {
        System.out.println("Кисуля: " + name);
        super.info();
    }

}
