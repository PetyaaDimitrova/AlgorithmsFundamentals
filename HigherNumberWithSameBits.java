package com.company.EpamTasks;

import java.util.Scanner;

public class HigherNumberWithSameBits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        System.out.println(nextHigher(n));
    }


    public static int nextHigher(int n) {

        int sum = findSumOfDigitsInBinaryNumber(n);

        int sumNextNumberWithSameBinary = 0;
        int nextNumber = n + 1;
        while (sum != sumNextNumberWithSameBinary) {
            sumNextNumberWithSameBinary = findSumOfDigitsInBinaryNumber(nextNumber);
            if (sumNextNumberWithSameBinary == sum) {
                return nextNumber;
            }
            nextNumber++;
        }
        return 0;
    }

    public static int findSumOfDigitsInBinaryNumber(int number) {
        String numberToBinary = Integer.toBinaryString(number);
        int sum = 0;
        for (int i = 0; i < numberToBinary.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numberToBinary.charAt(i)));
        }
        return sum;
    }
}
