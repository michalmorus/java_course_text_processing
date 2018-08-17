package statistics;

import parser.ParseWord;

import java.util.*;
import java.util.stream.Stream;

public class LongestWordStatistics extends AbstractStatistics implements Runnable  {

    HashMap<String, Integer> longestWordsMap = new HashMap<String, Integer>();

    public LongestWordStatistics(ArrayList<ParseWord> parseWord) {
        super(parseWord);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        logger.info("Zadanie 2 - Znaleźć najdłuższych 10 słów");

        for (ParseWord parseWord : parseWords) {
            String key = parseWord.getWord();
            longestWordsMap.computeIfAbsent((key), String::length);
        }

        Stream<Map.Entry<String, Integer>> filtered = longestWordsMap
                .entrySet()
                .stream()
                .sorted((f1, f2) ->
                    f2.getValue().compareTo(f1.getValue())
                ).limit(10);

        long duration = (System.currentTimeMillis() - startTime);
        logger.info("Zadanie 2 czas: " + duration + " ms");

        logger.trace("Zadanie 2 wynik: ");
        filtered.forEach((s) -> logger.trace(s.getKey() + " " + s.getValue()));
    }
}
