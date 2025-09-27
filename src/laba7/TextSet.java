package laba7;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextSet {
    public static void main(String[] args) {
        List<String> words;
        HashSet<String> wordsSet;
        String pathFile = "src/laba7/text.txt";
        String checkPhrases = "collection represents group of objects";

        String text = getText(pathFile);
        words = List.of(transformText(text));
        wordsSet = new HashSet<>(words);

        checkDiffCntWords(words.size(), wordsSet.size());
        checkPhrases(wordsSet, checkPhrases);
    }

    public static void checkPhrases(HashSet<String> wordsSet, String phrases) {
        Set<String> phrasesSet = new HashSet<>(Set.of(phrases.split("\\s+")));

        // retainAll вернет true, если множество изменилось, false - если не изменилось
        // оставляются слова, которые есть в обоих множествах, поэтому из более мелкого надо вызывать метод
        if (!phrasesSet.retainAll(wordsSet))
            System.out.println("Можно составить предложение \"" + phrases + "\"");
        else
            System.out.println("Нельзя составить предложение \"" + phrases + "\"");
    }

    public static void checkDiffCntWords(int cntUsuallyWord, int cntSetWords) {
        System.out.printf("Количество слов без мн-ва: %d, ", cntUsuallyWord);
        System.out.printf("Количество слов со мн-вом: %d, ", cntSetWords);
        System.out.printf("Разница: %d\n", cntUsuallyWord - cntSetWords);
    }

    public static String[] transformText(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[.?!]+", "");
        return text.split("[, ]+");
    }

    public static String getText(String path) {
        StringBuilder text = new StringBuilder();

        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return text.toString().replaceAll("[\\r\\n]+", " ").strip();
    }
}
