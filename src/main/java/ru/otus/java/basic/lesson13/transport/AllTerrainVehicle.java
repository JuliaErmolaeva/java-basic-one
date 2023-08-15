package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class AllTerrainVehicle extends Transport {

    public AllTerrainVehicle() {
        super(TransportType.ALL_TERRAIN_VEHICLE, 5000);
    }

    @Override
    public boolean doAction(int distance, Terrain terrain) {
        return super.doAction(distance, terrain);
    }
}
