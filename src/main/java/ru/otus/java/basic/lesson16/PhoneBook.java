package ru.otus.java.basic.lesson16;

import java.util.Objects;

public class PhoneBook {
    private String fio;
    private String documentNumber;
    private String phoneNumber;

    public PhoneBook(String fio, String documentNumber, String phoneNumber) {
        this.fio = fio;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(fio, phoneBook.fio) && Objects.equals(documentNumber, phoneBook.documentNumber) && Objects.equals(phoneNumber, phoneBook.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, documentNumber, phoneNumber);
    }
}
