package ru.netcracker.tasks.se.webinar;

import java.util.HashSet;
import java.util.Set;

public class Monkey {
    private static final double CAPACITY = 7.6;
    private Set<Parrot> parrots = new HashSet<Parrot>(); public synchronized void measure(Parrot p) {
        if (parrots.size() >= CAPACITY) {
            throw new IllegalStateException("I'm no longer than " +
                    parrots.size() + " parrots"); } else {
            parrots.add(p);
        }
    }
    public synchronized void done() {
        if (parrots.size() == 38) {
            // The goal is to reach this line
            System.out.println("I'm a 38-parrots-length Monkey!");
        } }
}
