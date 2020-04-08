package com.oocl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuessNumberTest {
    @Test
    public void should_return_error_when_input_duplicate_number(){
        GuessNumber guessNumber = new GuessNumber();
        boolean result = guessNumber.verifyInput(1, 2, 3, 3);
        assertEquals(false, result);
    }

    @Test
    public void should_return_error_when_input_5_number() {
        GuessNumber guessNumber = new GuessNumber();
        boolean result = guessNumber.verifyInput(1, 2, 3, 3, 4);
        assertEquals(false, result);
    }

    @Test
    public void should_generate_4_distinct_number(){
        int expected = 4;
        GuessNumber guessNumber = new GuessNumber();
        List<Integer> result = guessNumber.generateNumbers();
        long distinctCount = result.stream().distinct().count();
        assertEquals(4, distinctCount);

    }
}
