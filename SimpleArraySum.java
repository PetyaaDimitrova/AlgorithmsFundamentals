package com.company.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleArraySum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        System.out.print(" = " + simpleArraySum(numbers));

    }

    public static int simpleArraySum(List<Integer> ar) {
        System.out.print(ar.stream().map(String::valueOf)
                .collect(Collectors.joining(" + ")));
        return ar.stream().mapToInt(e -> e).sum();
    }

}

