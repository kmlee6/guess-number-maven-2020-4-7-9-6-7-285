package com.oocl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GuessNumber {
    final static int GRID_NUMBER = 4;
    List<Integer> secretNumber;

    public GuessNumber() {
        secretNumber = generateNumbers();
    }

    public GuessNumber(List<Integer> secretNumber) {
        this.secretNumber = secretNumber;
    }

    private boolean checkDuplicate(List<Integer> input) {
        return input.stream().distinct().count() == GRID_NUMBER;
    }

    private boolean checkNumberOfInput(List<Integer> input) {
        return input.stream().count() == GRID_NUMBER;
    }

    private boolean checkValidNumber(List<Integer> input) {
        return input.stream().filter(number -> number >= 0 && number < 10).count() == GRID_NUMBER;
    }

    public boolean verifyInput(List<Integer> inputs) {
        return checkNumberOfInput(inputs) && checkDuplicate(inputs) && checkValidNumber(inputs);
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(1, 5);
    }

    private int countIntersection(List<Integer> listA, List<Integer> listB) {
        return listA.stream()
                .filter(listB::contains)
                .collect(Collectors.reducing(0, e -> 1, Integer::sum));
    }

    private int countCorrectPosition(List<Integer> listA, List<Integer> listB) {
        return (int) IntStream
                .range(0, GRID_NUMBER)
                .filter(index -> listA.get(index) == listB.get(index))
                .count();
    }

    public String getFeedback(List<Integer> input) {
        final String feedBackFormat = "%dA%dB";
        int correctPositionCount = countCorrectPosition(secretNumber, input);
        int correctNumberCount = countIntersection(secretNumber, input) - correctPositionCount;
        return String.format(feedBackFormat, correctPositionCount, correctNumberCount);
    }
}
