package NewTasks;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String regex = "(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";

        Pattern pattern = Pattern.compile(regex);

        String date = scan.nextLine();

        Matcher matcher = pattern.matcher(date);


        System.out.println(matcher.matches());

    }
}