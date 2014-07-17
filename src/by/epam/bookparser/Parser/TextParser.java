package by.epam.bookparser.Parser;

import by.epam.bookparser.model.*;
import by.epam.bookparser.util.Bundle;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextParser {
    public static final Logger LOGGER = Logger.getLogger(TextParser.class);

    public TextParser() {

    }

    public Text parse(String path) {
        String text = initialization(path);
        Text allText = new Text();
        allText = parseToParagraphWithCode(allText, text);
        return allText;
    }


    private String initialization(final String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return text;
    }

    private Text parseToParagraphWithCode(Text wholeText, String text) {
        Paragraph paragraph;
        Code codeBlock;
        Pattern patternSentenceCode = Pattern
                .compile(Bundle.REGEX_PARAGRAPH_WITH_CODE);
        String code;
        String paragraphString;
        Matcher matcher = patternSentenceCode.matcher(text);
        Pattern paragraphPattern = Pattern.compile(Bundle.REGEX_PARAGRAPH_WITHOUT_CODE);
        Pattern codePattern = Pattern.compile(Bundle.REGEX_BLOCK_CODE);
        Matcher paragraphMatcher;
        Matcher codeMatcher;
        while (matcher.find()) {
            codeMatcher = codePattern.matcher(matcher.group());
            paragraphMatcher = paragraphPattern.matcher(matcher.group());
            if (paragraphMatcher.find()) {
                paragraphString = paragraphMatcher.group();
                paragraph = parseToSentence(paragraphString);
                wholeText.addPart(paragraph);
            }
            if (codeMatcher.find()) {
                code = codeMatcher.group();
                codeBlock = new Code(code);
                wholeText.addPart(codeBlock);
            }
        }

        return wholeText;

    }

    private Paragraph parseToSentence(String text) {
        Paragraph paragraph = new Paragraph();
        Sentence sentence;
        Pattern patternSentenceCode = Pattern
                .compile(Bundle.REGEX_SENTENCE);
        String sentenceString = "";
        Matcher matcher = patternSentenceCode.matcher(text);
        while (matcher.find()) {
            sentenceString = matcher.group();
            sentence = parseToWord(sentenceString);
            paragraph.addParts(sentence);
        }

        return paragraph;

    }

    private Sentence parseToWord(String sentenceString) {
        Word word;
        Sign sign;
        Sentence sentence = new Sentence();
        Pattern patternWord = Pattern.compile(Bundle.REGEX_WORD);
        Pattern patternSign = Pattern.compile(Bundle.REGEX_SYMBOL);
        Pattern pattern = Pattern.compile(Bundle.REGEX_WORD_SIGN);
        String wordString;
        Matcher matcherWord;
        Matcher matcherSign;
        Matcher matcher = pattern.matcher(sentenceString);
        while (matcher.find()) {
            matcherSign = patternSign.matcher(matcher.group());
            matcherWord = patternWord.matcher(matcher.group());
            if (matcherWord.find()) {
                wordString = matcherWord.group();
                word = new Word(wordString);
                sentence.addPart(word);
            }
            if (matcherSign.find()) {
                wordString = matcherSign.group();
                sign = new Sign(wordString);
                sentence.addPart(sign);
            }

        }

        return sentence;

    }


}
