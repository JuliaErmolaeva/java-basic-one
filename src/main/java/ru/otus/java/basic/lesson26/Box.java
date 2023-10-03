package ru.otus.java.basic.lesson26;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    //метод добавления фрукта в коробку
    public <E extends T> void add(E element) {
        fruits.add(element);
    }

    //метод weight, вычисляющий вес коробки
    public double weight() {
        if (fruits.size() < 1) {
            return 0.0;
        }

        double weightBox = 0;
        for (T fruit : fruits) {
            weightBox += fruit.getWeight();
        }
        return weightBox;
    }

    //метод compare, позволяющий сравнить текущую коробку с переданной
    public boolean compare(Box<? extends Fruit> box) {
        return box != null && Math.abs(this.weight() - box.weight()) < 0.0001;
    }

    //метод, позволяющий пересыпать фрукты из текущей коробки в другую
    public void moveFruitsTo(Box<? super T> destinationBox) {
        if (this != destinationBox && destinationBox != null) {
            fruits.forEach(destinationBox::add);
            fruits.clear();
        }
    }
}
