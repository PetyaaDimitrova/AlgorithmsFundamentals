package com.company.Tasks;

public class Main {

    public static void main(String[] args) {

        System.out.println(Kata.nextHigher(127));
        System.out.println(Dinglemouse.peakHeight(new char[][]{
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^ ".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        }));
        MathEvaluator mathEvaluator = new MathEvaluator();
        System.out.println(mathEvaluator.calculate("6+(-2)"));


    }
}
