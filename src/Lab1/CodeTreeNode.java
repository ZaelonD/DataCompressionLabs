package Lab1;

public class CodeTreeNode implements Comparable<CodeTreeNode> {

    private Character symbol; // Значение символа
    private int frequency; // Частота
    private CodeTreeNode left; // Левый узел
    private CodeTreeNode right; // Правый узел

    public CodeTreeNode() {
    }

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

    public int getFrequency() {
        return frequency;
    }

    public String getCodeForCharacter(Character ch, String parentPath) {
        if (symbol == ch) {
            return parentPath;
        } else {
            if (left != null) {
                String path = left.getCodeForCharacter(ch, parentPath + 0);
                if (path != null) {
                    return path;
                }
            }
            if (right != null) {
                return right.getCodeForCharacter(ch, parentPath + 1);
            }
        }
        return null;
    }

    public CodeTreeNode getLeft() {
        return left;
    }

    public CodeTreeNode getRight() {
        return right;
    }

    public Character getSymbol() {
        return symbol;
    }
}
