package by.epam.bookparser.util;

import by.epam.bookparser.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextManipulation {
    public static void replaceWordsSubstring(Text text, String substring, int length, int iterator) {
        Paragraph paragraph = getParagraph(text);
        TextPart part = paragraph.getParts().get(iterator);
        Pattern pattern = Pattern.compile(Bundle.REGEX_WORD);
        Matcher matcher;
        if (part.getClass().equals(Sentence.class)) {
            for (TextPart word : ((Sentence) part).getParts()) {
                matcher = pattern.matcher(word.toString());
                if (matcher.find() && matcher.group().length() == length) {
                    ((Word) word).setText(substring);
                }
            }
        }
    }

    public static void deleteConsonants(Text text, int length) {
        Paragraph paragraph = getParagraph(text);
        Pattern pattern = Pattern.compile(Bundle.REGEX_CONSONANT);
        for (TextPart comp : paragraph.getParts()) {
            if (comp.getClass().equals(Sentence.class)) {
                Iterator<TextPart> word = ((Sentence) comp).getParts().iterator();
                while (word.hasNext()) {
                    Matcher matcher = pattern.matcher(word.next().toString());
                    if (matcher.find()) {
                        if (matcher.group().length() == length) {
                            word.remove();
                        }
                    }
                }
            }
        }
    }


    public static void deleteFirstLastWords(Text text) throws StringIndexOutOfBoundsException {
        Paragraph paragraph = getParagraph(text);
        Pattern pattern = Pattern.compile(Bundle.REGEX_WORD);
        Matcher matcher;
        for (TextPart comp : paragraph.getParts()) {
            ArrayList<TextPart> componentTextList = new ArrayList<>();
            if (comp.getClass().equals(Sentence.class)) {
                for (TextPart sentence : ((Sentence) comp).getParts()) {
                    matcher = pattern.matcher(sentence.toString());
                    if (matcher.find()) {
                        componentTextList.add(sentence);
                    }
                }
                String replaceStringFirst;
                String replaceStringSecond;
                int size = componentTextList.size();
                int i = 0;
                int y = 1;
                replaceStringFirst = componentTextList.get(size - i).toString();
                replaceStringSecond = componentTextList.get(y).toString();
                ((Word) componentTextList.get(i)).setText(replaceStringSecond);
                ((Word) componentTextList.get(size - y)).setText(replaceStringFirst);

            }
        }
    }


    private static Paragraph getParagraph(Text text) {
        Paragraph paragraph = new Paragraph();
        Pattern pattern = Pattern.compile(Bundle.REGEX_PARAGRAPH_WITHOUT_CODE);
        for (TextPart textPart : text.getParts()) {
            Matcher matcher = pattern.matcher(textPart.toString());
            if (matcher.find()) {
                Iterator iteratorSentence = ((Paragraph) textPart).getParts().iterator();
                while (iteratorSentence.hasNext()) {
                    paragraph.addParts((TextPart) iteratorSentence.next());
                }
            }

        }
        return paragraph;
    }

}
