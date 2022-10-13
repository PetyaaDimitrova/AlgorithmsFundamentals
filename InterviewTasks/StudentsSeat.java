package InterviewTasks;

import java.util.*;
import java.io.*;

public class StudentsSeat {
    public static int SeatingStudents(String input) {

        List<Integer> digits = new ArrayList<>();
        for(int i = 0; i< input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                digits.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            }
        }

        int[] numbers = new int[digits.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = digits.get(i);
        }
        // code goes here
        int[][] matrix = fillTheMatrix(numbers);

        return findDifferentCombinations(matrix);
    }

    public static int findDifferentCombinations(int[][] matrix) {

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

    public static boolean isTaken(int[] numbers, int start) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == start) {
                return true;
            }
        }

        return false;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);


        System.out.print(SeatingStudents(s.nextLine()));
    }


}
