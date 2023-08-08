package ru.otus.java.basic.lesson11.models;

public class Dog extends Animal {

    public Dog(String name, int speedRun, int speedSwim, int endurance) {
        super(name, speedRun, speedSwim, endurance);
    }


    public String swim(int distance){
        if (getEndurance() == 0) {
            System.out.println("У собачки больше нет сил для Вашего плавания");
            return "";
        }

        float time = (float) distance / getSpeedSwim();

        int endurance = getEndurance();
        int requiredEndurance = distance * 2;
        if (endurance < requiredEndurance) {
            setEndurance(0);
            ++time;
            System.out.println("У собачки появилось состояние усталости");
        } else {
            setEndurance(endurance - requiredEndurance);
        }

        return String.valueOf(time);
    }
    @Override
    public void info() {
        System.out.println("Собачка: " + getName());
        System.out.println("Скорость бега: " + getSpeedRun());
        System.out.println("Выносливость: " + getEndurance());
        System.out.println();
    }
}
