package HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        miniMaxSum(numbers);
    }

    private static void miniMaxSum(List<Integer> arr) {
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) < minNumber){
                minNumber = arr.get(i);
            }
            if(arr.get(i) > maxNumber){
                maxNumber = arr.get(i);
            }
        }




        System.out.print(findSum(arr, maxNumber ) + " ");
        arr.add(maxNumber);
        System.out.print(findSum(arr, minNumber) );

    }

    private static long findSum(List<Integer> list, int numberToDelete) {
        long sum = 0;
        list.remove((Integer) numberToDelete);
        for (int n: list) {
           sum+=n;
        }
        return sum; 
    }
}
