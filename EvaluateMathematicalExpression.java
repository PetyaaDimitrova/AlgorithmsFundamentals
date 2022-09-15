package com.company.EpamTasks;

import java.util.*;
import java.util.stream.Collectors;

public class EvaluateMathematicalExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = "2 /2+3 * 4.75- -6";

        System.out.println(findSum(expression));

    }

    private static double findSum(String expression) {
        expression = expression.replaceAll(" ", "");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            String ch = String.valueOf(expression.charAt(i));

            if (expression.charAt(i) >= '0' &&
                    expression.charAt(i) <= '9') {

                StringBuilder sb = new StringBuilder();

                while (i < expression.length() &&
                        expression.charAt(i) >= '0' &&
                        expression.charAt(i) <= '9') {
                    sb.append(expression.charAt(i++));
                    if (i < expression.length() && expression.charAt(i) == '.') {
                        sb.append('.');
                        i++;
                    }
                }
                i--;
                queue.offer(sb.toString());

            } else if (ch.equals("(")) {
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
        return doTheOperations(queue);
    }

    private static double doTheOperations(ArrayDeque<String> queue) {

        double firstNumber = Double.parseDouble(queue.poll());
        double totalSum = firstNumber;

        ArrayDeque<String> toDoAfter = new ArrayDeque<>();

        int count = 0;
        double nextNumber = 0;
        while (!queue.isEmpty()) {
            char operator = queue.poll().charAt(0);

            if (queue.peek().equals("-")) {
                queue.poll();
                if (operator == '+') {
                    operator = '-';
                } else if (operator == '-') {
                    operator = '+';

                } else {
                    nextNumber = -1 * Double.parseDouble(queue.poll());
                }

            }
            nextNumber = Double.parseDouble(queue.poll());
            switch (operator) {
                case '+':
                    if (checkForDivisionOrMultiplication(queue)) {
                        if (toDoAfter.isEmpty()) {
                            toDoAfter.offer(String.valueOf(firstNumber));
                            toDoAfter.offer(String.valueOf(operator));
                        }

                        toDoAfter.offer(String.valueOf(nextNumber));
                        firstNumber = Double.parseDouble(toDoAfter.peek());
                    } else {

                        totalSum = firstNumber + nextNumber;
                        firstNumber = totalSum;
                        if (!toDoAfter.isEmpty()) {
                            toDoAfter.pollLast();
                            toDoAfter.offer(String.valueOf(totalSum));
                        }
                    }
                    break;
                case '-':
                    if (checkForDivisionOrMultiplication(queue)) {
                        if (toDoAfter.isEmpty()) {
                            toDoAfter.offer(String.valueOf(firstNumber));
                            toDoAfter.offer(String.valueOf(operator));
                        }
                        toDoAfter.offer(String.valueOf(nextNumber));
                        firstNumber = Double.parseDouble(toDoAfter.peek());
                    } else {
                        totalSum = firstNumber - nextNumber;
                        firstNumber = totalSum;
                        if (!toDoAfter.isEmpty()) {
                            toDoAfter.pollLast();
                            toDoAfter.offer(String.valueOf(totalSum));
                        }
                    }
                    break;
                case '*':
                    if (!toDoAfter.isEmpty()) {
                        firstNumber = Double.parseDouble(toDoAfter.pollLast());
                        totalSum = firstNumber * nextNumber;
                        toDoAfter.offer(String.valueOf(totalSum));
                        firstNumber = totalSum;
                    } else {
                        totalSum = firstNumber * nextNumber;
                        firstNumber = totalSum;
                        toDoAfter.offer(String.valueOf(totalSum));
                        if (!queue.isEmpty()) {
                            toDoAfter.offer(queue.peek());
                        }
                    }
                    count++;
                    break;
                case '/':
                    if (!toDoAfter.isEmpty()) {
                        firstNumber = Double.parseDouble(toDoAfter.pollLast());
                        totalSum = firstNumber / nextNumber;
                        toDoAfter.offer(String.valueOf(totalSum));
                        firstNumber = totalSum;
                    } else {
                        totalSum = firstNumber / nextNumber;
                        firstNumber = totalSum;
                        toDoAfter.offer(String.valueOf(totalSum));
                        if (!queue.isEmpty()) {
                            toDoAfter.offer(queue.peek());
                        }
                    }
                    count++;
                    break;
            }

        }
        if (toDoAfter.isEmpty()) {
            return totalSum;
        }
        return doTheOperations(toDoAfter);
    }

    private static boolean checkForDivisionOrMultiplication(ArrayDeque<String> queue) {
        if (queue.contains("*") || queue.contains("/")) {
            return true;
        }
        return false;
    }


}
