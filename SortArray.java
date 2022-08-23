package com.company.HackerRank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] newArr = sortNumbers(numbers);

        String result = Arrays.stream(newArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    private static int[] sortNumbers(int[] numbers) {
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers.length - 1 - j; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return numbers;
    }
}
