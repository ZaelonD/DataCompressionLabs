package Lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class HuffmanFromConsoleImpl implements HuffmanLogic {

    private ReadingTextFromConsole read;
    private Frequency frequency;
    private TreeMap<Character, Integer> frequencies;
    ArrayList<CodeTreeNode> codeTreeNodes;

    public HuffmanFromConsoleImpl() {
        read = new ReadingTextFromConsole();
        frequency = new Frequency();
        // Вычисляем частоты символов в тексте
        frequencies = frequency.countFrequency(read.getText());
        // Список для листов дерева
        codeTreeNodes = new ArrayList<>();
    }

    @Override
    public void runHuffman() {
        // Генерируем список листов дерева
        generateCodeTreeNodes();
        CodeTreeNode tree = createCodeTree();
    }

    private void generateCodeTreeNodes() {
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }
    }

    private CodeTreeNode createCodeTree() {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, right.getFrequency() + left.getFrequency(), left, right);
            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }
}
