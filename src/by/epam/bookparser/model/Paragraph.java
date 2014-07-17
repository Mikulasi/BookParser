package by.epam.bookparser.model;

import java.util.ArrayList;

public class Paragraph implements TextPart {
    private ArrayList<TextPart> parts = new ArrayList<TextPart>();

    public ArrayList<TextPart> getParts() {
        return parts;
    }

    public void addParts(TextPart textPart) {
        parts.add(textPart);
    }

}
