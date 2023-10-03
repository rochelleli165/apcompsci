import java.util.Scanner;

public class Quotient {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);
        int num;
        num = pen.nextInt();
        pen.nextLine();

        int num1;
        num1 = pen.nextInt();
        pen.nextLine();

        int answer;
        int i = 0;
        boolean progress = true;
       while (progress) {
           num = num-num1;
           i++;
           if (num < 0) {
               num = num + num1;
               i--;
               progress = false;
           }

       }

       System.out.print(i + ".");


        int remainder;
        remainder = num;

       for (int x=0; x < 10; x++) {

           int j = 0;
           remainder = remainder * 10;

           boolean progress1 = true;

           while (progress1) {
               remainder = remainder-num1;
               j++;
               if (remainder < 0) {
                   remainder = remainder + num1;
                   j--;
                   progress1 = false;
               }

           }

           System.out.print(j);
       }

    }
}
