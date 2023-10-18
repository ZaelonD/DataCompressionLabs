package Lab2;

import java.util.*;

public class LZWImpl implements LZLogic {
    private final Dictionary dict;
    private final ReadFromFile readFromFile;
    private List<Integer> compressList;

    public LZWImpl(String path) {
        this.readFromFile = new ReadFromFile(path);
        this.dict = new Dictionary(readFromFile.getText().toString());
    }

    @Override
    public void compress() {
        long time = System.currentTimeMillis();
        compressList = new ArrayList<>();
        StringBuilder text = readFromFile.getText();
        StringBuilder str = new StringBuilder();
        String buf = "";
        for (int i = 0; i < text.length(); i++) {
            str.append(text.toString().charAt(i));
            if (!dict.getDictionary().containsKey(str.toString())) {
                dict.addSubstringInDictionary(str.toString());
                compressList.add(dict.getDictionary().get(buf));
                str.delete(0, str.length() - 1);
            }
            buf = str.toString();
            if (text.length() - i == 1) {
                compressList.add(dict.getDictionary().get(buf));
            }
        }
        System.out.println("Время сжатия: " + (System.currentTimeMillis() - time) + " мс");
        dict.writeDictionaryInFile("resources/dictionary_after_compress");
        WriteInFile writeInFile = new WriteInFile("resources/encoded_file.txt");
        writeInFile.writeInt(compressList);
        System.out.println("Коэффициент сжатия: " + (double) text.toString().length() / compressList.size());
    }

    @Override
    public void decompress() {
        long time = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for (Integer code : compressList) {
            for (Map.Entry<String, Integer> entry : dict.getDictionary().entrySet()) {
                if (Objects.equals(entry.getValue(), code)) {
                    list.add(entry.getKey());
                    break;
                }
            }
        }
        System.out.println("Время восстановления: " + (System.currentTimeMillis() - time) + " мс");
        StringBuilder text = readFromFile.getText();
        System.out.printf("Качество сжатия: %.2f%s %n", 100 * ((double) list.size() / text.toString().length()), "%");
        WriteInFile writeInFile = new WriteInFile("resources/decoded_file.txt");
        writeInFile.writeString(list);
    }
}