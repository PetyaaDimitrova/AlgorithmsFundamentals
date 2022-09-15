package com.company.Tasks;

public class Dinglemouse {
    public static int peakHeight(char[][] mountain) {

        int height = 0;

        while (matrixHasChars(mountain)) {
            height++;
            for (int column = 0; column < 14; column++) {
                for (int row = 0; row < 7; row++) {
                    char charToCheck = mountain[row][column];
                    if (charToCheck == '^') {
                        if (checkIfCharIsNotCovered(row, column, mountain, height)) {
                            mountain[row][column] = String.valueOf(height).charAt(0);
                        }
                    }
                }
            }


        }
        return height;
    }

    private static boolean matrixHasChars(char[][] mountain) {
        for (int row = 0; row < 7; row++) {
            for (int cols = 0; cols < 14; cols++) {
                char field = mountain[row][cols];
                if (field == '^') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkIfCharIsNotCovered(int row, int column, char[][] mountain, int height) {
        char charToCheck = mountain[row][column];
        if (charToCheck == ' ') {
            return false;
        }
        if (column == 0 || column == 13 || row == 0 || row == 6) {
            return true;
        }

        char charOnTheLeft = mountain[row - 1][column];
        char charOnTheRight = mountain[row + 1][column];
        char charUp = mountain[row][column - 1];
        char charDown = mountain[row][column + 1];

        if (checkTheChar(charOnTheLeft, height) && checkTheChar(charOnTheRight, height)
                && checkTheChar(charUp, height) && checkTheChar(charDown, height)) {
            return false;
        }
        return true;
    }

    private static boolean checkTheChar(char charToCheck, int height) {
        if (charToCheck == ' ') {
            return false;
        }
        if (charToCheck == '^' || Integer.parseInt(String.valueOf(charToCheck)) == height) {
            return true;
        }
        return false;
    }
}
