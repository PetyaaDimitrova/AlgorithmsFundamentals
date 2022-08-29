package com.company.newPackage;

import java.util.Scanner;

public class CheckPrimeNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberToCheck = Integer.parseInt(scan.nextLine());

        checkNumber(numberToCheck);
    }

    private static void checkNumber(int numberToCheck) {
        for(int i = 2; i < numberToCheck; i++){
            if(numberToCheck % i == 0){
                System.out.printf("%d is not a prime number.", numberToCheck);
                return;
            }
        }
        System.out.printf("%d is a prime number.", numberToCheck);
    }
}
