package ru.netcracker.tasks.se.serialization.vector;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

/**
 * Предоставляет ряд статических методов для работы с вектораи.
 */
public class Vectors {
    /**
     * Умножает вектор на скаляр.
     * @param vector вектор
     * @param scalar скаляр
     * @return вектор, умноженный на скаляр
     */
    public static Vector<Double> multiplyVectorByScalar(Vector<Double> vector, double scalar) {
        Vector<Double> resultVector = new Vector<Double>(vector.size());
        for (int i = 0; i < vector.size(); i++) {
            resultVector.add(vector.elementAt(i) * scalar);
        }
        return resultVector;
    }

    /**
     * Складывает два вектора.
     * @param vector1 первый вектор
     * @param vector2 второй вектор
     * @return результат суммы векторов
     * @throws IllegalArgumentException векторы разного размера
     */
    public static Vector<Double> sumVectors(Vector<Double> vector1, Vector<Double> vector2) {
        Vector<Double> resultVector = new Vector<Double>(vector1.size());
        isValid(vector1, vector2);
        for (int i = 0; i < vector1.size(); i++) {
            resultVector.add(vector1.elementAt(i) + vector2.elementAt(i));
        }
        return resultVector;
    }

    /**
     * Находит скалярное произведение векторов.
     * @param vector1 первый вектор
     * @param vector2 второй вектор
     * @return скалярное произведение
     * @throws IllegalArgumentException векторы разного размера
     */
    public static double findScalar(Vector<Double> vector1, Vector<Double> vector2) {
        isValid(vector1, vector2);
        double sum = 0;
        for (int i = 0; i < vector1.size(); i++) {
            sum += vector1.elementAt(i) * vector2.elementAt(i);
        }
        return sum;
    }

    /**
     * Проверяет, одного ли размера векторы. Если нет, выбрасывает IllegalArgumentException.
     * @param vector1 первый вектор
     * @param vector2 второй вектор
     * @throws IllegalArgumentException векторы разного размера
     */
    private static void isValid(Vector<Double> vector1, Vector<Double> vector2) {
        if (vector1.size() != vector2.size() ) {
            throw new IllegalArgumentException(String.format("Векторы разного размера: %d и %d.",
                    vector1.size() , vector2.size() ));
        }
    }

    /**
     * Переводит вектор в строку. Длина вектора и его значения, разделенные пробелами.
     * @param vector вектор
     * @return строка
     */
    private static String vectorAsString(Vector<Double> vector) {
        StringBuilder sbVector = new StringBuilder(vector.size() + " ");
        for (Double elem : vector) {
            sbVector.append(elem).append(" ");
        }
        return sbVector.toString();
    }

    /**
     * Запись вектора в байтовый поток.
     * @param vector вектор
     * @param out байтовый поток вывода
     * @throws IOException ошибка ввода-вывода
     */
    public static void outputVector(Vector<Double> vector, OutputStream out) throws IOException {
        out.write(vectorAsString(vector).getBytes());
        out.flush();
    }

    /**
     * Чтение вектора из байтового потока.
     * @param in байтовый поток ввода
     * @return вектор
     * @throws IOException ошибка ввода-вывода
     */
    public static Vector<Double> inputVector(InputStream in) throws IOException {
        String string = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        String[] strings = string.split(" ");
        Vector<Double> vector = new Vector<Double>(Integer.parseInt(strings[0]));
        for (int i = 1; i < strings.length; i++) {
            vector.add(Double.parseDouble(strings[i]));
        }
        return vector;
    }

    /**
     * Запись вектора в символьный поток.
     * @param vector вектор
     * @param out символьный поток вывода
     * @throws IOException ошибка ввода-вывода
     */
    public static void writeVector(Vector<Double> vector, Writer out) throws IOException {
        out.write(vectorAsString(vector).toCharArray());
        out.flush();
    }

    /**
     * Чтение вектора из символьного потока.
     * @param in символьный поток ввода
     * @return вектор
     * @throws IOException ошибка ввода-вывода
     */
    public static Vector<Double> readVector(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        Vector<Double> vector = new Vector<Double>((int) tokenizer.nval);
        int token = tokenizer.nextToken();
        while (token != StreamTokenizer.TT_EOF) {
            vector.add(tokenizer.nval);
            token = tokenizer.nextToken();
        }
        return vector;
    }
}
