package by.epam.bookparser.component;

import org.apache.log4j.Logger;

public class Paragraph extends BookComponent {
    public static final Logger LOGGER = Logger.getLogger(Paragraph.class);
    private String value;

    public Paragraph(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void print() {
        LOGGER.info("Paragraph: " + getValue());
    }
}
