package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public class Bike extends Transport {

    public Bike() {
        super(TransportType.BIKE, new Terrain[]{Terrain.MARSH});
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (isTerrainNotAvailable(terrain)) {
            return false;
        }
        if (distance < 0) {
            System.out.println("Задайте нормальное значение дистанции");
            return false;
        } else {
            System.out.println("Катаюсь на " + getTransportValueType() + " расстояние в " + distance + " метров" + " в " + terrain.getValue());
            return true;
        }
    }
}
