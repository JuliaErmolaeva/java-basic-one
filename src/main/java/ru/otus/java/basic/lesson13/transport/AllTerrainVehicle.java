package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class AllTerrainVehicle extends Transport {

    private static final Terrain [] impassableTerrains = {};

    public AllTerrainVehicle() {
        super(TransportType.ALL_TERRAIN_VEHICLE, 5000, impassableTerrains);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        return super.move(distance, terrain);
    }
}
