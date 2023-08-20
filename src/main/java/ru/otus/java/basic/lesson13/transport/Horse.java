package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Horse extends Transport {

    public Horse() {
        super(TransportType.HORSE, 2000, new Terrain[]{Terrain.MARSH});
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        return super.move(distance, terrain);
    }
}
