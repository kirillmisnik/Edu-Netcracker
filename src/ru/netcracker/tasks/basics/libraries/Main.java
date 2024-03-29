package ru.netcracker.tasks.basics.libraries;

import ru.netcracker.tasks.basics.libraries.dice.DiceGame;
import ru.netcracker.tasks.basics.libraries.extended.ExtendedClass;
import ru.netcracker.tasks.basics.libraries.magic.Magic;
import ru.netcracker.tasks.basics.libraries.magic.MagicImpl;
import ru.netcracker.tasks.basics.libraries.voice.Cat;
import ru.netcracker.tasks.basics.libraries.voice.Cow;
import ru.netcracker.tasks.basics.libraries.voice.Dog;

public class Main {
    public static void main(String[] args) {
        /* Задание 1 */
        Cat cat = new Cat();
        cat.voice();
        Dog dog = new Dog();
        dog.voice();
        Cow cow = new Cow();
        cow.voice();

        /* Задание 2 */
        int n = 3; // Количество игроков
        int k = 2; // Количество игральных костей
        DiceGame diceGame = new DiceGame(n, k);
        diceGame.playGame();
        diceGame.announceWinner();

        // Интерфейс Dice определяет методы
        // для работы с игральными костями.
        // Например:
        System.out.println(diceGame.rollTheDice());
        System.out.println(diceGame.diceSum(3));

        /* Задание 3 */
        ExtendedClass extendedClass = new ExtendedClass((byte) 1, 2, 3, "4");
        System.out.println(extendedClass.equals(new ExtendedClass((byte) 1, 2, 3, "4")));
        System.out.println(extendedClass.hashCode());
        System.out.println(extendedClass.toString());

        /* Задание 4 */
        Magic magic = new MagicImpl();
        magic.setNumber(1234);
        System.out.println(magic.getNumber());
        System.out.println(magic.doMagic());
    }
}
