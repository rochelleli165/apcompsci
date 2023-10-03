//Tiffany Li
//Perio 2
//17 Feb 2021
//MergeSort

import java.util.*;

public class merge {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        //initializing
        int i;
        ArrayList<Integer> arrayL = new ArrayList<Integer>();

        //asking for length of array
        System.out.println("Enter how long your array is");
        int x = input.nextInt();
        input.nextLine();
        //user input
        for (i = 0; i < x; i++) {
            System.out.println("Enter a number");
            int num = input.nextInt();
            input.nextLine();

            arrayL.add(num);
        }
        //copy arr to array
        int[] arr = new int[arrayL.size()];
        for (i = 0; i < arrayL.size(); i++)
            arr[i] = arrayL.get(i);

        //send to sort method
        sort(arr);
        //printing array
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //sort method
    public static void sort(int[] arr) {
        int i;

        //base case
        if (arr.length < 2) //make sure that middle isn't zero
            return;

        //intializing 2 arrays & middle
        int middle = arr.length / 2;
        int[] l = new int[middle];
        int[] r = new int[arr.length - middle];

        //copying a info to smaller arrays
        for (i = 0; i < middle; i++)
            l[i] = arr[i];
        for (i = middle; i < arr.length; i++)
            r[i - middle] = arr[i];

        //recursive case
        sort(l);
        sort(r);

        //sending to mergeSort to put the arrays together
        mergeSort(arr, l, r, middle, arr.length - middle);

    }

    //mergeSort method
    public static int[] mergeSort(int[] arr, int[] l, int[] r, int lower, int upper) {
        int i = 0;
        int j = 0;
        int b = 0;

        //copying info from a to l/r
        while (i < lower && j < upper) {
            if (l[i] <= r[j]) {
                arr[b] = l[i];
                b++;
                i++;
            }
            else {
                arr[b] = r[j];
                b++;
                j++;
            }

        }
        //copying info that was missed in if statement above
        while (i < lower) {
            arr[b] = l[i];
            b++;
            i++;
        }
        while (j < upper) {
            arr[b] = r[j];
            b++;
            j++;
        }

        return arr;
    }

}