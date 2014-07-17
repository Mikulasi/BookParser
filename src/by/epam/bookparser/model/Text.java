package by.epam.bookparser.model;

import java.util.ArrayList;

public class Text implements TextPart {
    private ArrayList<TextPart> parts = new ArrayList<>();

    public ArrayList<TextPart> getParts() {
        return parts;
    }

    public void addPart(TextPart textPart) {
        parts.add(textPart);
    }

}
