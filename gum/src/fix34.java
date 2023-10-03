import java.util.Scanner;

public class fix34 {
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


            for (int i = 0; i < num; i++) {
                if (array[i] == 3) {
                    for (int j = 0; j < num; j++) {
                        if (array[j] == 4) {
                            array[j] = array[i + 1];
                            array[i + 1] = 4;

                        }
                    }

                }
            }


        for (int i = 0; i < num; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
