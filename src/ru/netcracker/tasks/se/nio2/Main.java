package ru.netcracker.tasks.se.nio2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /* ------ Задание 1 ------ */
        SelfOutput so = new SelfOutput();
        so.setWorkingDirectoryPath();
        System.out.println(so.getPath());
        so.setSrcPath();
        System.out.println(so.getPath());
        so.copyJavaFile();

//        /* ------ Задание 2 ------ */
//        Avg avg = new Avg();
//        avg.writeNumbers(4);
//        System.out.println(avg.findAverage());
//        System.out.println(avg.amountOfIntegers());
//
//        /* ------ Задание 3 ------ */
//        DocsReader docsReader = new DocsReader();
//        docsReader.readDocs();
//        System.out.println(docsReader.getDocs());
//
//        /* ------ Задание 4 ------ */
//        CountSymbol cs = new CountSymbol();
//        System.out.println(cs.countSymbol("docs.txt"));
    }
}
