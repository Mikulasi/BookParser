package by.epam.bookparser.component;

import java.util.Iterator;

public class TextPart implements ITextComponent {

    private String string;

    public TextPart(String string) {
        this.string = string;
    }

    @Override
    public void add(ITextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(ITextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ITextComponent getText(int i) {
        return this;
    }

    @Override
    public String parse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<ITextComponent> getIterator() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return string;
    }
}

