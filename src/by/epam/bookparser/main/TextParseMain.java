package by.epam.bookparser.main;


import by.epam.bookparser.Parser.TextParser;
import by.epam.bookparser.util.TextManipulation;
import org.apache.log4j.Logger;

public class TextParseMain {
    private static final Logger LOGGER = Logger.getLogger(TextParseMain.class);
    public static final String BOOK_PATH = "text.txt";

    public static void main(String[] args) {
        String substring = "where";
        int length = 5;
        int sentence = 1;
        TextParser text = new TextParser();
        TextManipulation.deleteFirstLastWords(text.parse(BOOK_PATH));
        TextManipulation.deleteConsonants(text.parse(BOOK_PATH), length);
        TextManipulation.replaceWordsSubstring(text.parse(BOOK_PATH), substring, length, sentence);
        LOGGER.info(text);
    }
}
