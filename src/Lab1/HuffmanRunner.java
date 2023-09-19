package Lab1;

public class HuffmanRunner {
    public static void main(String[] args) {
        HuffmanLogic huffmanLogic = new HuffmanFromConsoleImpl();
        huffmanLogic.runHuffman();
    }
}
