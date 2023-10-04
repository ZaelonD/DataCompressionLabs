package Lab1;

import java.util.*;

public class EncodeText {
    private final String initialText;
    private final StringBuilder encodedText;
    private final Frequency frequency;
    private TreeMap<Character, Integer> frequencies;
    private final ArrayList<CodeTreeNode> codeTreeNodes;
    private final Tree treeClass;
    private final TreeMap<Character, String> codes;
    private final Calculate calc;


    public EncodeText() {
        ReadingTextFromConsole read = new ReadingTextFromConsole();
        this.initialText = read.getText();
        this.frequency = new Frequency();
        this.codeTreeNodes = new ArrayList<>();
        this.treeClass = new Tree();
        this.encodedText = new StringBuilder();
        this.codes = new TreeMap<>();
        this.calc = new Calculate();
    }

    public void encode() {
        // Считаем частоты символов
        frequency.countFrequency(initialText);
        // Записываем частоты в дерево
        frequencies = frequency.getFrequencies();
        // Генерируем список листьев дерева
        generateCodeTreeNodes();
        // Создаем дерево
        treeClass.createCodeTree(codeTreeNodes);
        // Создаем таблицу префиксных кодов
        createTableCodes(codes);
        // Вывод
        System.out.println("Таблица префиксных кодов:\n" + printTableCodes());
        // Составление закодированной строки
        mergeCodes(codes);
        // Считаем среднюю длинну кода
        System.out.printf("Средняя длинна кода: %.2f бит %n", calc.calculateAverageCodeLength(codes, frequencies, initialText.length()));
        // Считаем энтропию
        System.out.printf("Энтропия: %.2f бит %n", calc.calculateEntropy(codes, frequencies, initialText.length()));
        // Считаем избыточность кода
        System.out.printf("Избыточность кода: %.2f бит %n", calc.calculateCodeRedundancy());
        // Вывод
        System.out.println("Кодирование: " + encodedText.toString());
    }

    // Метод для создания таблицы кодов для каждого символа
    private void createTableCodes(TreeMap<Character, String> codes) {
        for (Character c : frequencies.keySet()) {
            codes.put(c, treeClass.getTree().getCodeForCharacter(c, ""));
        }
    }

    // Метод для составления закодированной строки
    private void mergeCodes(TreeMap<Character, String> codes) {
        for (int i = 0; i < initialText.length(); i++) {
            encodedText.append(codes.get(initialText.charAt(i)));
        }
    }

    // Метод генерации списка листьев дерева
    private void generateCodeTreeNodes() {
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }
    }

    public String getInitialText() {
        return initialText;
    }

    public String getEncodedText() {
        return encodedText.toString();
    }

    public CodeTreeNode getTreeClass() {
        return treeClass.getTree();
    }

    // Метод для вывода таблицы кодов
    public String printTableCodes() {
        StringBuilder stringBuilder = new StringBuilder("[");
        int k = 0;
        for (Map.Entry<Character, String> characterStringEntry : codes.entrySet()) {
            if (characterStringEntry.getKey() == ' ') {
                stringBuilder.append("' '" + " = ").append(characterStringEntry.getValue());
                k++;
            } else if (k != 0)
                stringBuilder.append("; '").append(characterStringEntry.getKey()).append("' = ").append(characterStringEntry.getValue());
            else {
                stringBuilder.append("'").append(characterStringEntry.getKey()).append("' = ").append(characterStringEntry.getValue());
                k++;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}