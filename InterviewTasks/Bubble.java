package InterviewTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();


        for(int i = 0; i < numbers.length; i++){
            for (int j = i+1; j <  numbers.length; j++) {
                if(numbers[j]<numbers[i]){
                    swap(numbers, i, j);
                }
            }
        }
        for (int n:numbers
             ) {
            System.out.print(n + " ");
        }
    }
    private static void swap(int[] numbers, int minNumberIndex, int i) {
        int temp = numbers[minNumberIndex];
        numbers[minNumberIndex] = numbers[i];
        numbers[i] = temp;
    }
}
