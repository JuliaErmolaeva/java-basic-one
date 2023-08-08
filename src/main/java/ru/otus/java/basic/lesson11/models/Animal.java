package ru.otus.java.basic.lesson11.models;

public abstract class Animal {
    private String name;
    private int speedRun;
    private int speedSwim;
    private int endurance;

    public Animal(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

    public void info() {
        System.out.println("Животное: " + name);
        System.out.println("Скорость бега: " + speedRun);
        System.out.println("Скорость плавания: " + speedSwim);
        System.out.println("Выносливость: " + endurance);
        System.out.println();
    }

    public String run(int distance) {
        if (endurance == 0) {
            System.out.println(name + " не имеет сил для Вашего бега");
            return "";
        }
        float time = (float) distance / speedRun;

        if (endurance < distance) {
            endurance = 0;
            ++time;
            System.out.println(name + " испытывает состояние усталости");
        } else {
            endurance -= distance;
        }

        return String.valueOf(time);
    }

    public abstract String swim(int distance);

    public String getName() {
        return name;
    }

    public int getSpeedRun() {
        return speedRun;
    }

    public int getSpeedSwim() {
        return speedSwim;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
}