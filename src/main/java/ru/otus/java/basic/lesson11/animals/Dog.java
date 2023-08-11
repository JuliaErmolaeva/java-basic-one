package ru.otus.java.basic.lesson11.animals;

public class Dog extends Animal {

    public Dog(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public float swim(int distance) {
        float time = super.swim(distance * 2);
        if (time != 0) {
            System.out.println(this.name + " проплывает дистанцию за " + time + " секунды");
        }
        return time;
    }

    @Override
    public void info() {
        System.out.println("Собачка: " + name);
        super.info();
    }
}
