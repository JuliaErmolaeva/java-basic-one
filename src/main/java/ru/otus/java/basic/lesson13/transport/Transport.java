package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public abstract class Transport implements Move {

    TransportType transportType;
    int countEnergy;
    Terrain[] impassableTerrains;

    public Transport(TransportType transportType, int countEnergy, Terrain[] impassableTerrains) {
        this.transportType = transportType;
        this.countEnergy = countEnergy;
        this.impassableTerrains = impassableTerrains;
    }

    public Transport(TransportType transportType, Terrain[] impassableTerrains) {
        this.transportType = transportType;
        this.impassableTerrains = impassableTerrains;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (isTerrainNotAvailable(terrain)) {
            return false;
        }
        if (distance < 0) {
            System.out.println("Задайте нормальное значение дистанции");
            return false;
        }
        if (distance > 0 && distance < countEnergy) {
            countEnergy -= distance;
            System.out.println("Катаюсь на " + getTransportValueType() + " расстояние в " + distance + " метров в " + terrain.getValue());
            return true;
        } else {
            System.out.println("У " + transportType.getValue() + " не хватает энергии");
            return false;
        }
    }

    protected boolean isTerrainNotAvailable(Terrain terrain) {
        if (impassableTerrains == null || impassableTerrains.length == 0) {
            return true;
        }
        for (Terrain impassableTerrain : impassableTerrains) {
            if (impassableTerrain.equals(terrain)) {
                System.out.println(transportType.getValue() + " не может проехать через " + terrain.getValue());
                return true;
            }
        }
        return false;
    }

    public String getTransportValueType() {
        return transportType.getValue();
    }
}
