import java.util.Scanner;

public class main {
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


            frac one = new frac(num, den);

            System.out.println("Second numerator");
            int num1;
            num1 = pen.nextInt();
            pen.nextLine();

            System.out.println("Second denominator");
            int den1;
            den1 = pen.nextInt();
            pen.nextLine();

            frac two = new frac(num, den);

            System.out.println("1. Add 2. Subtract 3. Multiply 4. Divide 5. Simplify");
            int operation;
            operation = pen.nextInt();
            pen.nextLine();

            if (operation == 1) {
                add(one , two);

            } else if (operation == 2) {
                sub(one, two);

            } else if (operation == 3) {
                mult(one, two);

            } else if (operation == 4) {
                div(one, two);

            } else if (operation == 5) {
                simp(one, two);
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

    public static void add(frac a, frac b) {
        int common = (a.getDen() * b.getDen());
        int one = (a.getNum() * b.getDen());
        int two = (b.getNum() * a.getNum());
        String answer = ((one+two) + "/" + common);
        System.out.println(answer);
    }

    public static void sub(frac a, frac b) {
        int common = (a.getDen() * b.getDen());
        int one = (a.getNum() * b.getDen());
        int two = (b.getNum() * a.getNum());
        String answer = ((one-two) + "/" + common);
        System.out.println(answer);
    }

    public static void mult(frac a, frac b) {
        int newnum = a.getNum() * b.getNum();
        int newden = a.getDen() * b.getDen();
        String answer = (newnum + "/" + newden);
        System.out.println(answer);
    }

    public static void div(frac a, frac b) {
        int newnum = a.getNum() * b.getDen();
        int newden = a.getDen() * b.getNum();
        String answer = (newnum + "/" + newden);
        System.out.println(answer);
    }

    public static void simp (frac a, frac b) {
        Scanner pen = new Scanner(System.in);

        System.out.println("Which fraction? 1 = first fraction 2 = second fraction");
        int choose;
        choose = pen.nextInt();
        pen.nextLine();

        if (choose == 1) {
            for (int i = 2; i < a.getDen(); i++) {
                while (a.getNum() % i == 0 && a.getDen() % i == 0) {
                    int x = a.getNum();
                    a.setNum(x /= i);
                    a.setDen(x /= i);
                }
            }
            System.out.println(a.getNum() + "/" + a.getDen());
        }

        else {
            for (int i = 2; i < b.getDen(); i++) {
                while (b.getNum() % i == 0 && b.getDen() % i == 0) {
                    int x = b.getNum();
                    b.setNum(x /= i);
                    b.setDen(x /= i);
                }
            }

            System.out.println(b.getNum() + "/" + b.getDen());
        }
    }

}
