package Lab1;

public class DecodeText {

    private final StringBuilder decodedText;

    public DecodeText() {
        this.decodedText = new StringBuilder();
    }

    // Метод декодирования
    public void decode(String encoded, CodeTreeNode tree) {
        CodeTreeNode node = tree;
        for (int i = 0; i < encoded.length(); i++) {
            node = encoded.charAt(i) == '0' ? node.getLeft() : node.getRight();
            if (node.getSymbol() != null) {
                decodedText.append(node.getSymbol());
                node = tree;
            }
        }
        System.out.println("Декодирование: " + decodedText);
    }
}
