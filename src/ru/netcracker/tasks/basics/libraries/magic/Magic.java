package ru.netcracker.tasks.basics.libraries.magic;

/**
 * Интерфейс, предназначенный для
 * перестановки цифр числа в обратном порядке.
 */
public interface Magic {
    /**
     * Устанавливает значение числа
     * @param x число
     */
    void setNumber(int x);

    /**
     * Возвращает значение числа
     * @return int число
     */
    int getNumber();

    /**
     * Переставляет цифры числа в обратном порядке.
     * @return измененное число
     */
    int doMagic();
}
