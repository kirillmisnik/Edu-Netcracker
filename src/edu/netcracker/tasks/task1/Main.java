package edu.netcracker.tasks.task1;

import edu.netcracker.tasks.task1.dice.DiceGame;
import edu.netcracker.tasks.task1.equation.QuadraticEquation;
import edu.netcracker.tasks.task1.people.Address;
import edu.netcracker.tasks.task1.people.Person;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /* Задание 1 */

        // Создаем объект класса QuadraticEquation
        // С параметрами квадратного уравнения a, b и c
        QuadraticEquation quadraticEquation = new QuadraticEquation(2, 5, -3);
        // Сохраняем результат в коллецию TreeSet<Double>
        Set<Double> roots = quadraticEquation.solveEquation();
        // Если есть корни, выводим их
        // (при этом корней может быть как один, так и два)
        if (!roots.isEmpty()) {
            System.out.println("Корни уравнения:");
            for (Double root : roots) {
                System.out.println(root);
            }
        }
        // При желании можно создать объект вложенного в QuadraticEquation класса Discriminant
        // и использовать все методы этого класса
        QuadraticEquation.Discriminant discriminant = new QuadraticEquation.Discriminant(2, 5, -3);
        System.out.printf("Дискриминант: %f\n", discriminant.discriminant());

        /* Задание 2 */

        // Создание объекта класса DiceGame
        DiceGame diceGame = new DiceGame(3, 2);
        // Инициализация начала игры
        diceGame.startGame();

        /* Задание 3 */

        // Создание массивая объектов класса Person
        Person[] people = new Person[4];
        // Определение элементов массива
        people[0] = new Person("Кирилл", "Мисник",
                new Address("Россия", "Москва", "ул. Арбатская", 10),
                new GregorianCalendar(1999, 9, 30).getTime());
        people[1] = new Person("Иван", "Петров",
                new Address("Россия", "Новгород", "ул. Пушкина", 2),
                new GregorianCalendar(1987, 4, 16).getTime());
        people[2] = new Person("Никита", "Иванов",
                new Address("Россия", "Москва", "ул. Арбатская", 6),
                new GregorianCalendar(2001, 7, 7).getTime());
        people[3] = new Person("Владислав", "Обломов",
                new Address("Россия", "Пермь", "ул. Генералова", 9),
                new GregorianCalendar(1974, 11, 21).getTime());

        System.out.println("--- Осуществить поиск человека по фамилии ---");
        for (Person person : people) {
            if (person.getLastName().equals("Иванов")) {
                System.out.println(person.getLastName());
            }
        }
        System.out.println("--- Осуществить поиск человека по атрибуту адреса ---");
        Address targetAddress = new Address("Россия", "Новгород", "ул. Пушкина", 2);
        for (Person person : people) {
            if (person.getAddress().equals(targetAddress)) {
                System.out.printf("На %s проживает %s %s\n",
                        targetAddress.getStreet(), person.getLastName(), person.getFirstName());
            }
        }
        System.out.println("--- Вывести людей, родившихся между определенными датами ---");
        Date startDate = new GregorianCalendar(1970, 1, 1).getTime();
        Date endDate = new GregorianCalendar(1990, 1, 1).getTime();
        for (Person person : people) {
            if (person.getBirthDate().after(startDate) && person.getBirthDate().before(endDate)) {
                System.out.println(person.getLastName());
            }
        }
        System.out.println("--- Найти самого старого (молодого) человека ---");
        Person oldest = people[0];
        Person youngest = people[0];
        for (Person person : people) {
            if (person.getBirthDate().before(oldest.getBirthDate())) {
                oldest = person;
            } else if (person.getBirthDate().after(youngest.getBirthDate())) {
                youngest = person;
            }
        }
        System.out.printf("Самый старый: %s\n", oldest.getLastName());
        System.out.printf("Самый молодой: %s\n", youngest.getLastName());
        System.out.println("--- Найти людей, проживающих на одной улице. ---");
        String street = "ул. Арбатская";
        System.out.printf("На улице %s живут:\n", street);
        for (Person person : people) {
            if (person.getAddress().getStreet().equals(street)) {
                System.out.println(person.getLastName());
            }
        }
    }
}
