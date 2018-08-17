package statistics;

import parser.ParseWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordPairsStatistics extends AbstractStatistics implements Runnable {

    HashMap<String, Integer> hashMap = new HashMap<>();

    public WordPairsStatistics(ArrayList<ParseWord> parseWord) {
        super(parseWord);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        logger.info("Zadanie 5 - Znaleźć pary słów występujące obok siebie najczęściej");


        for (int i=1; i<parseWords.size(); i++) {
            String hash = parseWords.get(i-1).getWord() + " - " + parseWords.get(i).getWord();
            hashMap.put(hash, hashMap.getOrDefault(hash, 1) + 1);
        }

        Stream<Map.Entry<String, Integer>> filtered = hashMap
                .entrySet()
                .stream()
                .sorted((f1, f2) ->
                        f2.getValue().compareTo(f1.getValue())
                );

        long duration = (System.currentTimeMillis() - startTime);
        logger.info("Zadanie 5 czas: " + duration + " ms");

        logger.trace("Zadanie 5 wynik: ");
        filtered.forEach((data) -> {
            logger.trace(data.getKey().toString() + " - " + data.getValue());
        });
    }
}
