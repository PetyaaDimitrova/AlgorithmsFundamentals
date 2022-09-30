package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList<>();

        int sizeOfList = Integer.parseInt(scan.nextLine());

        while (sizeOfList > 0){
            List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                            .map(Integer::parseInt).collect(Collectors.toList());
            list.add(numbers);
            sizeOfList--;
        }
        System.out.println(diagonalDifference(list));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            firstDiagonal.add(arr.get(i).get(i));
        }
        for (int i = 0; i < arr.size(); i++) {
            secondDiagonal.add(arr.get(i).get(arr.size()-1-i));
        }

        return Math.abs(findSumOfDiagonals(firstDiagonal)- findSumOfDiagonals(secondDiagonal));
    }

    private static int findSumOfDiagonals(List<Integer> diagonal) {
        int sum = 0;
        for (int n:diagonal) {
            sum+=n;
        }
        return sum;
    }
}
