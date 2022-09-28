package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class GeneratingVectors {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Integer[] memory = new Integer[n];

        fillVector(memory, 0);
    }

    private static void fillVector(Integer[] memory, int index) {
        if (index >= memory.length) {
            print(memory);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            fillVector(memory, index + 1);
        }
    }

    private static void print(Integer[] memory) {
        for (Integer n : memory) {
            System.out.print(n);
        }
        System.out.println();
    }
}
