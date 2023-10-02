package ru.otus.java.basic.lesson26;



public class MainApp {
    public static void main(String[] args) {
        Box<Apple> boxApples = new Box<>();
        boxApples.add(new Apple(2d));
        boxApples.add(new Apple(2d));
        boxApples.add(new Apple(2d));


        Box<Fruit> boxFruits = new Box<>();
        boxFruits.add(new Apple(2d));
        boxFruits.add(new Apple(2d));
        boxFruits.add(new Orange(6d));
        boxFruits.add(new Orange(6d));


        Box<Orange> boxOranges = new Box<>();
        boxOranges.add(new Orange(6d));

        System.out.println(boxApples.weight());
        System.out.println(boxFruits.weight());
        System.out.println(boxOranges.weight());

        System.out.println(boxFruits.compare(boxOranges));
        System.out.println(boxOranges.compare(boxFruits));
        System.out.println(boxOranges.compare(boxApples));


        Box<Orange> boxOranges2 = new Box<>();
        boxOranges.add(new Orange(6d));
        boxOranges.add(new Orange(6d));
        boxOranges.add(new Orange(6d));

        boxOranges.moveFruictsTo(boxOranges2);
        System.out.println(boxOranges.weight());
        System.out.println(boxOranges2.weight());

        boxOranges2.moveFruictsTo(boxFruits);
        System.out.println(boxOranges2.weight());
        System.out.println(boxFruits.weight());

        boxApples.moveFruictsTo(boxFruits);
        System.out.println(boxApples.weight());
        System.out.println(boxFruits.weight());
    }
}
