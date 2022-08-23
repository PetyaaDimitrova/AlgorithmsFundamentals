package com.company.HackerRank;

import java.util.Scanner;

public class Factoriel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(findFactoriel(n));
    }

    private static long findFactoriel(int n) {
        if (n == 1) {
            return n;
        }
        return (long) n * findFactoriel(n - 1);
    }
}
