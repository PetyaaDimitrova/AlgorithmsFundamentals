package RecursionAndBacktracking;

import java.util.Scanner;

public class FactorialWithWhileLoop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        long factorial = number;
        while (number != 1){
            number--;
            factorial = factorial * number;
        }
        System.out.println(factorial);

    }
}
