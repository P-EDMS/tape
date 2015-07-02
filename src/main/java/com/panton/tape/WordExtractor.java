package com.panton.tape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roylee on 7/2/15.
 */
public class WordExtractor {



    public static List<String> extract(String input) {

        List<String> result = new ArrayList<String>();
        String word = "";
        char c = ' ';

        for(int i = 0; i< input.length(); i++) {

            c = input.charAt(i);
            if(Character.isLetter(c)) {
                word += c;
            }
            else if(word.length() != 0){
                result.add(word);
                word = "";
            }
        }

        return result;
    }
}
