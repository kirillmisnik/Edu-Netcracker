package edu.netcracker.tasks.task4;

import edu.netcracker.tasks.task4.analyzer.TextAnalyzer;
import edu.netcracker.tasks.task4.calendar.CalendarDate;
import edu.netcracker.tasks.task4.person.Person;
import edu.netcracker.tasks.task4.tree.BinaryTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /* Задание 1 */
        Person person = new Person(LocalDate.of(1999, 9, 30));
        System.out.println(person.toString());
        System.out.println(person.getFormattedDate("short"));
        System.out.println(person.getFormattedDate("full"));

        /* Задание 2 */
        CalendarDate date = new CalendarDate("19990930 1320");
        System.out.println(date.getAsDate());
        System.out.println(date.getAsCalendar().getTime());
        try {
            date = new CalendarDate("1999-09-30 13:20");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        /* Задание 3 */
        TextAnalyzer textAnalyzer = new TextAnalyzer("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Mauris porta, quam ac malesuada semper, justo augue venenatis ante.\n" +
                " Donec volutpat efficitur urna, at pharetra justo blandit nec.");
        System.out.println(textAnalyzer.inBoth(2));
        System.out.println(textAnalyzer.onlyInFirst(2));
        System.out.println(textAnalyzer.atLeastInOne(2));

        /* Задание 4 */
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(7);
        System.out.print("Центрированный обход: ");
        binaryTree.inOrder();
        System.out.print("\nОбратный обход: ");
        binaryTree.postOrder();
        System.out.print("\nПрямой обход: ");
        binaryTree.preOrder();
        System.out.println("\nРазмер древа: " + binaryTree.size());
    }
}
