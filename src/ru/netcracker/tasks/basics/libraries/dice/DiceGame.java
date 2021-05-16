package ru.netcracker.tasks.basics.libraries.dice;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Игра в кости. Играют N игроков (компьютер в списке последний).
 * Подкидываются одновременно К кубиков.
 * Выигрывает тот, у кого большая сумма очков.
 * Кто выиграл, тот и кидает первым в следующем кону.
 * Чтобы игроку сделать бросок, необходимо нажать
 * клавишу перехода на новую строку.
 * Игра идет до 7 выигрышей.
 * Игру начинает Игрок 1.
 */
public class DiceGame implements Game, Dice {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private final int n;
    private final int k;

    /**
     * Массив с данными о количестве
     * побед каждого игрока.
     */
    private final int[] scores;

    /**
     * Коллекция с данными о порядке
     * ходов игроков;
     */
    private final ArrayDeque<Integer> order;

    /**
     * Конструктор DiceGame. Принимает на вход
     * количество игроков (игроков должно быть больше нуля)
     * и количество кубиков (кубиков должно быть больше нуля).
     * @param n количество игроков
     * @param k количество игральных костей
     */
    public DiceGame(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new InvalidParameterException();
        }
        this.n = n;
        this.k = k;
        this.scores = new int[n];
        this.order = new ArrayDeque<Integer>(n);
        for (int i = 0; i < n; i++) {
            this.order.add(i);
        }
    }

    /**
     * Инициализирует начало игры.
     */
    @Override
    public void playGame() {
        int round = 1;
        while(Arrays.stream(this.scores).max().getAsInt() < 7) {
            gameRound(round++);
        }
    }

    /**
     * Проводит игровой раунд.
     * @param round номер раунда
     */
    private void gameRound(int round) {
        System.out.printf("=== Раунд %d ===\n\n", round);
        int playerWonTheRound = roundWinner();
        updateScores(playerWonTheRound, round);
    }

    /**
     * Возвращает индекс победителя
     * в текущем раунде.
     * @return int индекс победителя
     */
    private int roundWinner() {
        int maxScore = 0;
        int maxScorePlayer = 0;
        for (Integer playerTurn : this.order) {
            if (playerTurn < this.n - 1) {
                System.out.printf("Игрок %d\n------\n", playerTurn + 1);
                System.out.println("\033[3mДля хода нажмите \"Ввод\":\033[0m");
                scanner.nextLine();
            } else {
                System.out.print("Компьютер\n-----\n");
            }
            int score = diceSum(this.k);
            if (score > maxScore) {
                maxScore = score;
                maxScorePlayer = playerTurn;
            }
            System.out.printf("Сумма: %d\n\n", score);
        }
        return maxScorePlayer;
    }

    /**
     * Обновляет количество побед каждого игрока
     * в массиве scores.
     * @param playerWonTheRound индекс победившего игрока
     * @param round номер раунда
     */
    private void updateScores(int playerWonTheRound, int round) {
        if (playerWonTheRound < this.n - 1) {
            System.out.printf("Игрок %d выиграл в раунде %d!\n\n", playerWonTheRound + 1, round);
        } else {
            System.out.printf("Компьютер выиграл в раунде %d!\n\n", round);
        }
        int currentScore = scores[playerWonTheRound];
        this.scores[playerWonTheRound] = ++currentScore;
        this.order.clear();
        this.order.add(playerWonTheRound);
        for (int i = 0; i < this.n; i++) {
            if (i != playerWonTheRound) {
                this.order.add(i);
            }
        }
    }

    /**
     * Выводит на экран сообщение
     * о победившем игроке.
     */
    @Override
    public void announceWinner() {
        int winner = 0;
        for (int i = 0; i < this.scores.length; i++) {
            winner = this.scores[i] > this.scores[winner] ? i : winner;
        }
        if (winner < this.n - 1) {
            System.out.printf("=== Игрок %d победил! ===\n", winner + 1);
        } else {
            System.out.println("=== Компьютер победил! ===\n");
        }
    }

    /**
     * Возвращает массив с очками.
     * Индекс в массиве соответсвует
     * ID игрока.
     * @return массив с очками
     */
    @Override
    public int[] getScores() {
        return this.scores;
    }

    /**
     * Возвращает сумму всех бросков игральной
     * кости сделанных одним игроком.
     * @return int сумма всех бросков
     */
    @Override
    public int diceSum(int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int diceRoll = rollTheDice();
            sum += diceRoll;
            System.out.printf("Кубик %d, значение: %d\n", i + 1, diceRoll);
        }
        return sum;
    }

    /**
     * Возвращает результат броска
     * шестигранной игральной кости.
     * @return int значение броска кости
     */
    @Override
    public int rollTheDice() {
        return random.nextInt(6) + 1;
    }
}
