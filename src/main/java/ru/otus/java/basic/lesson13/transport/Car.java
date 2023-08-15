package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Car extends Transport {

    public Car() {
        super(TransportType.CAR, 4000);
    }

    @Override
    public boolean doAction(int distance, Terrain terrain) {
        if (Terrain.DENSE_FOREST.equals(terrain) || Terrain.MARSH.equals(terrain)) {
            System.out.println(transportType.getValue() + " не может проехать через " + terrain.getValue());
            return false;
        }
        return super.doAction(distance, terrain);
    }
}
