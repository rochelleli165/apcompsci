import java.util.Scanner;

public class stringcommand {
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        System.out.println("String");
        String a;
        a = pen.nextLine();

        //reverse(a);
        eliminate(a);

    }

    public static void reverse(String a) {
        int l = a.length();
        for (int i = l-1 ; i >= 0; i--) {
            int k = i+1;
            System.out.print(a.substring(i,k));
        }

    }

    public static void eliminate(String a) {
        int l = a.length();
        String z = a;
            for(int i = 0; i < l-1; i++){
                String b = a.substring(i, i+1);
                String c = a.substring(i+1, i+2);
                if (b.compareTo(c) == 0) {
                   z = (a.substring(0,i+1) + a.substring(i+2, l));
                }
            }
        System.out.println(z);
    }


}
