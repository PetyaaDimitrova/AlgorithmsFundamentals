package com.company;

import java.util.Scanner;

public class FibonacciSeriesWithoutRecursion {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        int nextNumber = Integer.parseInt(scan.nextLine());
        int countOfNumbers = Integer.parseInt(scan.nextLine());

        System.out.print(firstNumber + " " + nextNumber + " ");

        for (int i = 0; i < countOfNumbers -2 ; i++) {
            int sum = firstNumber + nextNumber;
            System.out.print(sum + " ");
            firstNumber = nextNumber;
            nextNumber = sum;
        }
    }
}
