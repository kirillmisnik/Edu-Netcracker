package ru.netcracker.tasks.basics.webinar;

public class Equals {
    public static void main(String[] args) {
        Integer i = 42;
        Integer j = 42;
        java.lang.System.out.println(i + " = " + j + " : " + (i == j));
        i = 142;
        j = 142;
        java.lang.System.out.println(i + " = " + j + " : " + (i == j));
    }
}
