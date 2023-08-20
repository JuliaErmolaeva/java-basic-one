package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public interface Move {

    boolean move(int distance, Terrain terrain);
}
