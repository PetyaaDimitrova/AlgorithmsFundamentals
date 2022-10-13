package InterviewTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Students {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();


        int[][] matrix = fillTheMatrix(numbers);


        int pairs = findDifferentCombinations(matrix);

        System.out.println(pairs);

    }

    private static int findDifferentCombinations(int[][] matrix) {

        int pairs = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < 2; cols++) {
                int seat = matrix[rows][cols];
                if (seat != 0) {
                    if (cols == 0 && matrix[rows][cols + 1] != 0) {
                        pairs++;
                    }
                    if (rows != matrix.length - 1 && matrix[rows + 1][cols] != 0) {
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }


    public static int[][] fillTheMatrix(int[] numbers) {
        int countOfSeats = numbers[0];
        int cols = 2;
        int rolls = countOfSeats / cols;
        int[][] matrix = new int[rolls][cols];
        int start = 1;
        for (int row = 0; row < rolls; row++) {
            for (int col = 0; col < cols; col++) {
                if (isTaken(numbers, start)) {
                    matrix[row][col] = 0;
                } else {
                    matrix[row][col] = start;
                }
                start++;
            }
        }
        return matrix;
    }

    private static boolean isTaken(int[] numbers, int start) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == start) {
                return true;
            }
        }

        return false;
    }
}
