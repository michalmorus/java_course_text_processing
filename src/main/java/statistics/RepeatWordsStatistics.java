package statistics;

import parser.ParseWord;

import java.util.ArrayList;
import java.util.HashMap;

public class RepeatWordsStatistics extends AbstractStatistics implements Runnable  {

    HashMap<String, Integer> repeatWords = new HashMap<String, Integer>();

    public RepeatWordsStatistics(ArrayList<ParseWord> parseWord) {
        super(parseWord);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        logger.info("Zadanie 1 - Zrobić statystykę wystąpienia słów (nie rozróżniamy wielkości)");

        for (ParseWord parseWord : parseWords) {
            String key = parseWord.getWord();
            repeatWords.put(key, repeatWords.getOrDefault(key, 1) + 1);
        }

        long duration = (System.currentTimeMillis() - startTime);
        logger.info("Zadanie 1 czas: " + duration + " ms");

        logger.trace("Zadanie 1 wynik: ");
        repeatWords.forEach((word, repeats) -> {
            logger.trace(word + " - " + repeats);
        });
    }
}
