package ru.otus.java.basic.lesson16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    // K - fio, V - set phoneBookElement
    public Map<String, Set<PhoneBookElement>> phonebook;

    public PhoneBook() {
        phonebook = new HashMap<>();
    }

    void add(String fio, String documentNumber, String phoneNumber) {
        PhoneBookElement element = new PhoneBookElement(fio, documentNumber, phoneNumber);

        if (phonebook.containsKey(fio)) {
            Set<PhoneBookElement> phoneBookElements = phonebook.get(fio);
            phoneBookElements.add(element);
        } else {
            Set<PhoneBookElement> phoneBookElements = new HashSet<>();
            phoneBookElements.add(element);
            phonebook.put(fio, phoneBookElements);
        }
    }

    Set<String> findPhonesByFio(String fio, String documentNumber) {
        Set<String> phones = new HashSet<>();
        for (PhoneBookElement phoneBook : phonebook.get(fio)) {
            if (documentNumber.equals(phoneBook.getDocumentNumber())) {
                phones.add(phoneBook.getPhoneNumber());
            }
        }

        return phones;
    }

    boolean containsPhoneNumber(String phoneNumber) {
        for (Set<PhoneBookElement> phoneBooks : phonebook.values()) {
            for (PhoneBookElement phoneBook : phoneBooks) {
                if (phoneNumber.contains(phoneBook.getPhoneNumber())) {
                    return true;
                }
            }
        }
        return false;
    }
}
