package com.oocl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner scanner = new Scanner(System.in);

    public static List<Integer> getNext(){
        String input = scanner.nextLine();
        return Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main( String[] args )
    {
        while(true){
            System.out.println(getNext());
        }
    }
}
