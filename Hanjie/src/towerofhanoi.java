import java.util.Scanner;

public class towerofhanoi {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);

        System.out.println("Enter a number of discs: ");
        int disc = input.nextInt();
        input.nextLine();

        towerofhanoi(disc, "A", "B", "C");
    }
    public static void towerofhanoi(int disc, String a, String b, String c){
        if(disc == 1){
            System.out.println("Move " + disc + " from " + a + " to " + c);
        }
        else{
            towerofhanoi(disc-1, a, c, b);
            System.out.println("Move " + disc + " from " + a + " to " + c);
            towerofhanoi(disc-1, b, a, c);
        }
    }
}
