package statistics;

import org.apache.logging.log4j.Logger;
import parser.ParseWord;

import java.util.ArrayList;
import java.util.HashMap;

public class WordLinesOccuStatistics extends AbstractStatistics implements Runnable {

    HashMap<String, ArrayList<Integer>> wordsLines = new HashMap<String, ArrayList<Integer>>();

    public WordLinesOccuStatistics(ArrayList<ParseWord> parseWord) {
        super(parseWord);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        logger.info("Zadanie 3 - Dla każdego słowa zapisać w jakiej linii występowało i wypisać");

        for (ParseWord parseWord : parseWords) {
            String key = parseWord.getWord();
            ArrayList<Integer> list = wordsLines.get(key);
            if (list != null) {
                list.add(parseWord.getLine());
            } else {
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.add(parseWord.getLine());
                wordsLines.put(key, newList);
            }
        }

        long duration = (System.currentTimeMillis() - startTime);
        logger.info("Zadanie 3 czas: " + duration + " ms");

        logger.trace("Zadanie 3 wynik: ");
        wordsLines.forEach((word, lines) -> {
            logger.trace(word + " - " + lines.toString());
        });
    }
}
