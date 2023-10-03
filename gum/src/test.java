import java.util.Scanner;

public class test {
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
        int sort[] = new int[num];

        for (int j = 0; j < num; j++) {
            int t = 0;
            for (int i = 0; i < num; i++) {
                if (array[j] > array[i]) {
                    t++;
                }
            }
            sort[t] = array[j];
        }

        for (int p=0; p < num; p++) {
            System.out.println(sort[p]);
        }


    }
}
