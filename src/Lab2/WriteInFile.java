package Lab2;

import java.io.*;
import java.util.List;

public class WriteInFile {
    private final PrintWriter pw;

    public WriteInFile(String path) {
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file);
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeInt(List<Integer> list) {
        try {
            for (Integer code : list) {
                pw.write(code + " ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }

    public void writeString(List<String> list) {
        try {
            for (String word : list) {
                pw.write(word);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pw.close();
    }
}