import java.util.Scanner;

public class isPrime {
    public static void main(String[] args) {

        int i;
        boolean progress = true;
        while(progress == true) {

            Scanner pen = new Scanner(System.in);
            int num;
            num = pen.nextInt();
            pen.nextLine();

            int choose;

            boolean isPrime;
            boolean stop = true;


            for (i=2; i<num; i++) {
                while (stop == true) {
                    int answer = num % i;
                    if (answer == 0) {
                        isPrime = false;

                        if (isPrime == false) {
                            stop = false;
                            System.out.println("This is not a prime number");
                        } else {
                            System.out.println("This is a prime number.");
                            stop = false;
                        }
                    }
                }
            }




            System.out.println("Use another number?");
            System.out.println("1. Yes   2. No");

            choose = pen.nextInt();
            pen.nextLine();

            if (choose == 2) {
                progress = false;
            }

            if (choose == 1) {
                progress = true;
            }


        }
    }
}
