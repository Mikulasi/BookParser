package by.epam.bookparser.composite;

import by.epam.bookparser.component.ITextComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Text implements ITextComponent {

    private List<ITextComponent> textComponents = new ArrayList<ITextComponent>();

    public Text() {
    }

    @Override
    public void add(ITextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(ITextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public ITextComponent getText(int i) {
        return textComponents.get(i);
    }

    @Override
    public String parse() {
        return null;
    }

    @Override
    public Iterator<ITextComponent> getIterator() {
        return textComponents.iterator();
    }
}