package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class VeryBigSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long[] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToLong(Long::parseLong).toArray();

        System.out.println(aVeryBigSum(numbers));


    }

    private static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long l:ar) {
            sum+=l;
        }
        return sum;
    }
}
