package by.epam.bookparser.component;

import org.apache.log4j.Logger;

public class Sentence extends BookComponent {
    public static final Logger LOGGER = Logger.getLogger(Sentence.class);
    private String value;

    public Sentence(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void print() {
        LOGGER.info("Sentence: "+ getValue());
    }
}
