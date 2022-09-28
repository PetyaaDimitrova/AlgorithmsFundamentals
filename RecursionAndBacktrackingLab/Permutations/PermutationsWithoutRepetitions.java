package RecursionAndBacktrackingLab.Permutations;

import java.util.Scanner;

public class PermutationsWithoutRepetitions {
    public static String[] elements;
    public static String[] permuteElements;
    public static boolean[] isUsed;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        permuteElements = new String[elements.length];
        isUsed = new boolean[elements.length];


        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permuteElements[index] = elements[i];
                permute(index + 1);
                isUsed[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", permuteElements));

    }
}
