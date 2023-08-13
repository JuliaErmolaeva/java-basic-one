package ru.otus.java.basic.lesson12;

public class Plate {
    private int maxVolume;
    private int currentFood;

    public Plate(int currentFood) {
        this.currentFood = currentFood;
        this.maxVolume = currentFood;
    }

    public void addFood(int food) {
        if (food <= 0) {
            System.out.println("В тарелку нечего положить");
            return;
        }
        if (currentFood == maxVolume) {
            System.out.println("Тарелка полностью наполнена");
            return;
        }
        if (currentFood + food >= maxVolume) {
            currentFood = maxVolume;
        } else {
            currentFood = currentFood + food;
        }
    }

    boolean decreaseFood(int eatUp) {
        if ((currentFood - eatUp) >= 0) {
            currentFood -= eatUp;
            return true;
        } else {
            return false;
        }
    }
}