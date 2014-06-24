package by.epam.bookparser.client;

import by.epam.bookparser.component.BookComponent;
import org.apache.log4j.Logger;

public class Reader {
    public static final Logger LOGGER = Logger.getLogger(Reader.class);
    private BookComponent bookComponent;

    public Reader(BookComponent bookComponent){
        this.bookComponent = bookComponent;
    }

    public void getBookComponent(){
        LOGGER.info(bookComponent.toString());
    }
}
