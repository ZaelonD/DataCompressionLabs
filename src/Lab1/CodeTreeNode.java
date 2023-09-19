package Lab1;

public class CodeTreeNode implements Comparable<CodeTreeNode> {

    private Character symbol; // Значение символа
    private int frequency; // Частота
    private CodeTreeNode left; // Левый узел
    private CodeTreeNode right; // Правый узел

    public CodeTreeNode(Character symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public CodeTreeNode(Character symbol, int frequency, CodeTreeNode left, CodeTreeNode right) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(CodeTreeNode o) {
        return o.frequency - frequency;
    }
}
