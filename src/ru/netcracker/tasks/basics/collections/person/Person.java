package ru.netcracker.tasks.basics.collections.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс Person для хранения даты рождения.
 */
public class Person {
    private LocalDate birthDate;

    public Person(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Возвращает дату рождения в строковм представлении в коротком или полном форматах.
     * @param format формат даты: short (dd-MM), full (dd-MMMM-yyyy)
     * @return строковое представление даты в выбранном формате
     */
    public String getFormattedDate(String format) {
        DateTimeFormatter formatter;
        switch (format) {
            case "short" -> {
                formatter = DateTimeFormatter.ofPattern("dd-MM");
                return birthDate.format(formatter);
            }
            case "full" -> {
                formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
                return birthDate.format(formatter);
            }
            default -> System.out.println("Введен неверный формат. Верные: <short>, <full>");
        }
        return null;
    }

    /**
     * Возвращает дату рождения в строковм представлении в среднем формате.
     * @return строковое представление даты в формате yyyy-MM-dd
     */
    @Override
    public String toString() {
        return "Дата рождения: " + birthDate;
    }
}
