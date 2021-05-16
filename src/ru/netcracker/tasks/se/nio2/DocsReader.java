package ru.netcracker.tasks.se.nio2;

import java.io.*;
import java.util.Scanner;

public class DocsReader {
	private String docs;

	/**
	 * Читает файл до тех пор, пока три раза не встретится слово "java".
	 * @throws IOException ошибка чтения файла
	 */
	public void readDocs() throws IOException {
		Reader reader = new BufferedReader(new FileReader("docs.txt"));
		Scanner scannerReader = new Scanner(reader);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (scannerReader.hasNext() && count < 3) {
			String word = scannerReader.next();
			sb.append(word).append(' ');
			if (word.equalsIgnoreCase("java")) {
				count++;
			}
		}
		docs = sb.toString();
	}

	public String getDocs() {
		return docs;
	}
}
