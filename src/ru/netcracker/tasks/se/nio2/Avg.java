package ru.netcracker.tasks.se.nio2;

import java.io.*;
import java.util.Scanner;

public class Avg {
    private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Записывает числа в файл "numbers.out".
	 * @param n кол-во чисел
	 * @throws IOException ошибка создания файла
	 */
    public void writeNumbers(int n) throws IOException {
		Writer writer = new FileWriter("numbers.txt");
		for (int i = 0; i < n; i++) {
			writer.write(scanner.next());
			writer.write(' ');
		}
		writer.close();
	}

	/**
	 * Находит среднее из файла "numbers.out".
	 * @return среднее значение
	 * @throws FileNotFoundException ошибка чтения файла
	 */
	public double findAverage() throws FileNotFoundException {
		Reader reader = new FileReader("numbers.txt");
		Scanner scannerReader = new Scanner(reader);
		double sum = 0;
		int col = 0;
		while (scannerReader.hasNext()) {
			sum += Double.parseDouble(scannerReader.next());
			col++;
		}
		return sum/col;
	}

	/**
	 * Находит количество целых чисел в файле "numbers.out".
	 * @return количество челых чисел
	 * @throws FileNotFoundException ошибка чтения файла
	 */
	public int amountOfIntegers() throws FileNotFoundException {
		Reader reader = new FileReader("numbers.txt");
		Scanner scannerReader = new Scanner(reader);
		int sum = 0;
		while (scannerReader.hasNext()) {
			try {
				Integer.parseInt(scannerReader.next());
				sum++;
			} catch (NumberFormatException ignored) {
			}
		}
		return sum;
	}
}
