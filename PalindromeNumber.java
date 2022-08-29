package com.company.newPackage;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int temp = number;
        int sum = 0;
        while (number > 0) {
            int n = number % 10;
            sum = sum * 10 + n;
            number = number/10;
        }
        if (temp == sum){
            System.out.printf("%d is a palindrome number.", temp);
        } else {
            System.out.printf("%d is not a palindrome number.", temp);
        }
    }
}
