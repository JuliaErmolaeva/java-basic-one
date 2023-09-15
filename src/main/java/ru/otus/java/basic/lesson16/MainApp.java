package ru.otus.java.basic.lesson16;

import java.util.Set;

public class MainApp {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов Иван Иванович", "111", "+777");
        phoneBook.add("Иванов Иван Иванович", "111", "+888");
        phoneBook.add("Иванов Иван Иванович", "222", "+999");
        phoneBook.add("Петров Саня Попович", "333", "+111");
        phoneBook.add("Маркин Миша Сидорович", "555", "+222");
        phoneBook.add("Маркин Миша Сидорович", "555", "+444");

        Set<String> phonesByFio = phoneBook.findPhonesByFio("Иванов Иван Иванович", "111");
        System.out.println(phonesByFio);

        System.out.println(phoneBook.containsPhoneNumber("+333"));
        System.out.println(phoneBook.containsPhoneNumber("+222"));
    }
}
