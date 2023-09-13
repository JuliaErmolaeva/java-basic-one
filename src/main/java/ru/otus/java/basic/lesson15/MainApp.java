package ru.otus.java.basic.lesson15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> arrayRange = fillArrayRange(5, 10);
        System.out.println(arrayRange);

        elementIncrease(5, arrayRange);
        System.out.println(arrayRange);

        System.out.println(sumArray(arrayRange));

        rewriteArray(5, arrayRange);
        System.out.println(arrayRange);

        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Gerasim", 54),
                new Employee("Madonna", 32),
                new Employee("Vova", 19),
                new Employee("Sofia", 24),
                new Employee("Petya", 43),
                new Employee("Alenka", 55))
        );
        List<String> listNames = getListNames(employees);
        System.out.println(listNames);

        System.out.println(getEmployeesMoreOrEqualMinAge(employees, 25));

        checkEmployeesAverageAgeMoreInputAge(employees, 30);
        checkEmployeesAverageAgeMoreInputAge(employees, 39);

        System.out.println(getYoungestEmployee(employees));
    }

    private static List<Integer> fillArrayRange(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    private static int sumArray(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            if (integer > 5) {
                sum += integer;
            }
        }
        return sum;
    }

    private static void rewriteArray(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }
    }

    private static void elementIncrease(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
    }

    private static List<String> getListNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    private static List<Employee> getEmployeesMoreOrEqualMinAge(List<Employee> employees, int minAge) {
        List<Employee> oldEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                oldEmployees.add(employee);
            }
        }
        return oldEmployees;
    }

    private static void checkEmployeesAverageAgeMoreInputAge(List<Employee> employees, int averageAge) {
        int averageAgeEmployees = getAverageAgeEmployees(employees);
        if (averageAgeEmployees > averageAge) {
            System.out.println("Средний возраст сотрудников = " + averageAgeEmployees + " больше указанного = " + averageAge);
        } else {
            System.out.println("Средний возраст сотрудников = " + averageAgeEmployees + " не больше указанного = " + averageAge);
        }
    }

    private static int getAverageAgeEmployees(List<Employee> employees) {
        int sumAge = 0;
        for (Employee employee : employees) {
            sumAge += employee.getAge();
        }
        return sumAge / employees.size();
    }

    private static Employee getYoungestEmployee(List<Employee> employees) {
        Employee minEmployee = new Employee(null, Integer.MAX_VALUE);
        for (Employee employee : employees) {
            if (minEmployee.getAge() > employee.getAge()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }
}
