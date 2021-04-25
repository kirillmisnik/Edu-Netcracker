package edu.netcracker.tasks.task2.extended;

import java.util.Objects;

public class ExtendedClass {
    public byte b;
    public int i;
    public double d;
    public String s;

    public ExtendedClass(byte b, int i, double d, String s) {
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtendedClass that = (ExtendedClass) o;
        return b == that.b && i == that.i && Double.compare(that.d, d) == 0 && Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, i, d, s);
    }

    /**
     * Преобразует объект класса в строку,
     * в формате: "-b: b; -i: i; -d: d; -s: s.
     */
    @Override
    public String toString() {
        return String.format("-b: %d; -i: %d; -d: %f; -s: %s.",
                this.b, this.i, this.d, this.s);
    }
}
