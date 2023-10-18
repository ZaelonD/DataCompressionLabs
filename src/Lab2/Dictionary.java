package Lab2;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    private static int dictionarySize;
    private Map<String, Integer> dictionary;
    private final String text;

    public Dictionary(String text) {
        this.text = text;
        initDictionary();
        writeDictionaryInFile("resources/init_dictionary.txt");
    }

    public void writeDictionaryInFile(String path) {
        WriteInFile writeInFile = new WriteInFile(path);
        dictionary = dictionary.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
        writeInFile.writeHashMap(dictionary);
    }

    private void initDictionary() {
        this.dictionary = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            set.add(text.charAt(i));
        }
        Iterator<Character> i = set.iterator();
        for (dictionarySize = 0; i.hasNext(); dictionarySize++) {
            addSubstringInDictionary(dictionarySize, String.valueOf(i.next()));
        }
    }

    public void addSubstringInDictionary(int code, String word) {
        dictionary.put(word, code);
    }

    public void addSubstringInDictionary(String str) {
        dictionary.put(str, dictionarySize++);
    }

    public Map<String, Integer> getDictionary() {
        return dictionary;
    }
}