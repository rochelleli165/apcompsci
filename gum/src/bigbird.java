import java.util.Scanner;

public class bigbird {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);
        System.out.println("Number of rows for number one");
        int num ;
        num = pen.nextInt();
        pen.nextLine();

        one(num);

        System.out.println("Number of columns");
        int num2 ;
        num2 = pen.nextInt();
        pen.nextLine();

        two(num2);

        System.out.println("Number of rows");
        int num3 ;
        num3 = pen.nextInt();
        pen.nextLine();

        three(num3);


    }

    public static void one (int a) {
        for (int i = 0; i < a; i++) {
            for (int j = i; j < a; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    public static void two (int a) {
        for(int i = 0; i < a; i++) {
            System.out.print("x");
        }
        int x = 1;
        System.out.println();
        for (int j = 0; j < (a-2); j++) {
            for (int i = 0; i < (a-1) - x; i++) {
                System.out.print(" ");
            }
            System.out.print("x");
            System.out.println();
            x++;
        }

        for(int i = 0; i < a; i++) {
            System.out.print("x");
        }
    }

    public static void three (int a) {
        int t = 0;
        for (int i = 0; i < (a+1); i++) {
            for (int x = 0; x < a-t; x++) {
                System.out.print(" ");
            }
            t++;
            for (int j = 1; j <= (2*i - 1); j++) {
                System.out.print("x");

            }
            System.out.println();
        }

    }

}
