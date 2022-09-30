package HackerRank;

import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        staircase(n);
    }

    private static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            printSpaces(n - 1 - i);
            printDiez(i + 1);
            System.out.println();
        }
    }

    private static void printDiez(int dies) {
        while (dies>0){
            System.out.print("#");
            dies--;
        }
    }

    private static void printSpaces(int spaces) {
        while (spaces>0){
            System.out.print(" ");
            spaces--;
        }

    }
}
