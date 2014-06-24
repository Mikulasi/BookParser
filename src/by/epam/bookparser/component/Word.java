package by.epam.bookparser.component;

import org.apache.log4j.Logger;

public class Word extends BookComponent {
    public static final Logger LOGGER = Logger.getLogger(Word.class);
    private String value;

    public Word(String value){
        this.value = value;
    }
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void print() {
        LOGGER.info("Word: " + getValue());
    }
}
