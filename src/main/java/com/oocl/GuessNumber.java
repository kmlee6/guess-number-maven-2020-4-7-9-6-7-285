package com.oocl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GuessNumber {
    final static int numOfGrid = 4;

    public boolean checkDuplicate(List<Integer> input){
        return input.stream().distinct().count()==numOfGrid;
    }

    public boolean checkNmberOfInput(List<Integer> input){
        return input.stream().count()==numOfGrid;
    }

    public boolean checkValidNumber(List<Integer> input){
        return input.stream().filter(number -> number>0 && number<10).count()==numOfGrid;
    }

    public boolean verifyInput(List<Integer> inputs) {
        return checkNmberOfInput(inputs) && checkDuplicate(inputs) && checkValidNumber(inputs);
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(1, 5);
    }

    public int countIntersection(List<Integer> listA, List<Integer> listB){
        return listA.stream()
                .filter(listB::contains)
                .collect(Collectors.reducing(0, e -> 1, Integer::sum));
    }

    public String getFeedback(List<Integer> answer, List<Integer> input) {
        String feedBackFormat = "%dA%dB";
        int intersectionCount = countIntersection(answer, input);
        return String.format(feedBackFormat, 0, intersectionCount);
    }
}
