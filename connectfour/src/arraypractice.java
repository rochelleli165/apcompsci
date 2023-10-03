import java.util.Scanner;

public class arraypractice {
    public static void main(String[] args){
        int[] y = {1, 3, 1, 4};
        int[] z = {1, 3, 1, 4, 4, 3, 1};
        int[] a = {3, 2, 2, 4};
        fix34(y);
        System.out.println();
        fix34(z);
        System.out.println();
        fix34(a);
        System.out.println();
        int[] b = {1, 2, 2, 3, 4, 4};
        countClumps(b);
        int[] c = {1, 1, 2, 1, 1};
        countClumps(c);
        int[] d = {1, 1, 1, 1, 1};
        countClumps(d);
        String[] e = {"a", "b", "b", "b"};
        String[] f = {"a", "c", "b", "c"};
        scoreUp(e, f);
        String[] g = {"a", "a", "b", "b"};
        String[] h = {"a", "a", "b", "c"};
        scoreUp(g, h);
        String[] i = {"a", "a", "b", "b"};
        String[] j = {"a", "a", "b", "b"};
        scoreUp(i, j);

    }
    public static void scoreUp(String x[], String key[]){
        int score = 0;
        for(int i = 0; i < key.length; i++){
            if (x[i] == key[i]){
                score+=4;
            }
            if(x[i] != key[i] && x[i] != "?"){
                score--;
            }
        }
        System.out.println(score);

    }

    public static void countClumps(int x[]){
        int counter = 0;
        if(x[0] == x[1]){
            counter++;
        }
        for(int i = 1; i < x.length-1; i++){
            if(x[i] == x[i+1] && x[i] != x[i-1]){
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void fix34(int x[]){
    for(int u = 0; u < x.length-1; u++) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] == 3) {
                int a = 0;
                for (int j = a; j < x.length; j++) {
                    if (x[j] == 4) {
                        x[j] = x[i + 1];
                        x[i + 1] = 4;
                        a = i + 1;
                    }
                }
            }
        }
    }
        for(int i = 0; i < x.length; i++){
            System.out.print(" " + x[i]);
        }
    }
}

