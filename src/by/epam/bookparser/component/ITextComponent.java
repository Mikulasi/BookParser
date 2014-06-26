package by.epam.bookparser.component;

import java.util.Iterator;

public interface ITextComponent {
    public void add(ITextComponent textComponent);

    public void remove(ITextComponent textComponent);

    public ITextComponent getText(int i);

    public String parse();

    public Iterator<ITextComponent> getIterator();
}
