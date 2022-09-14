package com.company.EpamTasks;

import java.util.*;
import java.util.stream.Collectors;

public class EvaluateMathematicalExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = "2/(2+3+1*5)*4-6";
        System.out.println(findSum(expression));

    }


    private static double findSum(String expression) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            String ch = String.valueOf(expression.charAt(i));
            if (ch.equals("(")) {
                int endIndex = 0;
                int constt = 0;
                for (int j = i + 1; j < expression.length(); j++) {
                    if (expression.charAt(j) == '(') {
                        constt++;
                    }
                    if (expression.charAt(j) == ')') {
                        endIndex = j + 1 + constt;
                        break;
                    }
                }
                String expressionToDelete = expression.substring(i, endIndex);
                expression = expression.replace(expressionToDelete, "");
                i--;
                String expressionSubstring = expressionToDelete.substring(1, expressionToDelete.length() - 1);///-1
                double sum = findSum(expressionSubstring);
                queue.offer(String.valueOf(sum));
            } else {
                queue.offer(String.valueOf(expression.charAt(i)));
            }
        }


        double firstNumber = Double.parseDouble(queue.poll());
        double totalSum = firstNumber;
        while (!queue.isEmpty()) {
            char operator = queue.poll().charAt(0);
            double nextNumber = Double.parseDouble(queue.poll());

            switch (operator) {
                case '+':
                    totalSum = firstNumber + nextNumber;
                    break;
                case '-':
                    totalSum = firstNumber - nextNumber;
                    break;
                case '*':
                    totalSum = firstNumber * nextNumber;
                    break;
                case '/':
                    totalSum = firstNumber / nextNumber;
                    break;

            }
            firstNumber = totalSum;
        }
        return totalSum;
    }
}
