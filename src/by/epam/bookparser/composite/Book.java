package by.epam.bookparser.composite;

import by.epam.bookparser.component.BookComponent;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book extends BookComponent {
    public static final Logger LOGGER = Logger.getLogger(Book.class);
    private String value;

    public Book(String value){
        this.value = value;
    }
    List<BookComponent> bookComponents = new ArrayList<BookComponent>();

    public void add(BookComponent bookComponent){
        bookComponents.add(bookComponent);
    }

    public void remove(BookComponent bookComponent){
        bookComponents.remove(bookComponent);
    }

    public BookComponent getChild(int i){
        return bookComponents.get(i);
    }

    public String getValue(){
        return value;
    }

    public void print(){
        LOGGER.info("Book: "+ getValue());
        Iterator<BookComponent> bookComponentIterator = bookComponents.iterator();
        while (bookComponentIterator.hasNext()){
            BookComponent bookComponent = bookComponentIterator.next();
            bookComponent.print();
        }
    }
}