package ru.otus.java.basic.lesson11.animals;

public abstract class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int endurance;
    boolean isFatigue;
    String type;
    int swimCoefficient;

    public Animal(String name, int speedRun, int speedSwim, int endurance, String type, int swimCoefficient) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
        if (endurance == 0) {
            isFatigue = true;
        }
        this.type = type;
        this.swimCoefficient = swimCoefficient;
    }

    public void info() {
        System.out.println(type + ": " + name);
        System.out.println("Скорость бега: " + speedRun);
        System.out.println("Скорость плавания: " + speedSwim);
        System.out.println("Выносливость: " + endurance);
        System.out.println();
    }

    public float run(int distance) {
        if (isFatigue) {
            System.out.println(name + " не имеет сил для Вашего бега");
            return -1;
        }

        System.out.println(this.name + " пытается пробежать");

        float time = (float) distance / speedRun;
        if (endurance < distance) {
            endurance = 0;
            isFatigue = true;
            ++time;
            System.out.println(name + " испытывает состояние усталости");
        } else {
            endurance -= distance;
        }

        System.out.println(name + " пробегает дистанцию за " + time + " секунды");

        return time;
    }

    public float swim(int distance) {
        if (speedSwim == 0) {
            System.out.println(type + " не умеет плавать!");
        }

        if (isFatigue) {
            System.out.println("У животного больше нет сил для Вашего плавания");
            return -1;
        }

        System.out.println(name + " пытается проплыть");

        float time = (float) distance * swimCoefficient / speedSwim;
        if (endurance < distance) {
            endurance = 0;
            isFatigue = true;
            ++time;
            System.out.println("Испытывает состояние усталости");
        } else {
            endurance -= distance;
        }

        return time;
    }
}