package HackerRank;

import java.util.Scanner;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        System.out.println(sumOfTwoIntegers(a, b));
    }

    public static int sumOfTwoIntegers(int a, int b){
        return a + b;
    }
}
