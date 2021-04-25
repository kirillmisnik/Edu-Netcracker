package edu.netcracker.tasks.task3.person;

import java.util.Objects;

/**
 * Класс, предназначенный для хранения данных о ФИО человека.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;

    public Person(String lastName, String firstName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Person(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String lastName) {
        this.lastName = lastName;
    }

    public Person() {
    }

    /**
     * Возвращает полное имя в формате "Фамилия И.О.". Имя и Отчество могут отсутствовать.
     * @return ФИО
     */
    public String getFullName() {
        StringBuilder fullName = new StringBuilder(lastName).append(' ');
        if (firstName != null) {
            fullName.append(firstName.charAt(0)).append('.');
        }
        if (patronymic != null) {
            fullName.append(patronymic.charAt(0)).append('.');
        }
        return fullName.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(patronymic, person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic);
    }
}
