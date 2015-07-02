package com.panton.tape;

/**
 * Created by roylee on 7/2/15.
 */
public class WordExtractor {



    public static String extract(String input) {

        String result = "";
        char tmp = ' ';
        for(int i = 0; i< input.length(); i++) {
            tmp = input.charAt(i);
            if(Character.isLetter(tmp)) {
                return "asd";
            }
        }
        return "asd";

    }
}
