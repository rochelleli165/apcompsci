import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner pen = new Scanner(System.in);
        int a;
        a = pen.nextInt();
        pen.nextLine();

        int b;
        b = pen.nextInt();
        pen.nextLine();

        int c;
        c = pen.nextInt();
        pen.nextLine();

        int diff1 = a-b;
        if (diff1<0) {
            diff1*=-1;
        }

        int diff2 = b-c;
        if (diff2<0) {
            diff2*=-1;
        }

        int diff3 = a-c;
        if (diff3<0) {
            diff3*=-1;
        }

        if ((diff1 == diff2) || (diff2 == diff3) || (diff1 == diff3)) {
            System.out.println("hella lit");
        }


    }
}
