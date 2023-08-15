package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public abstract class Transport implements Action {

    TransportType transportType;
    int countEnergy;

    public Transport(TransportType transportType, int countEnergy) {
        this.transportType = transportType;
        this.countEnergy = countEnergy;
    }

    public Transport(TransportType transportType) {
        this.transportType = transportType;
    }

    public boolean doAction(int distance, Terrain terrain) {
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

    public String getTransportValueType() {
        return transportType.getValue();
    }
}
