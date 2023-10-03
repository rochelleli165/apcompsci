import java.util.Scanner;

public class tres {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);
        int num ;
        num = pen.nextInt();
        pen.nextLine();

        boolean progress2 = false;

        if (num<0) {
            num = num*(-1);
            progress2 = true;
        }
        int y=0;
        boolean progress = true;
        while (num>0 && progress) {

            if (num % 10 == num) {
                progress = false;
            }

            int a = num % 10;
            num = num/10;


            if (a != 6) {
                y = y*10 + a;
            }




        }

        boolean progress1;
        int x = 0;

        while (y>0) {

            if (y % 10 == y) {
                progress1 = false;
            }

            int b = y % 10;
            y = y/10;

            x = x*10 + b;
        }

        if (progress2) {
            System.out.print("-" + x);
        }

        else {
            System.out.println(x);
        }


    }
}
