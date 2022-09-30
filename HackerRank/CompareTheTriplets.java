package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompareTheTriplets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> results = compareTriplets(firstPlayer, secondPlayer);

        for (int n: results) {
            System.out.print(n + " ");
        }

    }

    private static List<Integer> compareTriplets(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);

        for (int i = 0; i < firstPlayer.size(); i++) {
            if(firstPlayer.get(i) > secondPlayer.get(i)){
                results.set(0, results.get(0) + 1);
            } else if(firstPlayer.get(i) < secondPlayer.get(i)){
                results.set(1, results.get(1) + 1);
            }
        }
        return results;
    }

}
