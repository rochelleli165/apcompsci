import java.util.*;
public class spearmint
{
    public static void main(String[] args)
    {
        int choice = 1;
        int operation;
        int num1;
        int num2;
        int choose;
        Scanner pen = new Scanner(System.in);
        while (choice == 1) {
            System.out.println("Which operation do you want to perform. Pick a number.");
            System.out.println("1. addition");
            System.out.println("2. subtraction");
            System.out.println("3. division with remainder");
            System.out.println("4. multiplication");
            operation = pen.nextInt();
            pen.nextLine();

            System.out.println("Please input 2 numbers.");
            System.out.println("First number:");
            num1 = pen.nextInt();
            pen.nextLine();
            System.out.println("Second number:");
            num2 = pen.nextInt();
            pen.nextLine();

            int answer;
            int remainder;
            if (operation == 1) {
                answer = num1 + num2;
                System.out.println("The answer is: " + answer);
            }
            else if (operation == 2) {
                answer = num1 - num2;
                System.out.println("The answer is: " + answer);
            }
            else if (operation == 3) {
                answer = num1 / num2;
                remainder = num1 % num2;
                System.out.println("The answer is: " + answer + " remainder: " + remainder);
            }
            else {
                answer = num1 * num2;
                System.out.println("The answer is: " + answer);
            }
            System.out.println("Do you want to do another calculation?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choose = pen.nextInt();
            pen.nextLine();
            if (choose == 1) {
                choice = 1;
            }
            else {
                choice++;
            }
        }
    }
}
