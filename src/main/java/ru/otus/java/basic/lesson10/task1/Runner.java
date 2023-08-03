package ru.otus.java.basic.lesson10.task1;

public class Runner {

    public static int currentYear = 2023;

    public static void main(String[] args) {
        User[] users = {
                new User("Иванов", "Евгений", "Афанасьевич", 1973, "evgesha@mail.ru"),
                new User("Смирнова", "Ольга", "Вячеславовна", 1980, "olga777@mail.ru"),
                new User("Кожемячка", "Илья", "Тургарьевич", 1993, "powerman@mail.ru"),
                new User("Тушканчик", "Марина", "Дмитриевна", 1979, "tushkapushka@mail.ru"),
                new User("Коляда", "Наталья", "Сергеевна", 1962, "krasotka@mail.ru"),
        };
        for (User user : users) {
            int dateOfBirth = user.getDate();
            if ((currentYear - dateOfBirth) > 40) {
                user.print();
                System.out.println();
            }
        }
    }
}
