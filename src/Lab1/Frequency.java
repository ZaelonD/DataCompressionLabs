package Lab1;

import java.util.TreeMap;

public class Frequency {

    private final TreeMap<Character, Integer> frequencies;

    public Frequency() {
        frequencies = new TreeMap<>();
    }

    // Метод подсчета частоты символов в тексте
    public TreeMap<Character, Integer> countFrequency(String text) {
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = frequencies.get(c);
            frequencies.put(c, count != null ? count + 1 : 1);
        }
        return frequencies;
    }

    public TreeMap<Character, Integer> getFrequencies() {
        return frequencies;
    }
}
