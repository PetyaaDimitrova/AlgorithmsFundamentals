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

            if (isNumber(expression, i)) {
                StringBuilder sb = new StringBuilder();
                if (isNegativeNumber) {
                    sb.append('-');
                    isNegativeNumber = false;
                }
                while (i < expression.length() && isNumber(expression, i)) {
                    sb.append(expression.charAt(i++));
                    if (i < expression.length() && expression.charAt(i) == '.') {
                        sb.append('.');
                        i++;
                    }
                }
                i--;
                queue.offer(sb.toString());

            } else if (ch.equals("(")) {
                String expressionToDelete = expression.substring(i, getTheEndIndexOfExpressionBetweenTheBrackets(expression, i--));
                expression = expression.replace(expressionToDelete, "");
                String expressionSubstring = expressionToDelete.substring(1, expressionToDelete.length() - 1);///-1

                double sum;
                if (isNegativeNumber) {
                    isNegativeNumber = false;
                    sum = -1 * calculate(expressionSubstring);
                } else {
                    sum = calculate(expressionSubstring);
                }
                queue.offer(String.valueOf(sum));

            } else if (ch.equals("+") || ch.equals("-")) {
                i = checkForSpecialCases(ch, queue, i, expression);
            } else {
                queue.offer(String.valueOf(expression.charAt(i)));
            }
        }
        return doTheOperations(queue);
    }

    private int getTheEndIndexOfExpressionBetweenTheBrackets(String expression, int i) {
        int constFirstPart = 0;
        int constSecondPart = 0;
        for (int j = i; j < expression.length(); j++) {
            if (expression.charAt(j) == '(') {
                constFirstPart++;
            }
            if (expression.charAt(j) == ')') {
                constSecondPart++;
                if (constFirstPart == constSecondPart) {
                    return j + 1;
                }
            }
        }
        return 0;
    }

    private boolean isNumber(String expression, int index) {
        if (expression.charAt(index) >= '0' &&
                expression.charAt(index) <= '9') {
            return true;
        }
        return false;
    }

    private int checkForSpecialCases(String ch, ArrayDeque<String> queue, int i, String expression) {
        int nextIndex = i + 1;
        char nextSymbol = expression.charAt(nextIndex);
        if(!isNumber(String.valueOf(nextSymbol), 0) && nextSymbol!='('){
            if(ch.charAt(0) == nextSymbol ){
                queue.offer("+");
            } else {
                queue.offer("-");
            }
            i++;
        } else {
            queue.offer(ch);
        }
        return i;
    }
    private static double doTheOperations(ArrayDeque<String> queue) {
        double firstNumber = Double.parseDouble(queue.poll());
        double totalSum = firstNumber;

        ArrayDeque<String> toDoAfter = new ArrayDeque<>();

        double nextNumber;
        while (!queue.isEmpty()) {
            char operator = queue.poll().charAt(0);
            nextNumber = Double.parseDouble(queue.poll());
            switch (operator) {
                case '+':
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
                        totalSum = findTotalSum(firstNumber, nextNumber, operator);
                        firstNumber = totalSum;
                        if (!toDoAfter.isEmpty()) {
                            toDoAfter.pop();
                        }
                        toDoAfter.push(String.valueOf(totalSum));
                    }
                    break;
                case '*':
                case '/':
                    if (!toDoAfter.isEmpty()) {
                        firstNumber = Double.parseDouble(toDoAfter.pop());
                        totalSum = findTotalSum(firstNumber, nextNumber, operator);
                        toDoAfter.push(String.valueOf(totalSum));
                        firstNumber = totalSum;
                    } else {
                        totalSum = findTotalSum(firstNumber, nextNumber, operator);
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

    private static double findTotalSum(double firstNumber, double nextNumber, char operator) {
        if (operator == '/') {
            return firstNumber / nextNumber;
        } else if (operator == '*') {
            return firstNumber * nextNumber;
        } else if (operator == '-') {
            return firstNumber - nextNumber;
        }
        return firstNumber + nextNumber;
    }

    private static boolean checkForDivisionOrMultiplication(ArrayDeque<String> queue) {
        if (queue.contains("*") || queue.contains("/")) {
            return true;
        }
        return false;
    }
}
