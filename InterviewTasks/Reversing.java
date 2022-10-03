package InterviewTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Reversing {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

        int i = Integer.parseInt(scan.nextLine());
        int j = Integer.parseInt(scan.nextLine());

        reverse(numbers, i , j);

        for (int n: numbers
             ) {
            System.out.print(n + " ");
        }

    }


        public static void reverse ( int[] arr, int i, int j){
            for (int k = i; k < j; k++) {
                arr[k] += arr[j];
                arr[j] = arr[k] - arr[j];
                arr[k] -= arr[j];
                j--;
            }
        }


}
