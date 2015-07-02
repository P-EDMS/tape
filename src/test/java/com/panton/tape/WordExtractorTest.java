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



    //	3.0.1 Characters A-Z, a-z
    @Test public void itShouldExtractAZ() throws Exception {

       assertThat(WordExtractor.extract("asd....")).isEqualTo("asd");
    }




}
