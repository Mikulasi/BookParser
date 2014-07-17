package by.epam.bookparser.util;

import java.util.ResourceBundle;

public class Bundle {
    public static ResourceBundle rb = ResourceBundle.getBundle("resources.regex");
    public static final String REGEX_PARAGRAPH_WITHOUT_CODE = rb.getString("regex_paragraph_without_code");
    public static final String REGEX_PARAGRAPH_WITH_CODE = rb.getString("regex_paragraph_with_code");
    public static final String REGEX_SENTENCE = rb.getString("regex_sentence");
    public static final String REGEX_SYMBOL = rb.getString("regex_symbol");
    public static final String REGEX_WORD = rb.getString("regex_word");
    public static final String REGEX_WORD_SIGN = rb.getString("regex_word_sign");
    public static final String REGEX_BLOCK_CODE = rb.getString("regex_block_code");
    public static final String REGEX_CONSONANT = rb.getString("regex_consonant");
}
