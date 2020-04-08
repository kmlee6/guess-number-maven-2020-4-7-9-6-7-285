package com.oocl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuessNumberTest {
    @Test
    public void should_return_error_when_input_duplicate_number(){
        String expected = "Wrong Input，Input again";
        GuessName guessName = new GuessName();
        boolean result = guessName.verifyInput(1, 2, 3, 3);
        assertEquals(false, result);
    }
}
