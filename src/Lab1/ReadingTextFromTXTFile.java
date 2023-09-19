package Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingTextFromTXTFile implements ReadService {
    private final Scanner SCANNER;
    private final StringBuilder text;

    public ReadingTextFromTXTFile(File file) {
        text = new StringBuilder();
        try {
            SCANNER = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        readTheText();
    }

    @Override
    public void readTheText() {
        while (SCANNER.hasNextLine()) {
            text.append(SCANNER.nextLine());
            if (SCANNER.hasNextLine())
                text.append(" ");
        }
        SCANNER.close();
    }

    public String getText() {
        return text.toString();
    }
}
