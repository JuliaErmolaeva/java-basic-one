package ru.otus.java.basic.lesson10.task1;

public class User {
    private String lastName;
    private String name;
    private String patronymic;
    private int date;
    private String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String lastName, String name, String patronymic, int date, String email) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.date = date;
        this.email = email;
    }

    public void print() {
        System.out.println("ФИО: " + lastName + " " + name + " " + patronymic);
        System.out.println("Год рождения: " + date);
        System.out.println("e-mail: " + email);
    }
}
