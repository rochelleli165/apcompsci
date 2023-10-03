import java.util.Scanner;

public class factorial {
    public static void main (String[] args){
        Scanner pen = new Scanner(System.in);
        int num;
        num = pen.nextInt();
        pen.nextLine();
        int j = num;
        for (int i=1; i < j; i++){
            num = i * num;
        }
        System.out.println(num);
    }

}
