import java.util.Scanner;

public class smartarrays{
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        System.out.println("Number of int");
        int num;
        num = pen.nextInt();
        pen.nextLine();

        int array[] = new int[num];

        for (int i = 0; i < num; i++) {
            int a = pen.nextInt();
            pen.nextLine();
            array[i] = a;
        }

    }

    public void add(int[] a, int value){
        int b[] = new int[a.length+1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        b[b.length] = value;
    }

    public void Add(int[] a, int spot, int value) {
        int b[] = new int[a.length+1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        for (int i = b.length; i > spot; i--) {
            b[i] = b[i-1];
        }
        b[spot] = value;
    }

    public void remove(int[] a){
        int b[] = new int[a.length-1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
    }

    public void Remove(int[] a, int spot){
        int b[] = new int[a.length-1];
        for (int i = spot; i < b.length; i++) {
            b[i] = a[i+1];
        }
    }

    public void replace(int[] a, int spot, int value) {
        int b[] = new int[a.length+1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        b[spot] = value;
    }

    public void indexOf(int[] a, int value){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                System.out.println(i);
            }
            else{
                System.out.println("-" + 1);
            }
        }
    }
}
