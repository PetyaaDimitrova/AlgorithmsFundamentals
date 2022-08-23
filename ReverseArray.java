package com.company.HackerRank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int i = Integer.parseInt(scan.nextLine());
        int j = Integer.parseInt(scan.nextLine());

      int[] newArr =  bubleSort(numbers, i, j);

        String result = Arrays.stream(newArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    public static int[] bubleSort(int[] arr, int i, int j) {
        for (int k = i; k <= j; k++) {
            int temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
            j--;
        }
        return arr;
    }
}