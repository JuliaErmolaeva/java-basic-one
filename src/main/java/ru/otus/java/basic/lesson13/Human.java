package ru.otus.java.basic.lesson13;

import ru.otus.java.basic.lesson13.transport.Transport;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public boolean useTransport(int distance, Terrain terrain) {
        if (currentTransport == null) {
            return walk(distance, terrain);
        }
        return currentTransport.doAction(distance, terrain);
    }

    private boolean walk(int distance, Terrain terrain) {
        System.out.println(name + " идёт пешком " + distance + " метров через " + terrain.getValue());
        return true;
    }

    // выйти из транспорта
    public void getOutTransport() {
        if (currentTransport != null) {
            System.out.println(name + " перестал использовать " + currentTransport.getTransportValueType());
            currentTransport = null;
        } else {
            System.out.println(name + " еще ничего не использует");
        }
    }

    //сесть в транспорт
    public void getInTransport(Transport transport) {
        if (currentTransport == null) {
            currentTransport = transport;
            System.out.println(name + " использует " + currentTransport.getTransportValueType());
        } else {
            System.out.println(name + " уже использует " + currentTransport.getTransportValueType());
        }
    }
}
