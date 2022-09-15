package com.company.Tasks;

import java.util.ArrayDeque;

public class MathEvaluator {

    public double calculate(String expression) {

        expression = expression.replaceAll(" ", "");
        boolean isNegativeNumber = false;
        if (expression.charAt(0) == '-') {
            isNegativeNumber = true;
            expression = expression.replaceFirst("-", "");
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            String ch = String.valueOf(expression.charAt(i));

            if (expression.charAt(i) >= '0' &&
                    expression.charAt(i) <= '9') {

                StringBuilder sb = new StringBuilder();
                if (isNegativeNumber) {
                    sb.append('-');
                }
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
                double sum = calculate(expressionSubstring);

                queue.offer(String.valueOf(sum));
            } else if (ch.equals("-")) {
int nextIndex = i + 1;
                char nextSymbol = expression.charAt(nextIndex);
                if (nextSymbol == '-') {

                    queue.offer("+");
                    i++;
                } else if (nextSymbol == '+') {
                    queue.offer("-");
                    i++;
                } else {
                    queue.offer(ch);
                }

            } else {
                queue.offer(String.valueOf(expression.charAt(i)));
            }
        }
        if (isNegativeNumber && queue.size() == 1) {
            return -1 * Double.parseDouble(queue.pop());
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


            nextNumber = Double.parseDouble(queue.poll());
            switch (operator) {
                case '+':
                    if (checkForDivisionOrMultiplication(queue)) {
                        if (toDoAfter.isEmpty()) {
                            toDoAfter.push(String.valueOf(firstNumber));
                        }
                        toDoAfter.push(String.valueOf(operator));
                        toDoAfter.push(String.valueOf(nextNumber));

                        if (queue.peek().equals("*") || queue.peek().equals("/")) {
                            firstNumber = Double.parseDouble(toDoAfter.peek());
                        } else {
                            toDoAfter.push(String.valueOf(nextNumber));
                        }

                    } else {
                        totalSum = firstNumber + nextNumber;
                        firstNumber = totalSum;
                        if (!toDoAfter.isEmpty()) {
                            toDoAfter.pop();
                        }
                        toDoAfter.push(String.valueOf(totalSum));

                    }
                    break;
                case '-':
                    if (checkForDivisionOrMultiplication(queue)) {
                        if (toDoAfter.isEmpty()) {
                            toDoAfter.push(String.valueOf(firstNumber));
                        }
                        toDoAfter.push(String.valueOf(operator));
                        toDoAfter.push(String.valueOf(nextNumber));
                        if (queue.peek().equals("*") || queue.peek().equals("/")) {
                            firstNumber = Double.parseDouble(toDoAfter.peek());
                        } else {
                            toDoAfter.push(String.valueOf(nextNumber));
                        }

                    } else {
                        totalSum = firstNumber - nextNumber;
                        firstNumber = totalSum;
                        if (!toDoAfter.isEmpty()) {
                            toDoAfter.pop();
                        }
                        toDoAfter.push(String.valueOf(totalSum));
                    }
                    break;
                case '*':
                    if (!toDoAfter.isEmpty()) {
                        firstNumber = Double.parseDouble(toDoAfter.pop());
                        totalSum = firstNumber * nextNumber;
                        toDoAfter.push(String.valueOf(totalSum));
                        firstNumber = totalSum;
                    } else {
                        totalSum = firstNumber * nextNumber;
                        firstNumber = totalSum;
                        toDoAfter.push(String.valueOf(totalSum));
                    }
                    break;
                case '/':
                    if (!toDoAfter.isEmpty()) {
                        firstNumber = Double.parseDouble(toDoAfter.pop());
                        totalSum = firstNumber / nextNumber;
                        toDoAfter.push(String.valueOf(totalSum));
                        firstNumber = totalSum;
                    } else {
                        totalSum = firstNumber / nextNumber;
                        firstNumber = totalSum;
                        toDoAfter.push(String.valueOf(totalSum));
                    }
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
