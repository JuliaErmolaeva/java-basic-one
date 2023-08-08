package ru.otus.java.basic.lesson11;

import ru.otus.java.basic.lesson11.models.Cat;
import ru.otus.java.basic.lesson11.models.Dog;
import ru.otus.java.basic.lesson11.models.Horse;

public class Runner {

    public static void main(String[] args) {
        Cat cat = new Cat("Маруся", 4, 10);

        cat.info();
        System.out.println(cat.swim(10));

        System.out.println(cat.getName() + " пробегает дистанцию за " + cat.run(5) + " секунды");
        System.out.println();

        cat.info();
        System.out.println(cat.getName() + " тяжело дыша пробегает дистанцию за " + cat.run(10) + " секунды");
        System.out.println();

        cat.info();
        System.out.println(cat.run(5));

        cat.info();

        Dog dogRun = new Dog("Мадам", 20, 4, 40);

        dogRun.info();
        System.out.println(dogRun.getName()+ " пробегает дистанцию за " + dogRun.run(20) + " секунды");
        System.out.println();

        dogRun.info();
        System.out.println(dogRun.getName()+ " устало пробегает дистанцию за " + dogRun.run(25) + " секунды");
        System.out.println();

        dogRun.info();
        System.out.println(dogRun.run(10));

        dogRun.info();
        System.out.println(dogRun.swim(10));

        Dog dogSwim = new Dog("Плюшка", 18,3,37);

        dogSwim.info();
        System.out.println(dogSwim.getName()+ " проплывает дистанцию за " + dogSwim.swim(15)+ " секунды");
        System.out.println();

        dogSwim.info();
        System.out.println(dogSwim.getName()+ " медленно преодолевает дистанцию за " + dogSwim.swim(5) + " секунды");
        System.out.println();

        dogSwim.info();
        System.out.println(dogSwim.swim(3));

        Horse horse = new Horse("Конфуций", 11, 2, 53);

        horse.info();
        System.out.println(horse.getName()+ " пробегает дистанцию за " + horse.run(25) + " секунды");
        System.out.println();

        horse.info();
        System.out.println(horse.getName()+ " проплыл дистанцию за " + horse.swim(10) + " секунды");
        System.out.println();

        horse.info();
        System.out.println(horse.run(10));

    }
}