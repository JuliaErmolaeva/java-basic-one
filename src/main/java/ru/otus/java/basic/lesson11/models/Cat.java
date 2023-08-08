package ru.otus.java.basic.lesson11.models;

public class Cat extends Animal {

    public Cat(String name, int speedRun, int endurance) {
        super(name, speedRun, 0, endurance);
    }

    @Override
    public void info() {
        System.out.println("Кисуля: " + getName());
        System.out.println("Скорость бега: " + getSpeedRun());
        System.out.println("Выносливость: " + getEndurance());
        System.out.println();
    }

    public String swim(int distance){
        System.out.println("Киски не умеют плавать!");
        return "";
    }
}
