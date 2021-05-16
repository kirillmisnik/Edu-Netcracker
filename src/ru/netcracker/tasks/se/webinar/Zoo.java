package ru.netcracker.tasks.se.webinar;

public class Zoo {
    public static void main(String args[]) {
        final Monkey monkey = new Monkey();
        for (int i = 0; i < 38; i++) {
            monkey.measure(new Parrot());
            monkey.done();
        }
    }
}
