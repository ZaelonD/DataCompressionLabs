package Lab2;

import java.util.*;

public class LZWImpl implements LZLogic {
    private final Dictionary dict;
    private final ReadFromFile readFromFile;
    private List<Integer> compressList;

    public LZWImpl(String path) {
        this.readFromFile = new ReadFromFile(path);
        this.dict = new Dictionary();
    }

    @Override
    public void compress() {
        long time = System.currentTimeMillis();
        compressList = new ArrayList<>();
        StringBuilder stringBuilder = readFromFile.getStringBuilder();
        StringBuilder str = new StringBuilder();
        char symbol;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            symbol = stringBuilder.toString().charAt(i);
            list.add(symbol);
            str.append(symbol);
            if (dict.getDictionary().containsKey(str.toString())) {
                compressList.add(dict.getDictionary().get(str.toString()));
            } else if (!list.contains(symbol)) {
                dict.addSubstringInDictionary(str.toString());
                str.delete(0, str.length() - 1);
                compressList.add(dict.getDictionary().get(str.toString()));
            } else {
                str.delete(0, str.length() - 1);
                compressList.add(dict.getDictionary().get(str.toString()));
            }
        }
        System.out.println("Время сжатия: " + (System.currentTimeMillis() - time) + " мс");
        WriteInFile writeInFile = new WriteInFile("resources/encodedFile.txt");
        writeInFile.writeInt(compressList);
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
        WriteInFile writeInFile = new WriteInFile("resources/decodedFile.txt");
        writeInFile.writeString(list);
    }
}