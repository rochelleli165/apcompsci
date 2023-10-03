import java.util.Scanner;

public class calculate2 {
    public static void main(String[]args){
        Scanner pen = new Scanner(System.in);
        double x1;
        System.out.print("Enter first x coords.");
        x1 = pen.nextDouble();
        pen.nextLine();
        double y1;
        System.out.print("Enter frist y coords.");
        y1 = pen.nextDouble();
        pen.nextLine();
        double x2;
        System.out.print("Enter second x coords.");
        x2 = pen.nextDouble();
        pen.nextLine();
        double y2;
        System.out.print("Enter second y coords.");
        y2 = pen.nextDouble();
        pen.nextLine();

        //slope
        double m = (y2-y1)/(x2-x1);
        double b = (y1-(m*x1));

        System.out.print("y=" + m + "x+" + b);
    }
}
