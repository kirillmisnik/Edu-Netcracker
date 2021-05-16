package ru.netcracker.tasks.se.serialization.serializable;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Вектор, реализованный на основе связанного списка. Сериализуемый.
 */
public class LinkedListVector implements Serializable {
    private final LinkedList<Double> vector = new LinkedList<>();

    public LinkedListVector(double[] vector) {
        setVector(vector);
    }

    public LinkedList<Double> getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        for (double elem : vector) {
            this.vector.add(elem);
        }
    }

    @Override
    public String toString() {
        return vector.toString();
    }
}
