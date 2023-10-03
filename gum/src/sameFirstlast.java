import java.util.Scanner;

public class sameFirstlast {
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


        if (array[0] == array[array.length-1]) {
            System.out.println(true);
        }

        else {
            System.out.println(false);
        }
    }
}
