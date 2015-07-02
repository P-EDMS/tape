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



    //	Word def: Characters A-Z, a-z
    @Test public void itShouldExtractAZ() throws Exception {

        assertThat(WordExtractor.extract("cat...."))
                .hasSize(1)
                .contains("cat");

        assertThat(WordExtractor.extract("dog, hello."))
                .hasSize(2)
                .contains("dog", "hello");


        assertThat(WordExtractor.extract("CAT,              LOVE  Dog."))
                .hasSize(3)
                .contains("CAT", "LOVE", "Dog");


    }




}
