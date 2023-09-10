package ru.otus.java.basic.lesson16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainApp {

    // K - fio, V - set phoneBook
    private static Map<String, Set<PhoneBook>> phonebook = new HashMap<>();

    public static void main(String[] args) {
        add("Иванов Иван Иванович", "111", "+777");
        add("Иванов Иван Иванович", "111", "+888");
        add("Иванов Иван Иванович", "222", "+999");
        add("Петров Саня Попович", "333", "+111");
        add("Маркин Миша Сидорович", "555", "+222");
        add("Маркин Миша Сидорович", "555", "+444");
        System.out.println();


        Set<String> phonesByFio = findPhonesByFio("Иванов Иван Иванович", "111");
        System.out.println(phonesByFio);

        System.out.println(containsPhoneNumber("+333"));
    }

    private static void add(String fio, String documentNumber, String phoneNumber) {
        PhoneBook element = new PhoneBook(fio, documentNumber, phoneNumber);

        if (phonebook.containsKey(fio)) {
            Set<PhoneBook> set = phonebook.get(fio);
            set.add(element);
        } else {
            Set<PhoneBook> set = new HashSet<>();
            set.add(element);
            phonebook.put(fio, set);
        }
    }

    private static Set<String> findPhonesByFio(String fio, String documentNumber) {
        Set<String> phones = new HashSet<>();
        for (Map.Entry<String, Set<PhoneBook>> fioPhones : phonebook.entrySet()) {
            if (fio.equals(fioPhones.getKey())) {
                for (PhoneBook phoneBook : fioPhones.getValue()) {
                    if (documentNumber.equals(phoneBook.getDocumentNumber())) {
                        phones.add(phoneBook.getPhoneNumber());
                    }
                }
            }
        }

        return phones;
    }

    private static boolean containsPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, Set<PhoneBook>> fioPhones : phonebook.entrySet()) {
            for (PhoneBook phoneBook : fioPhones.getValue()) {
                if (phoneNumber.equals(phoneBook.getPhoneNumber())) {
                    return true;
                }
            }
        }
        return false;
    }
}
