package Lab1;

public class HuffmanFromConsoleImpl implements HuffmanLogic {

    private final EncodeText encodeText;
    private final DecodeText decodeText;

    public HuffmanFromConsoleImpl() {
        this.encodeText = new EncodeText();
        this.decodeText = new DecodeText();
    }

    @Override
    public void runHuffman() {
        long startTimeEncoded = System.currentTimeMillis();
        // Применяем функцию кодирования
        encodeText.encode();
        // Записываем результат кодирования в переменную code
        String code = encodeText.getEncodedText();
        long endTimeEncoded = System.currentTimeMillis();

        long startTimeDecoded = System.currentTimeMillis();
        // Применяем функцию декодирования
        decodeText.decode(code, encodeText.getTreeClass());
        long endTimeDecoded = System.currentTimeMillis();

        System.out.println("Время кодирования: " + (endTimeEncoded - startTimeEncoded) + " мс");
        System.out.println("Время декодирования: " + (endTimeDecoded - startTimeDecoded) * 1000 + " мкс");
        System.out.println("Размер исходной строки: " + encodeText.getInitialText().getBytes().length * 8 + " бит");
        System.out.println("Размер сжатой строки: " + code.length() + " бит");
    }
}