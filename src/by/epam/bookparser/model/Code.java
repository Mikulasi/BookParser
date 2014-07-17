package by.epam.bookparser.model;

public class Code implements TextPart {
    private String text;

    public Code() {

    }

    public Code(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
