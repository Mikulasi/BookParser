package by.epam.bookparser.model;

import java.util.ArrayList;

public class Sentence implements TextPart {
    private ArrayList<TextPart> parts = new ArrayList<>();

    public Sentence() {

    }

    public void addPart(TextPart textPart) {
        parts.add(textPart);
    }

    public ArrayList<TextPart> getParts() {
        return parts;
    }

    public void setParts(ArrayList<TextPart> parts) {
        this.parts = parts;
    }

}
