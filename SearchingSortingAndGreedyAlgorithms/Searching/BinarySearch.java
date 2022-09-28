package SearchingSortingAndGreedyAlgorithms.Searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(scan.nextLine());

        System.out.println(findTheIndex(numbers, key));
    }

    private static int findTheIndex(int[] numbers, int key) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while (startIndex <= endIndex){
            int middle = (startIndex + endIndex) / 2;
            if(key<numbers[middle]){
                endIndex = middle - 1;
            } else if(key > numbers[middle]){
                startIndex = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;

    }
}
