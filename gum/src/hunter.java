import java.util.Scanner;

public class hunter {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);

        System.out.println("Summer? True or false.");
        boolean isSummer = pen.nextBoolean();
        pen.nextLine();

        System.out.println("Input temperature.");
        int temp = pen.nextInt();
        pen.nextLine();

        if (isSummer == true) {
            if (temp >= 60 && temp <= 100) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
        }

        if (isSummer == false) {
            if (temp >= 60 && temp <= 90) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
        }

    }
}
