package NewTasks;

public class ChangeVariables {
    public static void main(String[] args) {
      int a = 1;
      int b = 1;

      while (a != 256){
          a = a * 2;
          b = b + a;
      }
      System.out.println(b);
    }
}
