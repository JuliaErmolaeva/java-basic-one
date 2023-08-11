package ru.otus.java.basic.lesson11.animals;

public abstract class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int endurance;
    boolean isFatigue;

    public Animal(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
        if (endurance == 0) {
            isFatigue = true;
        }
    }

    public void info() {
        System.out.println("Скорость бега: " + speedRun);
        System.out.println("Скорость плавания: " + speedSwim);
        System.out.println("Выносливость: " + endurance);
        System.out.println();
    }

    public float run(int distance) {
        if (isFatigue) {
            System.out.println(name + " не имеет сил для Вашего бега");
            return 0;
        }

        System.out.println(this.name + " пытается пробежать");

        float time = (float) distance / speedRun;
        if (endurance < distance) {
            setEndurance(0);
            isFatigue = true;
            ++time;
            System.out.println(name + " испытывает состояние усталости");
        } else {
            setEndurance(endurance - distance);
        }

        System.out.println(name + " пробегает дистанцию за " + time + " секунды");

        return time;
    }

    public float swim(int distance) {
        if (isFatigue) {
            System.out.println("У животного больше нет сил для Вашего плавания");
            return 0;
        }

        System.out.println(name + " пытается проплыть");

        float time = (float) distance / speedSwim;
        if (endurance < distance) {
            setEndurance(0);
            isFatigue = true;
            ++time;
            System.out.println("Испытывает состояние усталости");
        } else {
            setEndurance(endurance - distance);
        }

        return time;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
}