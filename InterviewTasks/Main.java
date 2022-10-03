package InterviewTasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Factorial factorial = new Factorial();

        System.out.println(factorial.findFactorialWithRecursion(5));
        System.out.println(factorial.getFactorialWithForLoop(5));
    }
}
