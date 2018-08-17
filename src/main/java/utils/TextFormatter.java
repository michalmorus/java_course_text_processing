package utils;

public class TextFormatter {

    public static String normalizeWord(String word) {
        String text = word.toLowerCase().trim();
        char last = text.charAt(text.length() - 1);
        if (!Character.isLetter(last)) {
            text = text.substring(0, text.length() - 1);
        }

        boolean allLetters = text.chars().allMatch(Character::isLetter);
        if (allLetters) {
            return text;
        } else {
            return null;
        }
    }
}
