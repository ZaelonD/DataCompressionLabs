package Lab1;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class EncodeText {
    private final String initialText;
    private final StringBuilder encodedText;
    private final Frequency frequency;
    CodeTreeNode codeTreeNode;
    private TreeMap<Character, Integer> frequencies;
    ArrayList<CodeTreeNode> codeTreeNodes;
    private final Tree treeClass;
    TreeMap<Character, String> codes;


    public EncodeText() {
        ReadingTextFromConsole read = new ReadingTextFromConsole();
        this.initialText = read.getText();
        this.codeTreeNode = new CodeTreeNode();
        this.frequency = new Frequency();
        this.codeTreeNodes = new ArrayList<>();
        this.treeClass = new Tree();
        this.encodedText = new StringBuilder();
        this.codes = new TreeMap<>();
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

//    public String test() {
//        StringBuilder stringBuilder = new StringBuilder("[");
//        for (Map.Entry<Character, String> characterStringEntry : codes.entrySet()) {
//            if (characterStringEntry.getKey() == ' ')
//                stringBuilder.append("' '" + " = ").append(characterStringEntry.getValue());
//            else
//                stringBuilder.append("; '").append(characterStringEntry.getKey()).append("' = ").append(characterStringEntry.getValue());
//        }
//        stringBuilder.append("]");
//        return stringBuilder.toString();
//    }

    public String printTableCodes() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Map.Entry<Character, String> characterStringEntry : codes.entrySet()) {
            if (characterStringEntry.getKey() == ' ')
                stringBuilder.append("' '" + " = ").append(characterStringEntry.getValue());
            else
                stringBuilder.append("; '").append(characterStringEntry.getKey()).append("' = ").append(characterStringEntry.getValue());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}