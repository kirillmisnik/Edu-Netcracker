package dice;

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
public class DiceGame {
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
    public void startGame() {
        int round = 1;
        while(Arrays.stream(this.scores).max().getAsInt() < 7) {
            gameRound(round++);
        }
        announceWinner();
    }

    /**
     * Проводит игровой раунд.
     * @param round номер раунда
     */
    private void gameRound(int round) {
        System.out.printf("=== Раунд %d ===\n\n", round);
        int playerWinedTheRound = roundWinner();
        updateScores(playerWinedTheRound, round);
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
                scanner.nextLine();
            } else {
                System.out.print("Компьютер\n-----\n");
            }
            int score = diceSum();
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
     * @param playerWinedTheRound индекс победившего игрока
     * @param round номер раунда
     */
    private void updateScores(int playerWinedTheRound, int round) {
        if (playerWinedTheRound < this.n - 1) {
            System.out.printf("Игрок %d выиграл в раунде %d!\n\n", playerWinedTheRound + 1, round);
        } else {
            System.out.printf("Компьютер выиграл в раунде %d!\n\n", round);
        }
        int currentScore = scores[playerWinedTheRound];
        this.scores[playerWinedTheRound] = currentScore + 1;
        this.order.clear();
        this.order.add(playerWinedTheRound);
        for (int i = 0; i < this.n; i++) {
            if (i != playerWinedTheRound) {
                this.order.add(i);
            }
        }
    }

    /**
     * Выводит на экран сообщение
     * о победившем игроке.
     */
    private void announceWinner() {
        int winner = 0;
        for (int i = 0; i < this.scores.length; i++) {
            winner = this.scores[i] > this.scores[winner] ? i : winner;
        }
        if (winner < this.n - 1) {
            System.out.printf("=== Игрок %d победил! ===", winner + 1);
        } else {
            System.out.println("=== Компьютер победил! ===");
        }
    }

    /**
     * Возвращает сумму всех бросков игральной
     * кости сделанных одним игроком.
     * @return int сумма всех бросков
     */
    private int diceSum() {
        int sum = 0;
        for (int i = 0; i < this.k; i++) {
            int diceRoll = rollTheDice();
            sum += diceRoll;
            System.out.printf("Кубик %d, значение: %d\n", i + 1, rollTheDice());
        }
        return sum;
    }

    /**
     * Возвращает результат броска
     * шестигранной игральной кости.
     * @return int значение броска кости
     */
    private int rollTheDice() {
        return random.nextInt(6) + 1;
    }
}
