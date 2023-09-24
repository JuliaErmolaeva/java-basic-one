package ru.otus.java.basic.lesson13;

import ru.otus.java.basic.lesson13.transport.AllTerrainVehicle;
import ru.otus.java.basic.lesson13.transport.Bike;
import ru.otus.java.basic.lesson13.transport.Car;
import ru.otus.java.basic.lesson13.transport.Horse;

public class MainApp {

    public static void main(String[] args) {
        Human petrovic = new Human("Петрович");

        Bike bike = new Bike();
        Bike bike1 = new Bike();
        petrovic.getInTransport(bike);
        petrovic.getInTransport(bike1);
        petrovic.useTransport(-200,Terrain.DENSE_FOREST);
        petrovic.useTransport(200,Terrain.DENSE_FOREST);
        petrovic.useTransport(400,Terrain.MARSH);
        petrovic.useTransport(100,Terrain.PLAIN);
        petrovic.useTransport(4000,Terrain.PLAIN);
        petrovic.getOutTransport();
        System.out.println();

        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle();
        petrovic.getInTransport(allTerrainVehicle);
        petrovic.useTransport(400, Terrain.DENSE_FOREST);
        petrovic.useTransport(400, Terrain.MARSH);
        petrovic.useTransport(500, Terrain.PLAIN);
        petrovic.useTransport(4000, Terrain.PLAIN);
        petrovic.getOutTransport();
        System.out.println();

        Car car = new Car();
        petrovic.getInTransport(car);
        petrovic.useTransport(400, Terrain.DENSE_FOREST);
        petrovic.useTransport(400, Terrain.MARSH);
        petrovic.useTransport(500, Terrain.PLAIN);
        petrovic.useTransport(4000, Terrain.PLAIN);
        petrovic.getOutTransport();
        System.out.println();

        Horse horse = new Horse();
        petrovic.getInTransport(horse);
        petrovic.useTransport(400, Terrain.DENSE_FOREST);
        petrovic.useTransport(400, Terrain.MARSH);
        petrovic.useTransport(500, Terrain.PLAIN);
        petrovic.useTransport(4000, Terrain.PLAIN);
        petrovic.getOutTransport();
        System.out.println();

        petrovic.useTransport(400, Terrain.MARSH);
    }
}
