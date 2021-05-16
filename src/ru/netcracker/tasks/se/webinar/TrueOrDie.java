package ru.netcracker.tasks.se.webinar;

public class TrueOrDie {
    public static void main(String args[]) {
        checkIfTrueEqualsFalse();
    }
    private static void checkIfTrueEqualsFalse(){
        if("True".equals("False")){
            // The goal is to reach this line
            System.out.println("Something went wrong here again...");
        } }
}
