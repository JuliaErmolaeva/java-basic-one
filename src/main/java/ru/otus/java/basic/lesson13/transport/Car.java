package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Car extends Transport {

    private static final Terrain [] IMPASSABLE_TERRAINS = {Terrain.DENSE_FOREST, Terrain.MARSH};

    public Car() {
        super(TransportType.CAR, 4000, IMPASSABLE_TERRAINS);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        return super.move(distance, terrain);
    }
}
