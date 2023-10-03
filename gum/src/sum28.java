import java.util.Scanner;

public class sum28 {
    public static void main(String[] args) {
        Scanner pen = new Scanner(System.in);
        System.out.println("Number of int");
        int num;
        num = pen.nextInt();
        pen.nextLine();

        int array[] = new int[num];

        for (int i = 0; i < num; i++) {
            int a = pen.nextInt();
            pen.nextLine();
            array[i] = a;
        }

        int t = 0;

        for (int i = 0; i < num; i++) {
            if (array[i] == 2) {
                t++;
            }
        }

        if (t == 4) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }

    }
}
