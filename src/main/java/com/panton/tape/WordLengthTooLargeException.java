package com.panton.tape;

import java.io.IOException;

/**
 * Created by roylee on 7/2/15.
 */
public class WordLengthTooLargeException extends RuntimeException {

    private final String word;
    public WordLengthTooLargeException(String message, IOException e, String word) {
        super(message, e);
        this.word = word;
    }

    public int getWordLength(){
        return word.length();
    }
    public String getWord(){
        return word;
    }
}
