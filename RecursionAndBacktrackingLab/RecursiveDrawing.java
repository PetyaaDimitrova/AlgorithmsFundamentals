package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        draw(number);
    }

    private static void draw(int number) {
        if (number <= 0) {
            return;
        }
        print('*', number);

        draw(number - 1);

        print('#', number);
    }

    private static void print(char c, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
}
