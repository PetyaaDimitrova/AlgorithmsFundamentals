package RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySumWithForLoop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i];
        }

        System.out.println(sum);

    }
}
