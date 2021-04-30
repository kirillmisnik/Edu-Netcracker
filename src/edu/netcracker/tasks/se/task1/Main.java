package edu.netcracker.tasks.se.task1;

import edu.netcracker.tasks.se.task1.persisted.DeserializeMyClassToBePersisted;
import edu.netcracker.tasks.se.task1.persisted.MyClassToBePersisted;
import edu.netcracker.tasks.se.task1.persisted.SerializeMyClassToBePersisted;
import edu.netcracker.tasks.se.task1.serializable.ArrayVector;
import edu.netcracker.tasks.se.task1.serializable.LinkedListVector;
import edu.netcracker.tasks.se.task1.vector.Vectors;

import java.io.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        /* ------ Задание 1 ------ */
        Vector<Double> vector1 = new Vector<>();
        vector1.add(2.0);
        vector1.add(5.2);
        vector1.add(6.4);

        Vector<Double> vector2 = new Vector<>();
        vector2.add(4.2);
        vector2.add(7.5);
        vector2.add(12.1);

        Vector<Double> vector3 = new Vector<>();
        vector3.add(1.0);

        System.out.println(Vectors.multiplyVectorByScalar(vector1, 2));
        System.out.println(Vectors.sumVectors(vector1, vector2));
        try {
            Vectors.sumVectors(vector1, vector3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Vectors.findScalar(vector1, vector2));

        /* ------ Задание 2 ------ */
        try {
            OutputStream out = new FileOutputStream("vector.txt");
            Vectors.outputVector(vector1, out);

            InputStream in = new FileInputStream("vector.txt");
            System.out.println(Vectors.inputVector(in));

            Writer out2 = new FileWriter("vector.txt");
            Vectors.writeVector(vector1, out2);

            Reader in2 = new FileReader("vector.txt");
            System.out.println(Vectors.readVector(in2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /* ------ Задание 3 ------ */
        try {
            ArrayVector arrayVector = new ArrayVector(new double[]{2, 5, 8, 4});
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("array_vector.out"));
            objectOutputStream.writeObject(arrayVector);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("array_vector.out"));
            ArrayVector arrayVectorRestored = (ArrayVector) objectInputStream.readObject();
            objectInputStream.close();

            System.out.printf("Исходный объект (ArrayVector): %s\n", arrayVector);
            System.out.printf("Восстановленный объект (ArrayVector): %s\n", arrayVectorRestored);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            LinkedListVector linkedListVector = new LinkedListVector(new double[]{2.3, 5.6, 18, 4.12});
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("linked_list_vector.out"));
            objectOutputStream.writeObject(linkedListVector);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("linked_list_vector.out"));
            LinkedListVector linkedListVectorRestored = (LinkedListVector) objectInputStream.readObject();
            objectInputStream.close();

            System.out.printf("Исходный объект (LinkedListVector): %s\n", linkedListVector);
            System.out.printf("Восстановленный объект (LinkedListVector): %s\n", linkedListVectorRestored);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /* ------ Задание 4 ------ */
        try {
            SerializeMyClassToBePersisted serializeMyClass =
                    new SerializeMyClassToBePersisted("Математика и информатика", "ПМ18-3");
            serializeMyClass.serialize("Misnik_Kirill_MyClass");

            MyClassToBePersisted myClass = DeserializeMyClassToBePersisted.deserialize("Misnik_Kirill_MyClass");
            System.out.println(myClass);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
