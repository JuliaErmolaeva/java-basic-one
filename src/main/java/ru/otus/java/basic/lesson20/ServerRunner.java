package ru.otus.java.basic.lesson20;

import ru.otus.java.basic.lesson20.impl.Server;

public class ServerRunner {
    private static final int port = 8080;

    public static void main(String[] args) {
        Server.run(port);
    }
}
