import java.util.Scanner;

public class calculator4 {

    public static void main(String[] args) {
        boolean progress = true;

        while (progress) {
            Scanner pen = new Scanner(System.in);

            System.out.println("First numerator");
            int num;
            num = pen.nextInt();
            pen.nextLine();

            System.out.println("First denominator");
            int den;
            den = pen.nextInt();
            pen.nextLine();


            int [] frac = {num , den};

            System.out.println("Second numerator");
            int num1;
            num1 = pen.nextInt();
            pen.nextLine();

            System.out.println("Second denominator");
            int den1;
            den1 = pen.nextInt();
            pen.nextLine();

            int [] frac1 = {num1, den1};

            System.out.println("1. Add 2. Subtract 3. Multiply 4. Divide 5. Simplify");
            int operation;
            operation = pen.nextInt();
            pen.nextLine();

            if (operation == 1) {
                add(frac , frac1);

            } else if (operation == 2) {
                sub(frac, frac1);

            } else if (operation == 3) {
                mult(frac, frac1);

            } else if (operation == 4) {
                div(frac, frac1);
            } else if (operation == 5) {
                simp(frac, frac1);
            }

            System.out.println("Again? 1. Yes 2. No");
            int apple;
            apple = pen.nextInt();
            pen.nextLine();

            if (apple == 1) {
                progress = true;
            }

            else {
                progress = false;
            }

        }

    }

    public static void add(int a [], int b []) {
        int common = (a[1] * b[1]);
        int one = (a[0] * b[1]);
        int two = (b[0] * a[1]);
        String answer = ((one+two) + "/" + common);
        System.out.println(answer);
    }

    public static void sub(int a [], int b []) {
        int common = (a[1] * b[1]);
        int one = (a[0] * b[1]);
        int two = (b[0] * a[1]);
        String answer = ((one-two) + "/" + common);
        System.out.println(answer);
    }

    public static void mult(int a [], int b []) {
        int newnum = a[0] * b[0];
        int newden = a[1] * b[1];
        String answer = (newnum + "/" + newden);
        System.out.println(answer);
    }

    public static void div(int a [], int b []) {
        int newnum = a[0] * b[1];
        int newden = a[1] * b[0];
        String answer = (newnum + "/" + newden);
        System.out.println(answer);
    }

    public static void simp (int a[], int b[]) {
        Scanner pen = new Scanner(System.in);

        System.out.println("Which fraction? 1 = first fraction 2 = second fraction");
        int choose;
        choose = pen.nextInt();
        pen.nextLine();

        if (choose == 1) {
            for (int i = 2; i < a[1]; i++) {
                while (a[0] % i == 0 && a[1] % i == 0) {
                    a[0] /= i;
                    a[1] /= i;
                }
            }
            System.out.println(a[0] + "/" + a[1]);
        }

        else {
            for (int i = 2; i < b[1]; i++) {
                while (b[0] % i == 0 && b[1] % i == 0) {
                    b[0] = b[0] / i;
                    b[1] = b[1] / i;
                }
            }

            System.out.println(b[0] + "/" + b[1]);
        }
    }


}
