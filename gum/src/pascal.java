import java.util.Scanner;

public class pascal {
    public static void main(String[] args) {
        Scanner pen = new Scanner(System.in);
        System.out.println("Number of int");
        int num;
        num = pen.nextInt();
        pen.nextLine();

        int prearray[] = new int[num];
        int array[] = new int[num];
        prearray[0] = 1;
        array[0] = 1;

        System.out.println(1);

        for (int i = 2; i <= num; i++) { // starting from second row
            array[0] = 1;
            array[i-1] = 1;
            for (int j = 0; j < i-1; j++) {
                    array[j+1] = prearray[j] + prearray[j + 1];
                    System.out.print(array[j] + " ");
            }
            System.out.print(1);
            System.out.println("");

            for (int k = 0; k < num; k++) {
                prearray[k] = array[k];
            }


        }



    }
}
