package statistics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.ParseWord;

import java.util.ArrayList;

abstract class AbstractStatistics {

    static final Logger logger = LogManager.getLogger();

    ArrayList<ParseWord> parseWords;

    AbstractStatistics(ArrayList<ParseWord> parseWord) {
        this.parseWords = parseWord;
    }

}
