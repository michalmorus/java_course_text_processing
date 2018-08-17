package parser;

public class ParseWord {

    private int line;
    private String word;

    public ParseWord(String word, int line) {
        this.line = line;
        this.word = word;
    }

    public int getLine() {
        return line;
    }

    public String getWord() {
        return word;
    }
}
