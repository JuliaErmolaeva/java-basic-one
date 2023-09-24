package ru.otus.java.basic.lesson13;

public enum Terrain {

    // густой лес
    DENSE_FOREST("Густой лес"),

    // равнина
    PLAIN("Равнина"),

    // болото
    MARSH("Болото");

    private final String value;

    Terrain(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
