package ru.netcracker.tasks.basics.libraries.dice;

/**
 * Интерфейс, определяющий методы
 * для работы с игральными костями.
 */
public interface Dice {
    /**
     * Возвращает сумму всех бросков
     * игральной кости.
     * @return int сумма всех бросков
     */
    int diceSum(int k);

    /**
     * Возвращает результат броска
     * шестигранной игральной кости.
     * @return int значение броска кости
     */
    int rollTheDice();
}
