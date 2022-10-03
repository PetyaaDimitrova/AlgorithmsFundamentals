package InterviewTasks;

public class Factorial {

    public long findFactorialWithRecursion(int number) {
        if (number == 1) {
            return number;
        }
        return (long) number * findFactorialWithRecursion(number - 1);
    }


    public long getFactorialWithForLoop(int number) {
        long result = number;
        for (int i = number - 1; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }

}
