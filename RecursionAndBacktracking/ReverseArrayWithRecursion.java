package RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayWithRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();


        reverse(numbers, 0, numbers.length - 1);

        for (int n: numbers) {
            System.out.print(n + " ");
        }


    }

    private static void reverse(int[] numbers, int startIndex, int endIndex) {
        if(startIndex >= numbers.length/2){
            return;
        }
        int temp = numbers[startIndex];
        numbers[startIndex] = numbers[endIndex];
        numbers[endIndex] = temp;
        reverse(numbers, startIndex+1, endIndex-1);
    }
}
