package edu.netcracker.tasks.task4.analyzer;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Проводит частотный анализ символов из первой строки,
 * сравнивая их с символами из второй строки.
 */
public class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }
    /**
     * Возвращает строку по индексу.
     * @param lineIndex индекс строки
     * @return строка
     */
    private String getLine(int lineIndex) {
        return text.split("\n")[lineIndex];
    }
    /**
     * Символы, которые входят и в первую и в заданную строку.
     * @param lineIndex индекс строки
     * @return множество символов
     */
    public Set<Character> inBoth(int lineIndex) {
        Set<Character> characterList = new TreeSet<>();
        for (int i = 0; i < getLine(0).length(); i++) {
            for (int j = 0; j < getLine(lineIndex).length(); j++) {
                if (getLine(0).charAt(i) == getLine(lineIndex).charAt(j)) {
                    characterList.add(getLine(0).charAt(i));
                    break;
                }
            }
        }
        return characterList;
    }
    /**
     * Символы, которые входят в первую и не входят в заданную строку.
     * @param lineIndex индекс строки
     * @return множество символов
     */
    public Set<Character> onlyInFirst(int lineIndex) {
        Set<Character> characterList = new HashSet<>();
        for (int i = 0; i < getLine(0).length(); i++) {
            characterList.add(getLine(0).charAt(i));
        }
        for (int i = 0; i < getLine(lineIndex).length(); i++) {
            characterList.remove(getLine(lineIndex).charAt(i));
        }
        return characterList;
    }
    /**
     * Символы, которые содержатся хотя бы в одной строке.
     * @param lineIndex индекс строки
     * @return множество символов
     */
    public Set<Character> atLeastInOne(int lineIndex) {
        Set<Character> characterList = new HashSet<>();
        for (int i = 0; i < getLine(0).length(); i++) {
            characterList.add(getLine(0).charAt(i));
        }
        for (int i = 0; i < getLine(lineIndex).length(); i++) {
            characterList.add(getLine(lineIndex).charAt(i));
        }
        return characterList;
    }
}
