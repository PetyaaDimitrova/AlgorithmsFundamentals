package SearchingSortingAndGreedyAlgorithms.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numbers.length ; index++) {
            for (int current = index; current < numbers.length ; current++) {
                if(numbers[current] < numbers[index]){
                    swap(numbers, current, index);
                }
            }
        }
        for (int n: numbers
        ) {
            System.out.print(n + " ");
        }
    }

    private static void swap(int[] numbers, int min, int index) {
        int temp = numbers[min];
        numbers[min] = numbers[index];
        numbers[index] = temp;
    }
}
