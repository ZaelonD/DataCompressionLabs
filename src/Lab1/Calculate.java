package Lab1;

import java.util.Map;
import java.util.TreeMap;

public class Calculate {

    private double averageCodeLength; // Средняя длина кода
    private double entropy; // значение энтропии

    public double calculateAverageCodeLength(TreeMap<Character, String> codes, TreeMap<Character, Integer> frequencies, int stringCount) {
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            double p = (double) frequencies.get(entry.getKey()) / stringCount; // Считаем вероятность
            int n = entry.getValue().length(); // Длинна кода
            averageCodeLength += n * p;
        }
        return averageCodeLength;
    }

    public double calculateEntropy(TreeMap<Character, String> codes, TreeMap<Character, Integer> frequencies, int stringCount) {
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            double p = (double) frequencies.get(entry.getKey()) / stringCount; // Считаем вероятность
            entropy -= p * log2(p);
        }
        return entropy;
    }

    public double calculateCodeRedundancy() {
        return 1 - entropy / averageCodeLength;
    }

    private static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }
}