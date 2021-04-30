package edu.netcracker.tasks.basics.task1.people;

import java.util.Date;

/**
 * Класс Person содержит в себе
 * информацию о человеке: имя, фамилию
 * адрес и дату рождения.
 */
public class Person {
    private String firstName;
    private String lastName;
    private Address address;
    private Date birthDate;

    /**
     * Конструктор Person.
     * @param firstName имя
     * @param lastName фамилия
     * @param address адрес
     * @param birthDate дата рождения
     */
    public Person(String firstName, String lastName, Address address, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает имя объекта
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Возвращает фамилию объекта
     * @return фамилия
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Возвращает адрес текущего объекта
     * @return адрес
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Возвращает дату рождения текущего объекта
     * @return дата рождения
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Устанавливает имя текущего объекта
     * @param firstName имя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Устанавливает фамилию текущего объекта
     * @param lastName фамилия
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Устанавливает адрес текущего объекта
     * @param address адрес
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Устанавливает дату рождения текущего объекта
     * @param birthDate дата рождения
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
