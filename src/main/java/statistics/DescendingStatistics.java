package statistics;

import parser.ParseWord;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class DescendingStatistics extends AbstractStatistics implements Runnable {

    TreeSet<String> descendingWords = new TreeSet<String>((str1, str2) -> str2.compareTo(str1));

    public DescendingStatistics(ArrayList<ParseWord> parseWord) {
        super(parseWord);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        logger.info("Zadanie 4 - Posortować słowa malejąco i wpisać do pliku tekstowego");

        for (ParseWord parseWord : parseWords) {
            descendingWords.add(parseWord.getWord());
        }

        try {
            File file = new File("./descending-words.txt");
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            descendingWords.forEach(writer::println);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        long duration = (System.currentTimeMillis() - startTime);
        logger.info("Zadanie 4 czas: " + duration + " ms");

    }
}
