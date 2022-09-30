package HackerRank;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleArraySum {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(simpleArraySum(numbers));
    }

    public static int simpleArraySum(List<Integer> numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        return(sum);


    }


}
