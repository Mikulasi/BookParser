package by.epam.bookparser.model;

public class Sign implements TextPart {
    private String text;

    public Sign() {

    }

    public Sign(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}