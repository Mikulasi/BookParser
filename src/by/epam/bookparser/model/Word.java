package by.epam.bookparser.model;

public class Word implements TextPart {
    private String text;

    public Word() {

    }

    public Word(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
