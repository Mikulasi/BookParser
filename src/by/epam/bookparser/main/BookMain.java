package by.epam.bookparser.main;

import by.epam.bookparser.component.*;
import by.epam.bookparser.composite.Book;
import org.apache.log4j.Logger;

public class BookMain {
    public static final Logger LOGGER = Logger.getLogger(BookMain.class);
    public static void main(String[] args) {
        BookComponent symbol = new Symbol("J");
        BookComponent symbol2 = new Symbol("A");
        BookComponent symbol3 = new Symbol("V");
        BookComponent symbol4 = new Symbol("A");
        BookComponent word = new Word("Day");
        BookComponent punct = new Punctuation(",");
        BookComponent sentence = new Sentence("It was fine");
        BookComponent bookComponent = new Book("Effective java");
        bookComponent.add(symbol);
        bookComponent.add(symbol2);
        bookComponent.add(symbol3);
        bookComponent.add(symbol4);
        bookComponent.add(word);
        bookComponent.add(punct);
        bookComponent.add(sentence);
        BookComponent paragraph = new Paragraph("       ");
        Book book = new Book("Design Patterns");
        book.add(paragraph);
        book.add(bookComponent);
        book.print();

    }
}
