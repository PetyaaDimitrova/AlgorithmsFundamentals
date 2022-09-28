package RecursionAndBacktracking.Permutations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PermutationsWithRepetitions {
    public static String[] elements;
    public static String[] permuteElements;
    public static HashSet<String> hashSet;
    public static boolean[] isUsed;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        permuteElements = new String[elements.length];
        isUsed = new boolean[elements.length];
        hashSet = new HashSet<>();


        permute(0);
        print();
    }

    private static void permute(int index) {
        if (index == elements.length) {
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permuteElements[index] = elements[i];
                permute(index + 1);
                isUsed[i] = false;
                hashSet.add(String.join(" ", permuteElements));
            }
        }
    }

    private static void print() {
        Iterator itr = hashSet.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
