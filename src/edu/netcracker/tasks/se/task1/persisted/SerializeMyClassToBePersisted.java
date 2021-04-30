package edu.netcracker.tasks.se.task1.persisted;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Создает объект класса MyClassToBePersisted. Сериализует его в файл <file_name>.out
 */
public class SerializeMyClassToBePersisted {
    private MyClassToBePersisted myClass;

    /**
     * Создает объект класса MyClassToBePersisted.
     * @param profile профиль
     * @param group группа
     */
    public SerializeMyClassToBePersisted(String profile, String group) {
        myClass = new MyClassToBePersisted(profile, group);
    }

    /**
     * Сериализует объект в файл <file_name>.out
     * @param fileName имя файла
     * @throws IOException ошибка ввода-вывода
     */
    public void serialize(String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(String.format("%s.out", fileName)));
        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
    }
}
