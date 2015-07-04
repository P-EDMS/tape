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
    @Test public void itShouldExtractLetters() throws Exception {

        assertThat(WordExtractor.extract("cat..."))
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
        assertThat(WordExtractor.extract("1.000"))
                .hasSize(1)
                .contains("1.000");

        assertThat(WordExtractor.extract("15055.0"))
                .hasSize(1)
                .contains("15055.0");

        assertThat(WordExtractor.extract("15055.0500."))
                .hasSize(1)
                .contains("15055.0500");

        //ask jim
        assertThat(WordExtractor.extract(".111212121"))
                .hasSize(1)
                .contains(".111212121");
        assertThat(WordExtractor.extract(".1771."))
                .hasSize(1)
                .contains(".1771");
    }


    @Test public void itShouldExtractAllCombinatory_Letter_Float_Numeric() throws Exception {

        //float and int
        assertThat(WordExtractor.extract(".1771.8888 111 33.33"))
                .hasSize(4)
                .contains(".1771", "8888", "111", "33.33");

        //float and int and letter and alpha-numeric
        assertThat(WordExtractor.extract("1111.aa.99999   fun very.good RM.111.RM199.11"))
                .hasSize(7)
                .contains("1111", "99999", "fun", "very", "good", "111", "RM199.11");

    }

    @Test public void ignoreWordLengthLessThan3() throws Exception {
        assertThat(WordExtractor.extract("I am a Female. "))
                .hasSize(1)
                .contains("Female");

        assertThat(WordExtractor.extract("I will be back as a Man.. .. ...    "))
                .hasSize(3)
                .contains("will", "back", "Man");
    }

}
