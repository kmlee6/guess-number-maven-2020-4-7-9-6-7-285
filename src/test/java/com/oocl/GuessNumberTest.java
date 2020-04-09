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
    public void should_return_4A0B_when_input_1234_given_answer_1234() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        String result = guessNumber.getFeedback(input);
        assertEquals("4A0B", result);
    }

    @Test
    public void should_return_0A4B_when_input_4321_given_answer_1234() {
        List<Integer> input = Arrays.asList(4, 3, 2, 1);
        String result = guessNumber.getFeedback(input);
        assertEquals("0A4B", result);
    }

    @Test
    public void should_return_0A0B_when_input_5678_given_answer_1234() {
        List<Integer> input = Arrays.asList(5, 6, 7, 8);
        String result = guessNumber.getFeedback(input);
        assertEquals("0A0B", result);
    }

    @Test
    public void should_return_2A0B_when_input_1256_given_answer_1234() {
        List<Integer> input = Arrays.asList(1, 2, 5, 6);
        String result = guessNumber.getFeedback(input);
        assertEquals("2A0B", result);
    }

    @Test
    public void should_return_0A2B_when_input_1256_given_answer_1234() {
        List<Integer> input = Arrays.asList(2, 1, 5, 6);
        String result = guessNumber.getFeedback(input);
        assertEquals("0A2B", result);
    }

    @Test
    public void should_return_2A2B_when_input_1243_given_answer_1234() {
        List<Integer> input = Arrays.asList(1, 2, 4, 3);
        String result = guessNumber.getFeedback(input);
        assertEquals("2A2B", result);
    }
}
