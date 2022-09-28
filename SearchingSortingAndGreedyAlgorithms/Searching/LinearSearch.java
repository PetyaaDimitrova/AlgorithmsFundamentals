package SearchingSortingAndGreedyAlgorithms.Searching;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int key = Integer.parseInt(scan.nextLine());

        System.out.println(findTheIndexOfKey(numbers, key));
    }

    private static int findTheIndexOfKey(int[] numbers, int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
