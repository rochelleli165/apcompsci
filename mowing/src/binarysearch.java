import java.util.*;
public class binarysearch {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10, 11, 12, 13, 14, 15, 16};

        int number = 5;
        int counter = 2;

        boolean found = false;
        int mid = a.length/2;
        int low = 0;
        int high = a.length-1;

        while (!found) {
            if(counter > a.length){
                System.out.println(false);
                found = true;
            }
            if(number > a[mid]){
                mid = (mid + high)/2;
                counter *= 2;
            }
            else if(number == a[mid]){

                System.out.println("found it! index: " + mid);
                found = true;
            }
            else{
                mid = (mid + low)/2;
                counter *= 2;
            }
        }
    }
}
