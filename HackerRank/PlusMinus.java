package HackerRank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sizeOfArray = Integer.parseInt(scan.nextLine());
        List<Integer> arr = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        plusMinus(arr);

    }

    private static void plusMinus(List<Integer> arr) {
        double size = arr.size();
        int positiveNumbers = 0;
        int negativeNumbers = 0;
        int zeroes = 0;

        for (int n : arr) {
            if (n < 0) {
                negativeNumbers++;
            } else if (n > 0) {
                positiveNumbers++;
            } else {
                zeroes++;
            }
        }
        System.out.printf("%.6f%n" , positiveNumbers / size);
        System.out.printf("%.6f%n" , negativeNumbers / size);
        System.out.printf("%.6f%n" , zeroes / size);
    }
}
