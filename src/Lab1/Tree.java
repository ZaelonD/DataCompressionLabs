package Lab1;

import java.util.ArrayList;
import java.util.Collections;

public class Tree {
    private CodeTreeNode tree;

    public Tree() {
        this.tree = new CodeTreeNode();
    }

    // Создаем дерево
    public void createCodeTree(ArrayList<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, right.getFrequency() + left.getFrequency(), left, right);
            codeTreeNodes.add(parent);
        }
        tree = codeTreeNodes.get(0);
    }

    public CodeTreeNode getTree() {
        return tree;
    }
}
