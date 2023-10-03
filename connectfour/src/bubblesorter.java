import java.util.Scanner;

public class bubblesorter {
    public static void main(String[] args) {
        Scanner pen = new Scanner(System.in);
        //int[] array = new int[15];
        /* for(int i = 0; i < 15; i++) {
            System.out.println("Number");
            int num;
            num = pen.nextInt();
            pen.nextLine();
            array[i] = num;
        } */

        int array[] = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 16};
        boolean notorder = true;
        int counter = 0;
        while(notorder && counter < 14) {
            for (int i = 0; i < 14; i++) {
                if (array[i + 1] < array[i]) {
                    int a = array[i];
                    int b = array[i + 1];
                    array[i + 1] = a;
                    array[i] = b;
                }
                int x = 0;
                int answer = 0;
                while (x < 14) {
                    answer = answer + counting(array, x);
                    if(answer == 14){
                        notorder = false;
                    }
                    x++;
                }

            }

            counter++;
        }

        for(int i = 0; i < 15; i++){
            System.out.print(array[i] + " ");
        }

    }
    public static int counting(int[] array, int i){
        if(array[i] < array[i+1]){
            int count = 1;
            return count;
        }
        else{
            int count = 0;
            return count;
        }
    }

}
