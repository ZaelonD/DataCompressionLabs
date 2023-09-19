package Lab1;

import java.util.TreeMap;

public class HuffmanFromConsoleImpl implements HuffmanLogic {

    @Override
    public void runHuffman() {
        ReadingTextFromConsole read = new ReadingTextFromConsole();
        Frequency frequencies = new Frequency();
        TreeMap<Character, Integer> freq = frequencies.countFrequency(read.getText());
    }
}
