package com.oocl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuessNumberTest {
    @Test
    public void should_return_error_when_input_duplicate_number(){
        GuessNumber guessNumber = new GuessNumber();
        boolean result = guessNumber.verifyInput(Arrays.asList(1, 2 ,3 ,3));
        assertEquals(false, result);
    }

    @Test
    public void should_return_error_when_input_5_number() {
        GuessNumber guessNumber = new GuessNumber();
        boolean result = guessNumber.verifyInput(Arrays.asList(1, 2 ,3 ,3, 5));
        assertEquals(false, result);
    }

    @Test
    public void should_generate_4_distinct_number(){
        int expected = 4;
        GuessNumber guessNumber = new GuessNumber();
        List<Integer> result = guessNumber.generateNumbers();
        long distinctCount = result.stream().distinct().count();
        assertEquals(expected, distinctCount);
    }

    @Test
    public void should_not_pass_when_include_invaild_number(){
        GuessNumber guessNumber = new GuessNumber();
        boolean result = guessNumber.verifyInput(Arrays.asList(1, 2, 3, 51));
        assertEquals(false, result);
    }

    @Test
    public void should_count_3_correct_number(){
        GuessNumber guessNumber = new GuessNumber();
        List<Integer> input = Arrays.asList(2, 1, 5, 3);
        List<Integer> answer = Arrays.asList(1, 2, 3, 4);

        String result = guessNumber.getFeedback(input, answer);
        assertEquals("0A3B", result);
    }

    @Test
    public void should_count_1_correct_position_and_1_correct_number(){
        GuessNumber guessNumber = new GuessNumber();
        List<Integer> input = Arrays.asList(9, 2, 5, 3);
        List<Integer> answer = Arrays.asList(1, 2, 3, 4);

        String result = guessNumber.getFeedback(input, answer);
        assertEquals("1A1B", result);
    }
}
