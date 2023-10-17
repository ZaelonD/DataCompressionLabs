package Lab2;

import java.util.*;

// Класс словарь
public class Dictionary {
    private static int ENCODING_SIZE = 256; // Размер кодировки по таблице ASCII
    private HashMap<String, Integer> dictionary;

    public Dictionary() {
        initDictionary();
    }

    // Инициализация словаря
    private void initDictionary() {
        this.dictionary = new HashMap<>();
        for (int codeASCII = 0; codeASCII < ENCODING_SIZE; codeASCII++) {
            addSubstringInDictionary(codeASCII);
        }
    }

    public void addSubstringInDictionary(int code) {
        dictionary.put(String.valueOf((char) code), code);
    }

    public void addSubstringInDictionary(String str) {
        dictionary.put(str, ENCODING_SIZE++);
    }

    public void printDictionary() {
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println(entry.toString());
        }
    }

    public HashMap<String, Integer> getDictionary() {
        return dictionary;
    }
}