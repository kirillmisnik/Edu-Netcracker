package edu.netcracker.tasks.se.task1.serializable;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Вектор, реализованный на основе массивов. Сериализуемый.
 */
public class ArrayVector implements Serializable {
    private double[] vector;

    public ArrayVector(double[] vector) {
        this.vector = vector;
    }

    public double[] getVector() {
        return this.vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}
