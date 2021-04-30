package edu.netcracker.tasks.basics.task1.people;

/**
 * Класс Address содержит в себе информацию
 * об адресе: страну, город, улицу
 * и номер дома.
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private int houseNumber;

    /**
     * Конструктор Address.
     * @param country страна
     * @param city город
     * @param street улица
     * @param houseNumber номер дома
     */
    public Address(String country, String city, String street, int houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    /**
     * Возвращает страну текущего объекта
     * @return country страна
     */
    public String getCountry() {
        return country;
    }

    /**
     * Возвращает город текущего объекта
     * @return city город
     */
    public String getCity() {
        return city;
    }

    /**
     * Возвращает улицу текущего объекта
     * @return street улица
     */
    public String getStreet() {
        return street;
    }

    /**
     * Возвращает номер дома текущего объекта
     * @return houseNumber номер дома
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * Устанавливает страну текущего объекта
     * @param country страна
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Устанавливает город текущего объекта
     * @param city город
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Устанавливает улицу текущего объекта
     * @param street улица
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Устанавливает номер дома текущего объекта
     * @param houseNumber номер дома
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Переопределение метода equals().
     * @param o объект класса
     * @return boolean true - если объекты равны, false - если нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return country.equals(address.country) &&
                city.equals(address.city) &&
                street.equals(address.street) &&
                houseNumber == address.houseNumber;
    }
}
