package com.panton.tape;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by roylee on 7/2/15.
 */
public class WordExtractorTest {

    @Before public void setUp() throws Exception {

    }



    //word: [A-Za-z]
    @Test public void itShouldExtractAZ() throws Exception {

        assertThat(WordExtractor.extract("cat...."))
                .hasSize(1)
                .contains("cat");

        assertThat(WordExtractor.extract("dog, hello."))
                .hasSize(2)
                .contains("dog", "hello");


        assertThat(WordExtractor.extract("CAT,              LOVE  Dog"))
                .hasSize(3)
                .contains("CAT", "LOVE", "Dog");

    }

    //word: [0-9]
    @Test public void itShouldExtractDigits() throws Exception {

        assertThat(WordExtractor.extract("450"))
                .hasSize(1)
                .contains("450");

        assertThat(WordExtractor.extract("0123, 3819,   450"))
                .hasSize(3)
                .contains("0123", "3819", "450");
    }

    //word: [A-Za-z0-9]
    @Test public void itShouldExtractAlphaNumeric() throws Exception {

        assertThat(WordExtractor.extract("Rm450"))
                .hasSize(1)
                .contains("Rm450");

        assertThat(WordExtractor.extract("RM12300 ,:::;. AlPha690,   MH3600"))
                .hasSize(3)
                .contains("RM12300", "AlPha690", "MH3600");
    }


    @Test public void itShouldExtractFloatingNumbers() throws Exception {

    }

    @Test public void ignoreWordLengthLessThan3() throws Exception {
        assertThat(WordExtractor.extract("I am a Female."))
                .hasSize(1)
                .contains("Female");

        assertThat(WordExtractor.extract("I will be back as a Man.. .    "))
                .hasSize(3)
                .contains("will", "back", "Man");

    }

}
