package com.company.newPackage;

import java.util.Scanner;

public class FibonacciSeriesWithRecursion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int nextNumber = Integer.parseInt(scan.nextLine());
        int countOfNumbers = Integer.parseInt(scan.nextLine());

        System.out.print(firstNumber + " " + nextNumber + " ");

        findSumOfPreviousNumbers(firstNumber, nextNumber, countOfNumbers);
    }

    private static void findSumOfPreviousNumbers(int firstNumber, int nextNumber, int countOfNumbers) {
        countOfNumbers--;
        if (countOfNumbers >= 0) {
            int sum = firstNumber + nextNumber;
            System.out.print(sum + " ");
            findSumOfPreviousNumbers(nextNumber, sum, countOfNumbers);
        }
    }
}
