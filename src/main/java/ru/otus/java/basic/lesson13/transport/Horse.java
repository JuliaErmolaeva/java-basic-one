package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Horse extends Transport {

    private static final Terrain[] IMPASSABLE_TERRAINS = {Terrain.MARSH};

    public Horse() {
        super(TransportType.HORSE, 2000, IMPASSABLE_TERRAINS);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        return super.move(distance, terrain);
    }
}
