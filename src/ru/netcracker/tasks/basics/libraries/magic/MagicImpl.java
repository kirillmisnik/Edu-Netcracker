package ru.netcracker.tasks.basics.libraries.magic;

/**
 * Класс, позволяющий производить
 * перестановки цифр числа в обратном порядке.
 */
public class MagicImpl implements Magic {
    private int number;

    public MagicImpl(int number) {
        this.number = number;
    }

    public MagicImpl() {
    }

    @Override
    public void setNumber(int x) {
        this.number = x;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     * Переставляет цифры числа в обратном порядке.
     * @return измененное число
     */
    @Override
    public int doMagic() {
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber *= 10;
            reversedNumber += number % 10;
            number /= 10;
        }
        return reversedNumber;
    }
}
