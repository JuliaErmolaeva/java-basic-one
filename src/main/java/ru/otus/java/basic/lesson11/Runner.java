package ru.otus.java.basic.lesson11;

import ru.otus.java.basic.lesson11.animals.Cat;
import ru.otus.java.basic.lesson11.animals.Dog;
import ru.otus.java.basic.lesson11.animals.Horse;

public class Runner {

    public static void main(String[] args) {
        Cat cat = new Cat("Маруся", 4, 10);

        cat.info();
        cat.swim(10);
        System.out.println();

        cat.run(5);
        System.out.println();

        cat.info();
        cat.run(10);
        System.out.println();

        cat.info();
        cat.run(5);
        System.out.println();

        cat.info();

        Dog dogRun = new Dog("Мадам", 20, 4, 40);

        dogRun.info();
        dogRun.run(20);
        System.out.println();

        dogRun.info();
        dogRun.run(25);
        System.out.println();

        dogRun.info();
        dogRun.run(10);
        System.out.println();

        dogRun.info();
        dogRun.swim(10);
        System.out.println();

        Dog dogSwim = new Dog("Плюшка", 18, 3, 37);

        dogSwim.info();
        dogSwim.swim(15);
        System.out.println();

        dogSwim.info();
        dogSwim.swim(5);
        System.out.println();

        dogSwim.info();
        dogSwim.swim(3);
        System.out.println();

        Horse horse = new Horse("Конфуций", 11, 2, 53);

        horse.info();
        horse.run(25);
        System.out.println();

        horse.info();
        horse.swim(10);
        System.out.println();

        horse.info();
        horse.run(10);
        System.out.println();

    }
}