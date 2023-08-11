package ru.otus.java.basic.lesson11.animals;

public class Horse extends Animal {

    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public float swim(int distance) {
        float time = super.swim(distance * 4);
        if (time != 0) {
            System.out.println(this.name + " проплывает дистанцию за " + time + " секунды");
        }
        return time;
    }

    @Override
    public void info() {
        System.out.println("Лошадка: " + name);
        super.info();
    }
}
