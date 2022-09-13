package com.company.EpamTasks;

public class FlyingBird {
    public static void main(String[] args) {

        char[][] mountain = {
                "^^^^^^        ".toCharArray(),
                " ^^^^^^^^     ".toCharArray(),
                "  ^^^^^^^     ".toCharArray(),
                "  ^^^^^       ".toCharArray(),
                "  ^^^^^^^^^^^ ".toCharArray(),
                "  ^^^^^^      ".toCharArray(),
                "  ^^^^        ".toCharArray()
        };
        int height = 1;
        while (matrixHasChars(mountain)) {

            for (int column = 0; column < 14; column++) {
                for (int row = 0; row < 7; row++) {
                    char charToCheck = mountain[row][column];
                    if (checkIfCharIsNotCovered(row, column, mountain, height)) {
                        if (charToCheck == '^') {
                            mountain[row][column] =  String.valueOf(height).charAt(0);
                        }
                    }

                }
            }
            height++;
            for (int row = 0; row < 7; row++) {
                for (int cols = 0; cols < 14; cols++) {
                    System.out.print(mountain[row][cols]);
                }
                System.out.println();
            }
        }


        if('1' == (char) height){
            System.out.println("yes");
        }


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

        char charOnTheLeft = mountain[row + 1][column];
        char charOnTheRight = mountain[row - 1][column];
        char charUp = mountain[row][column - 1];
        char charDown = mountain[row][column + 1];

        boolean firstCondition = checkTheChar(charOnTheLeft, height);
        boolean secondCondition = checkTheChar(charOnTheRight, height);
        boolean thirdCondition = checkTheChar(charUp, height);
        boolean fourthCondition = checkTheChar(charDown, height);

        if (fourthCondition && secondCondition && firstCondition && thirdCondition) {
            return false;
        }

        return true;

    }

    private static boolean checkTheChar(char charToCheck, int height) {
        if(charToCheck == ' '){
            return false;
        }

        if (charToCheck == '^' || Integer.parseInt(String.valueOf(charToCheck)) == height) {
            return true;
        }
        return false;
    }

}
