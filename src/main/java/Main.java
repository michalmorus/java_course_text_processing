import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.ParseWord;
import parser.Parser;
import statistics.*;

import java.util.ArrayList;

public class Main {

    public static void main(String... args) {

        ArrayList<ParseWord> parseWords = Parser.getWordsFromURL("https://www.gutenberg.org/files/11/11-0.txt");

        Thread repeatWordsStatistics = new Thread(new RepeatWordsStatistics(parseWords));
        repeatWordsStatistics.start();

        Thread longestWordStatistics = new Thread(new LongestWordStatistics(parseWords));
        longestWordStatistics.start();

        Thread wordLinesOccuStatistics = new Thread(new WordLinesOccuStatistics(parseWords));
        wordLinesOccuStatistics.start();

        Thread descendingStatistics = new Thread(new DescendingStatistics(parseWords));
        descendingStatistics.start();

        Thread wordPairsStatistics = new Thread(new WordPairsStatistics(parseWords));
        wordPairsStatistics.start();

    }
}
