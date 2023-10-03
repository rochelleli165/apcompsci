import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        boolean progress = true;

        while (progress) {
            Scanner pen = new Scanner(System.in);
            int a;
            a = pen.nextInt();
            pen.nextLine();

            int b;
            b = pen.nextInt();
            pen.nextLine();

            System.out.println("1. Add 2. Subtract 3. Multiply 4. Divide");
            int operation;
            operation = pen.nextInt();
            pen.nextLine();

            if (operation == 1) {
                System.out.println(add(a, b));

            } else if (operation == 2) {
                System.out.println(sub(a, b));

            } else if (operation == 3) {
                System.out.println(mult(a, b));

            } else if (operation == 4) {
                div(a, b);
            }

            System.out.println("Again? 1. Yes 2. No");
            int choose;
            choose = pen.nextInt();
            pen.nextLine();

            if (choose == 2) {
                progress = false;
            }



        }

    }

    public static int add(int a, int b) {
        int answer = a+b;
        return answer;
    }

    public static int sub(int a, int b) {
        int answer = a-b;
        return answer;
    }

    public static int mult(int a, int b) {
        int answer = a*b;
        return answer;
    }

    public static void div(int a, int b) {
        int answer = a/b;
        int remainder = a%b;
        System.out.println(answer + "remainder " + remainder);
    }


}
