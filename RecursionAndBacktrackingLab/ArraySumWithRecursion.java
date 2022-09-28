package RecursionAndBacktrackingLab;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySumWithRecursion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(numbers, 0));

    }

    private static int sum(int[] arr, int index) {
        if(index >= arr.length){
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }
}
