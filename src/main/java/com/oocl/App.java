package com.oocl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    static Scanner scanner = new Scanner(System.in);

    public static List<Integer> getNext() {
        String input = scanner.nextLine();
        return Arrays.stream(input.trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int remainingChance = 6;
        List<Integer> answer = Arrays.asList(1, 2, 3, 4);
//        GuessNumber newGame = new GuessNumber(answer);
        GuessNumber newGame = new GuessNumber();
        while (remainingChance > 0) {
            List<Integer> input = getNext();
            if (!newGame.verifyInput(input)) {
                System.out.println("Wrong Input，Input again");
                continue;
            }
            String output = newGame.getFeedback(input);
            if (output.equals("4A0B")) {
                System.out.println("win, all correct");
                return;
            }
            System.out.println(output);
            remainingChance--;
        }
        System.out.println("Game over!");
    }
}
