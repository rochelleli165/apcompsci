import java.util.Scanner;

public class hundred {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);
        int num;
        num = pen.nextInt();
        pen.nextLine();



        boolean progress = true;

        if (num < 100) {
            System.out.println("");
            progress = false;

        }

        while (num > 1000) {
            num = num - 1000;
        }

        while (progress == true) {

            if (num / 100 == 0) {
                System.out.println(0);
                progress = false;
            } else if (num / 100 == 1) {
                System.out.println(1);
                progress = false;
            } else if (num / 100 == 2) {
                System.out.println(2);
                progress = false;
            } else if (num / 100 == 3) {
                System.out.println(3);
                progress = false;
            } else if (num / 100 == 4) {
                System.out.println(4);
                progress = false;
            } else if (num / 100 == 5) {
                System.out.println(5);
                progress = false;
            } else if (num / 100 == 6) {
                System.out.println(6);
                progress = false;
            } else if (num / 100 == 7) {
                System.out.println(7);
                progress = false;
            } else if (num / 100 == 8) {
                System.out.println(8);
                progress = false;
            } else if (num / 100 == 9) {
                System.out.println(9);
                progress = false;
            }
        }
    }
}


