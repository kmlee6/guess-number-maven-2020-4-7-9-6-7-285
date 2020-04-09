package com.oocl;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuessNumberTest {
    GuessNumber guessNumber;

    @Before
    public void setUp() {
        List<Integer> answer = Arrays.asList(1, 2, 3, 4);
        guessNumber = new GuessNumber(answer);
    }

    @Test
    public void should_generate_4_distinct_number() {
        int expected = 4;
        List<Integer> result = guessNumber.generateNumbers();
        long distinctCount = result.stream().distinct().count();
        assertEquals(expected, distinctCount);
    }

    @Test
    public void should_return_error_when_input_duplicate_number() {
        boolean result = guessNumber.verifyInput(Arrays.asList(1, 2, 3, 3));
        assertEquals(false, result);
    }

    @Test
    public void should_return_error_when_input_5_number() {
        boolean result = guessNumber.verifyInput(Arrays.asList(1, 2, 3, 3, 5));
        assertEquals(false, result);
    }

    @Test
    public void should_not_pass_when_include_invaild_number() {
        boolean result = guessNumber.verifyInput(Arrays.asList(1, 2, 3, 51));
        assertEquals(false, result);
    }

    @Test
    public void should_count_3_correct_number() {
        List<Integer> input = Arrays.asList(2, 1, 5, 3);
        String result = guessNumber.getFeedback(input);
        assertEquals("0A3B", result);
    }

    @Test
    public void should_count_1_correct_position_and_1_correct_number() {
        List<Integer> input = Arrays.asList(9, 2, 5, 3);
        List<Integer> answer = Arrays.asList(1, 2, 3, 4);
        String result = guessNumber.getFeedback(input);
        assertEquals("1A1B", result);
    }
}
