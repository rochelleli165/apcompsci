import java.util.Scanner;

public class septembertwo {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);
        int num;
        int real;
        num = pen.nextInt();
        pen.nextLine();
        real = num;
        int i;
        for (int j = 0; j < real; j++){
            System.out.println();
            for (i = 0; i < num; i++) {
                System.out.print("*");
            }
            num--;
        }

        /* i += 9 // i = i + 9
           i /= 9 // i = i / 9

           String c = "Kelly";
           String d = "Brandon";

           if ( c.equals(d)) {
           System.out.println("They are the same")
           }

         */





    }
}
