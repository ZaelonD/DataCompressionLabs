package Lab1;

import java.util.Scanner;

public class ReadingTextFromConsole implements ReadService {

    private final Scanner SCANNER;
    private String text;

    public ReadingTextFromConsole() {
        System.out.println("Введите текст, который хотите закодировать");
        SCANNER = new Scanner(System.in);
        readTheText();
    }

    @Override
    public void readTheText() {
        text = SCANNER.nextLine();
        SCANNER.close();
    }

    public String getText() {
        return text;
    }
}