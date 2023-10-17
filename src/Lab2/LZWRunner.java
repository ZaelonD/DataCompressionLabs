package Lab2;

public class LZWRunner {
    public static void main(String[] args) {
        LZLogic logic = new LZWImpl("resources/lab3.txt");
        logic.compress();
    }
}
