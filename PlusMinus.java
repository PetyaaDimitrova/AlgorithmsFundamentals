package com.company.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        plusMinus(numbers);

    }

    public static void plusMinus(List<Integer> arr) {
      double countPositiveNumbers = 0;
      double countNegativeNumbers = 0;
      double countZero = 0;

        for (int number: arr) {
            if(number > 0){
                countPositiveNumbers ++;
            } else if(number < 0){
                countNegativeNumbers ++;
            } else {
                countZero ++;
            }


        }
        double arrSize = arr.size();
        System.out.println(countPositiveNumbers/arrSize);
        System.out.println(countNegativeNumbers/arrSize);
        System.out.println(countZero/arrSize);

    }
}