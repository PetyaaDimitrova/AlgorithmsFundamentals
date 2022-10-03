package InterviewTasks;

import java.util.Scanner;

public class Operators {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());

        
        //!x || !y || y       =>  !(x && y) is the same like !x || !y , but we have also (!x  || y) and (!y || y).
        // We already have !x and !y and we need to add 'y' without '!' in our expression.
    }
}
