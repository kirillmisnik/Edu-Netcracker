package ru.netcracker.tasks.basics.regex.phone;

/**
 * Класс, отвечающий за хранение и вывод телефонного номера.
 */
public class PhoneNumber {
    String number;

    /**
     * Телефонный номер в строковом представлении.
     * @param number номер, в формате "+<Код страны><Три цифры>–<Три цифры>–<Четыре цифры>"
     */
    public PhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder stringNumber = new StringBuilder("+");
        stringNumber.append(number.charAt(1));
        for (int i = 2; i < number.length(); i++) {
            if (i == 5 | i == 8) {
                stringNumber.append("-");
            }
            stringNumber.append(number.charAt(i));
        }
        return stringNumber.toString();
    }
}
