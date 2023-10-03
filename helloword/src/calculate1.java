import java.util.Scanner;

public class calculate1 {
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        int num1;
        System.out.print("Enter first numerator integer.");
        num1 = pen.nextInt();
        pen.nextLine();
        int num2;
        System.out.print("Enter second numerator integer.");
        num2 = pen.nextInt();
        pen.nextLine();
        int den1;
        System.out.print("Enter first denominator integer.");
        den1 = pen.nextInt();
        pen.nextLine();
        int den2;
        System.out.print("Enter second numerator integer.");
        den2 = pen.nextInt();
        pen.nextLine();



        System.out.print("the quotient is ");
        System.out.println((num1*den1) + "/" + (num2*den2)); //divide
        System.out.println((num1*num2) + "/" + (den1*den2)); //multiply
        System.out.print("the difference is ");


        num1 = num1*den2;
        den1 = den1*den2;
        num2 = num2*den1;

        System.out.print("the sum is ");
        System.out.println((num1+num2) + "/" + (den1)); //add
        System.out.print("the product is ");
        System.out.println((num1-den2) + "/" + (den1)); //subtract


    }
}
