package ru.otus.java.basic.lesson13.transport;

import ru.otus.java.basic.lesson13.Terrain;

public interface Action {

    boolean doAction(int distance, Terrain terrain);
}
