package by.epam.bookparser.main;

import by.epam.bookparser.composite.Text;
import by.epam.bookparser.composite.TextParser;
import org.apache.log4j.Logger;

public class TextMain {
    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger(TextMain.class);
        String path = ".\\src\\resources\\Book.txt";
        TextParser textParser = new TextParser();
        Text fullText = textParser.parse(path);
        //LOGGER.info(fullText);
    }
}

