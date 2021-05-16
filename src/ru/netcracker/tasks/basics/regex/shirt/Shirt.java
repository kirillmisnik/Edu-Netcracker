package ru.netcracker.tasks.basics.regex.shirt;

/**
 * Реализация класса Shirt.
 */
public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    /**
     * Конструктор, принимающий на вход строковое представление данных
     * для класса Shirt.
     * @param shirt строка в формате "<id>,<description>,<color>,<size>";
     */
    public Shirt(String shirt) {
        String[] shirtArray = shirt.split(",");
        this.id = shirtArray[0];
        this.description = shirtArray[1];
        this.color = shirtArray[2];
        this.size = shirtArray[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
