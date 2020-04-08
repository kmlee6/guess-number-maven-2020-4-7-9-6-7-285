package com.oocl;

import java.util.Arrays;

public class GuessName {
    final static int numOfGrid = 4;

    public boolean verifyInput(int... inputs) {
        return Arrays.stream(inputs).distinct().count()==numOfGrid;
    }
}
