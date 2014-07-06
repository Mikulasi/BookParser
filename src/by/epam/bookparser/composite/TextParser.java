package by.epam.bookparser.composite;

import by.epam.bookparser.component.TextPart;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    public static final Logger LOGGER = Logger.getLogger(TextParser.class);

    public TextParser() {
    }

    public Text parse(String path) {

        String text = initialization(path);
        Text fullText = new Text();
        fullText = parseToParagraph(fullText, text);
        return fullText;
    }

    private String initialization(String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            //BufferedReader buff = new BufferedReader(new InputStreamReader(inFile));
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
            //text = new String(buff.readLine()); // String with all text
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return text;
    }

    private Text parseToParagraph(Text fullText, String text) {
        // parse to paragraph
        Text paragraphList = new Text();
        Pattern patternParagraph = Pattern
                .compile("(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)");
        TextPart paragraphLeaf;
        String paragraph = "";
        Matcher matcher = patternParagraph.matcher(text);
        while (matcher.find()) {
            paragraph = matcher.group();
            if (Pattern.matches("\\s*(Start listing)([^\\t]+)(End listing)", paragraph)) {
                // if listing - add to list without parsing
                paragraphLeaf = new TextPart(paragraph);
                LOGGER.info(paragraphLeaf);
                paragraphList.add(paragraphLeaf);
            } else {
                LOGGER.info(paragraph);
                paragraphList = parseToSentence(paragraphList, paragraph);
            }
            fullText.add(paragraphList);
        }

        return fullText;
    }

    private Text parseToSentence(Text paragraphList, String paragraph) {
        // parse to sentence
        Text sentenceList = new Text();
        Pattern patternSentence = Pattern.compile("([^(\\.|!|\\?)]+)(\\.|!|\\?)");
        Matcher m2 = patternSentence.matcher(paragraph);
        String sentence = "";
        while (m2.find()) {
            sentence = m2.group();
            sentenceList = parseToWord(sentenceList, sentence);
            paragraphList.add(sentenceList);
        }
        return paragraphList;
    }

    private Text parseToWord(Text sentenceList, String sentence) {
        // parse to word
        Pattern patternWord = Pattern.compile("([^(\\s)]*)(\\s)*");
        String word = "";
        Matcher matcher = patternWord.matcher(sentence);
        Text wordList = new Text();
        while (matcher.find()) {
            word = matcher.group();
            wordList = parseToSignAndWord(wordList, word);
            sentenceList.add(wordList);
        }
        return sentenceList;
    }

    private Text parseToSignAndWord(Text wordList, String word) {
        // parse to sign and word
        Pattern pattern = Pattern.compile("([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)");
        String wordSign = "";
        Matcher matcher = pattern.matcher(word);
        Text wordSignList = new Text();
        while (matcher.find()) {
            wordSign = matcher.group();
            wordSignList = parseToSymbol(wordSignList, wordSign);
            wordList.add(wordSignList);
        }
        return wordList;
    }

    private Text parseToSymbol(Text wordSignList, String wordSign) {
        // parse to symbol
        Pattern pattern = Pattern.compile(".{1}");
        String symbol = "";
        Matcher matcher = pattern.matcher(wordSign);
        TextPart symbolList;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolList = new TextPart(symbol);

        }
        return wordSignList;
    }
}
