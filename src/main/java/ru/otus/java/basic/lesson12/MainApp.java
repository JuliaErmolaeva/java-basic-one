package ru.otus.java.basic.lesson12;

public class MainApp {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        plate.addFood(20);

        Cat mimi = new Cat("Mimi", 70);
        mimi.eat(plate);
        mimi.info();

        plate.addFood(20);
        mimi.eat(plate);
        mimi.info();

        Plate vedro = new Plate(200);
        Cat[] cats = fillCats();
        for (Cat cat : cats) {
            cat.eat(vedro);
            cat.info();
        }
    }

    private static Cat[] fillCats() {
        return new Cat[]{
                new Cat("Murzik", 80),
                new Cat("Musya", 60),
                new Cat("Barsik", 30),
                new Cat("Bulka", 100)
        };
    }
}