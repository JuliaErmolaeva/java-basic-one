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

    //метод weight, который высчитывает вес коробки
    public double weight() {
        double weightBox;

        if (fruits.size() < 1) {
            return 0.0;
        }

        double weightApple = 0;
        int countApples = 0;

        double weightOrange = 0;
        int countOranges = 0;

        for (T fruit : fruits) {
            if (fruit instanceof Apple) {
                weightApple = fruit.getWeight();
                countApples++;
            }
            if (fruit instanceof Orange) {
                weightOrange = fruit.getWeight();
                countOranges++;
            }
        }

        return (weightApple * countApples) + (weightOrange * countOranges);
    }

    //метод compare, позволяющий сравнить текущую коробку с переданной
    public boolean compare(Box<? extends Fruit> box) {
        return box != null && Math.abs(this.weight() - box.weight()) < 0.0001;
    }

    //метод, позволяющий пересыпать фрукты из текущей коробки в другую
    public void moveFruictsTo(Box<? super T> destinationBox) {
        if (this != destinationBox && destinationBox != null) {
            fruits.forEach(destinationBox::add);
            fruits.clear();
        }
    }
}
