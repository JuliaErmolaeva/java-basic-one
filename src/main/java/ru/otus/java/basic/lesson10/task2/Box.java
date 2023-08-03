package ru.otus.java.basic.lesson10.task2;

public class Box {
    private String color;
    private int size;
    private boolean isOpen;
    private String item;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Коробку перекрасили в " + this.color + " цвет");
    }

    public int getSize() {
        return size;
    }

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public void showItem() {
        if (this.item == null) {
            System.out.println("Коробка пустая");
        } else {
            System.out.println("В коробке: " + this.item);
        }
    }

    public void printInfo() {
        System.out.println("Коробка\nЦвет: " + color);
        System.out.println("Размер: " + size);
    }

    public void open() {
        System.out.println("Коробку открыли");
        this.isOpen = true;
    }

    public void close() {
        System.out.println("Коробку закрыли");
        this.isOpen = false;
    }

    public void putItem(String item) {
        if (this.isOpen && this.item == null) {
            this.item = item;
            System.out.println("В коробку положили: " + this.item);
        } else {
            System.out.println("Коробка закрыта или не пуста");
        }
    }

    public void throwItem() {
        if (this.isOpen && this.item != null) {
            System.out.println("Из коробки взяли: " + this.item);
            this.item = null;
        } else {
            System.out.println("Коробка закрыта или пуста");
        }
    }
}
