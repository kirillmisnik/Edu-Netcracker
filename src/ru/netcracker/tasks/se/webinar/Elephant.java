package ru.netcracker.tasks.se.webinar;

public class Elephant {
    public final Integer getParrotsCount() { return 19;
    }
    public synchronized void done() {
        if (getParrotsCount() == 42) {
            // The goal is to reach this line
            System.out.println("It's 42, Baby!");
        }
    }
}
