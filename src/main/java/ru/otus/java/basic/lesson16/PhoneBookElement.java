package ru.otus.java.basic.lesson16;

import java.util.Objects;

public class PhoneBookElement {

    private String fio;
    private String documentNumber;
    private String phoneNumber;

    public PhoneBookElement(String fio, String documentNumber, String phoneNumber) {
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
        PhoneBookElement that = (PhoneBookElement) o;
        return Objects.equals(fio, that.fio) && Objects.equals(documentNumber, that.documentNumber) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, documentNumber, phoneNumber);
    }
}
