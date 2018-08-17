package parser;

import utils.TextFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Parser {

    public static ArrayList<ParseWord> getWordsFromURL(String strUrl) {

        ArrayList<ParseWord> wordList = new ArrayList<ParseWord>();
        try {
            URL url = new URL(strUrl);
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            int i = 1;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.trim().length() > 0) {
                        String normalized = TextFormatter.normalizeWord(word);
                        if (normalized != null) {
                            wordList.add(new ParseWord(normalized, i));
                        }

                    }
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
