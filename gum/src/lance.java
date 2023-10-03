import java.util.Scanner;
public class lance {
    public static void main(String[] args) {

        Scanner pen = new Scanner(System.in);
        int num ;
        num = pen.nextInt();
        pen.nextLine();

          boolean tres = false;
          while( num > 99) {
              int a = num % 10;
              int b = (num/10)%10;
              int c = (num/100)%10;

              if (a == b && b == c) {
                  tres = true;
              }
              num = num/10;
          }
          if (tres == true) {
              System.out.println("Yes)");
          }




    }
}
