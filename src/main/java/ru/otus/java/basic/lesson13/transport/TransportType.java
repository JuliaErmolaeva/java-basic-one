package ru.otus.java.basic.lesson13.transport;

public enum TransportType {

    BIKE("Лесипед"),

    CAR("Бибика"),

    ALL_TERRAIN_VEHICLE("Вездюшка"),

    HORSE("Лошадка");

    private final String value;

    TransportType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
