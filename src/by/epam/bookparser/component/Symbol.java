package by.epam.bookparser.component;

import org.apache.log4j.Logger;

public class Symbol extends BookComponent {
    public static final Logger LOGGER = Logger.getLogger(Symbol.class);
    private String value;
    public Symbol(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void print() {
        LOGGER.info("Symbol: "+ getValue());
    }
}
