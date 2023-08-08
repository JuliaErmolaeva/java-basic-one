package ru.otus.java.basic.lesson11.models;

public class Horse extends Animal {

    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    public String swim(int distance) {
        if (getEndurance() == 0) {
            System.out.println("У лошадки больше нет сил для Вашего плавания");
            return "";
        }

        float time = (float) distance / getSpeedSwim();

        int endurance = getEndurance();
        int requiredEndurance = distance * 4;
        if (endurance < requiredEndurance) {
            setEndurance(0);
            ++time;
            System.out.println("У лошадки появилось состояние усталости");
        } else {
            setEndurance(endurance - requiredEndurance);
        }

        return String.valueOf(time);
    }

    @Override
    public void info() {
        System.out.println("Лошадка: " + getName());
        System.out.println("Скорость бега: " + getSpeedRun());
        System.out.println("Скорость плавания: " + getSpeedSwim());
        System.out.println("Выносливость: " + getEndurance());
        System.out.println();
    }
}
