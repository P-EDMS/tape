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
        boolean STATE_FLOAT = false;

        for(int i = 0; i < input.length(); i++) {

            c = input.charAt(i);
            isLastChar = input.length() == (i + 1);
            if(Character.isLetter(c) || Character.isDigit(c)) {

                word.append(c);

                STATE_EOW = false || isLastChar;
            } else if(c == '.' && !STATE_FLOAT && !isLastChar && Character.isDigit(input.charAt(i+1))) {

                System.out.println(".....................................who came in 1st:.............: " + c);

                if((word.length() > 0  && !Character.isLetter(word.charAt(word.length() - 1))) || word.length() == 0) {
                    System.out.println(".....................................who came in 2nd............. " + c);

                    word.append(c);
                    STATE_FLOAT = true;
                }else {
                    //unfortunately, for those uncaught element who get in
                    STATE_FLOAT = false;

                    word.setLength(0); //empty it
                }
                STATE_EOW = false;


            } else if (word.length() >= WORD_MIN_LIMIT) {
                STATE_EOW = true;
            } else {
                STATE_EOW = false;
                STATE_FLOAT = false;

                word.setLength(0); //empty it
            }

            if(STATE_EOW && word.length() >= WORD_MIN_LIMIT) {
                STATE_EOW = false;
                STATE_FLOAT = false;
                System.out.println("word added:" + word);

                result.add(word.toString());
                word.setLength(0); //empty it
            }
        }

        return result;
    }
}
