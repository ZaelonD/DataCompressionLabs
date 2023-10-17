package Lab2;

import java.io.*;

// Класс для чтения данных из файла
public class ReadFromFile {

    private final StringBuilder stringBuilder;
    private final String url;

    // Конструктор (На входе ссылка на файл)
    public ReadFromFile(String url) {
        this.stringBuilder = new StringBuilder();
        this.url = url;
        read();
    }

    private void read() {
        String lineBuffer;
        try {
            BufferedReader txt = new BufferedReader(new FileReader(url));
            while ((lineBuffer = txt.readLine()) != null) {
                stringBuilder.append(lineBuffer).append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            txt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}