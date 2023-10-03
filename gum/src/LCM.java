import java.util.Scanner;

public class LCM {
    public static void main (String[] args) {
        Scanner pen = new Scanner(System.in);
        int num;
        num = pen.nextInt();
        pen.nextLine();

        int num1;
        num1 = pen.nextInt();
        pen.nextLine();

        int answer = num1*num;


        int big;
        if (num > num1) {
            big = num;
        }

        else {
            big = num1;
        }
        boolean progress = true;

            for (int j = 2; j < big; j++) {
                for (int i = 2; i < big; i++) {
                    if (num % i == 0 && num1 % i == 0) {
                        big = big / i;
                        num1 = num1 / i;
                        num = num / i;
                        answer = answer / i;
                    }
                }



        }

        System.out.println(answer);

    }
}
