package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Car extends Transport {

    public Car() {
        super(TransportType.CAR, 4000, new Terrain[]{Terrain.DENSE_FOREST, Terrain.MARSH});
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        return super.move(distance, terrain);
    }
}
