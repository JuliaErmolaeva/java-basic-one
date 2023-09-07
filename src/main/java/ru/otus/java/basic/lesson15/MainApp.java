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

        System.out.println(getEmployeesMoreThanMinAge(employees, 25));

        System.out.println(getEmployeesOlderAverageAge(employees, getAverageAge(employees)));

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
            sum += integer;
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

    private static List<Employee> getEmployeesMoreThanMinAge(List<Employee> employees, int minAge) {
        List<Employee> oldEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                oldEmployees.add(employee);
            }
        }
        return oldEmployees;
    }

    private static List<Employee> getEmployeesOlderAverageAge(List<Employee> employees, int averageAge) {
        List<Employee> employeesOlderAverageAge = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > averageAge) {
                employeesOlderAverageAge.add(employee);
            }
        }
        return employeesOlderAverageAge;
    }

    private static int getAverageAge(List<Employee> employees) {
        int sumAge = 0;
        for (Employee employee : employees) {
            sumAge += employee.getAge();
        }
        int averageAge = sumAge / employees.size();
        System.out.println("Average age is " + averageAge);
        return averageAge;
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
