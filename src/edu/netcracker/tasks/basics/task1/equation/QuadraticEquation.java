package edu.netcracker.tasks.basics.task1.equation;

import java.util.Set;
import java.util.TreeSet;

/**
 * Класс QuadraticEquation предназначен для нахождения
 * действительных корней квадратных уравнений.
 * @author Кирилл Мисник
 */
public class QuadraticEquation {

    private final double a;
    private final double b;
    private final Discriminant discriminant;

    /**
     * Конструктор QuadraticEquation.
     * @param a параметр a квадратного уравнения
     * @param b параметр b квадратного уравнения
     * @param c параметр c квадратного уравнения
     */
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.discriminant = new Discriminant(this.a, this.b, c);
    }

    /**
     * Метод solveEquation возвращает корни квадратного уравнения
     * в виде TreeSet<Double>. Если таковых нет, выводит
     * соответствующее сообщение в консоль и возвращает пустое значение.
     * @return TreeSet<Double> Коллекция корней уравнения
     */
    public Set<Double> solveEquation() {
        Set<Double> roots = new TreeSet<>();
        if (this.discriminant.isValidDiscriminant()) {
            double x1 = (-this.b - this.discriminant.rootOfDiscriminant()) / (2 * this.a);
            double x2 = (-this.b + this.discriminant.rootOfDiscriminant()) / (2 * this.a);

            roots.add(x1);
            roots.add(x2);
        } else {
            System.out.printf("Дискриминант %f меньше нуля!", this.discriminant.discriminant());
        }
        return roots;
    }

    /**
     * Класс Discriminant предназначен для нахождения
     * дискриминанта в квадратных уравнениях.
     * @author Кирилл Мисник
     * @see QuadraticEquation
     */
    public static class Discriminant {
        private final double a;
        private final double b;
        private final double c;

        /**
         * Конструктор Discriminant.
         * @param a параметр a квадратного уравнения
         * @param b параметр b квадратного уравнения
         * @param c параметр c квадратного уравнения
         */
        public Discriminant(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        /**
         * Метод discriminant предназначен для
         * нахождения дискриминанта.
         * @return double дискриминант
         */
        public double discriminant() {
            return Math.pow(this.b, 2) - 4 * this.a * this.c;
        }

        /**
         * Метод rootOfDiscriminant предназначен для
         * нахождения корня из дискриминанта.
         * @return double корень из дискриминанта
         */
        public double rootOfDiscriminant() {
            return Math.sqrt(discriminant());
        }

        /**
         * Метод isValidDiscriminant предназначен для определения
         * есть ли у уравнения действительные корни.
         * @return boolean true - если действительные корни есть, false - если нет
         */
        private boolean isValidDiscriminant() {
            return this.discriminant() >= 0;
        }
    }
}
