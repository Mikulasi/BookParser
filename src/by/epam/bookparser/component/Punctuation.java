package by.epam.bookparser.component;

import org.apache.log4j.Logger;

public class Punctuation extends BookComponent {
    public static final Logger LOGGER = Logger.getLogger(Punctuation.class);
    private String value;
    public Punctuation(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void print() {
        LOGGER.info("Punctuation: "+ getValue());
    }
}
