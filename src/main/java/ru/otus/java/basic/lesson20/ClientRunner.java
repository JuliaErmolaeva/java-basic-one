package ru.otus.java.basic.lesson20;

import ru.otus.java.basic.lesson20.impl.Client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientRunner {
    private static final int port = 8080;

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        Client.run(localHost.getHostAddress(), port);
    }
}
