package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Horse extends Transport {

    public Horse() {
        super(TransportType.HORSE, 2000);
    }

    @Override
    public boolean doAction(int distance, Terrain terrain) {
        if (Terrain.MARSH.equals(terrain)) {
            System.out.println(transportType.getValue() + " не может проехать через " + terrain.getValue());
            return false;
        }
        return super.doAction(distance, terrain);
    }
}
