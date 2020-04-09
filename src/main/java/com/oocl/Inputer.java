package com.oocl;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inputer {
    Scanner scanner;

    public Inputer(InputStream inputStream){
        scanner=new Scanner(inputStream);
    }

    public List<Integer> getNext() {
        String input = scanner.nextLine();
        return Arrays.stream(input.trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
