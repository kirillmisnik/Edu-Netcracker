package ru.netcracker.tasks.se.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountSymbol {
	/**
	 * Считает сколько раз заданный символ встречается в тексте.
	 * Символ вводится с клавиатуры, если введено более одного символа,
	 * смотрится только первый.
	 * @param fileName имя файла
	 * @return сколько раз заданный символ встречается в тексте
	 * @throws IOException ошибка ввода-вывода
	 */
	public int countSymbol(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		String symbol = new Scanner(System.in).next();
		BufferedReader words = Files.newBufferedReader(path);
		int counter = 0;
		int c;
		while ((c = words.read()) != -1) {
			if ((char) c == symbol.charAt(0)) {
				counter++;
			}
		}
		return counter;
	}
}
