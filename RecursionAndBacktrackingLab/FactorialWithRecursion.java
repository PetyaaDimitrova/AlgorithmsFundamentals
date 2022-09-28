package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class FactorialWithRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        long factorial = findFactorial(number);

        System.out.println(factorial);
    }

    private static long findFactorial(int number) {
        if (number == 1){
            return 1;
        }
        return number * findFactorial(number-1);
    }

}
