package ru.netcracker.tasks.basics.libraries.dice;

/**
 * Интерфейс для игр. Игру можно провести,
 * объявить победителя
 * или получить массив с очками.
 */
public interface Game {
    /**
     * Инициализирует игру.
     */
    void playGame();
    /**
     * Выводит на экран сообщение
     * о победившем игроке.
     */
    void announceWinner();

    /**
     * Возвращает массив с очками.
     * Индекс в массиве соответсвует
     * ID игрока.
     * @return массив с очками
     */
    int[] getScores();
}
