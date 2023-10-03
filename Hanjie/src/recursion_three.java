import java.util.*;
public class recursion_three {
    public static void main(String[] args){
        DB(3);
        printNum(4);
        System.out.println();
        binary(8);
    }
    public static void DB(int a){
        if(a == 0){

        }
        else{
            for(int i = 0; i < a; i++){
                System.out.print("*");
            }
            System.out.println();
            DB(a-1);
            for(int i = 0; i < a; i++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void printNum(int a){
        if(a == 0){

        }
        else{
            printNum(a-1);
            System.out.print(a + ",");
        }
    }

    public static void binary(int a){
        if(a / 2 == 0){
            System.out.print(a % 2);
        }
        else{
            binary(a/2);
            System.out.print(a % 2);
        }
    }
}
