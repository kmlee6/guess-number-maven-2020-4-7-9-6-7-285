package com.oocl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GuessNumber {
    final static int numOfGrid = 4;

    public boolean checkDuplicate(int[] input){
        return Arrays.stream(input).distinct().count()==numOfGrid;
    }

    public boolean checkNmberOfInput(int[] input){
        return Arrays.stream(input).count()==numOfGrid;
    }

    public boolean verifyInput(int... inputs) {
        return checkNmberOfInput(inputs) && checkDuplicate(inputs);
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(1, 5);
    }
}
