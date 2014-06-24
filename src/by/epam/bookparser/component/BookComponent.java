package by.epam.bookparser.component;

public abstract class BookComponent {
    public void add (BookComponent bookComponent){
        throw new UnsupportedOperationException();

    }
    public void remove(BookComponent bookComponent){
        throw new UnsupportedOperationException();

    }
    public BookComponent getChild(int i){
        throw new UnsupportedOperationException();

    }
    public String getValue(){
        throw new UnsupportedOperationException();

    }
    public void print(){
        throw new UnsupportedOperationException();
    }
}
