package edu.netcracker.tasks.se.task1.persisted;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Предоставляет доступ к статическому методу для десериализации
 * объекта MyClassToBePersisted из файла.
 */
public class DeserializeMyClassToBePersisted {
    /**
     * Возвращает поток ObjectInputStream.
     * @param fileName имя файла
     * @return поток ObjectInputStream
     * @throws IOException ошибка ввода-вывода
     */
    private static ObjectInputStream getStream(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(String.format("%s.out", fileName));
        return new ObjectInputStream(fileInputStream);
    }

    /**
     * Возвращает объект класса MyClassToBePersisted, полученный из файла <fileName>.out.
     * @param fileName имя файла
     * @return объект класса MyClassToBePersisted
     * @throws IOException ошибка ввода-вывода
     * @throws ClassNotFoundException ошибка создания объекта класса
     */
    public static MyClassToBePersisted deserialize(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in = getStream(fileName);
        MyClassToBePersisted myClassToBePersisted = (MyClassToBePersisted) in.readObject();
        in.close();
        return myClassToBePersisted;
    }
}
