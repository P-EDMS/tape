package com.panton.tape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roylee on 7/2/15.
 */
public class WordExtractor {

    private static final int WORD_MAX_LIMIT = 20; // one file system block
    private static final int WORD_MIN_LIMIT = 3;

    public static List<String> extract(String input) {

        List<String> result = new ArrayList<String>();
        StringBuilder word = new StringBuilder(WORD_MAX_LIMIT); //more efficient
        char c = ' ';

        boolean isLastChar = false;
        boolean STATE_EOW = false; //end of word

        for(int i = 0; i < input.length(); i++) {

            c = input.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)) {
                System.out.println("char:" + c + ", isLastChar:" + isLastChar);
                isLastChar = input.length() == (i + 1);
                word.append(c);
                STATE_EOW = false || isLastChar;
            } else if (word.length() >= WORD_MIN_LIMIT) {
                STATE_EOW = true;
            } else {
              word.setLength(0); //empty it
            }

            if(STATE_EOW && word.length() >= WORD_MIN_LIMIT) {
                STATE_EOW = false;
                System.out.println("word added:" + word);

                result.add(word.toString());
                word.setLength(0); //empty it
            }
        }

        return result;
    }
}
