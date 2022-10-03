

import java.util.Scanner;

public class Factoriel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(findFactorial(n));
    }

    private static long findFactorial(int n) {
        if (n == 1) {
            return n;
        }
        return (long) n * findFactorial(n - 1);
    }
}
