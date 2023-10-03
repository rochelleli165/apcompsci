import java.util.ArrayList;

public class novemberpractice {
    public static void main(String[] args){
        int[] x = {2, 4, 6, 8, 10, 12, 14, 16 , 18, 20};
        for(int temp : x){
            System.out.print(" " + temp);
        }
        System.out.println();
        int[] y = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] z = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i = 0; i < 10; i++ ){
            for(int j = 0; j < 10; j++){
                System.out.print(" " + y[j] * z[i]);
            }
            System.out.println();
        }

        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 2; i <= 20; i+=2){
            a.add(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.print(" " + a.get(i));
        }
        System.out.println();

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        b.add(3);
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(4);
        d.add(5);
        d.add(6);
        ArrayList<Integer> e = new ArrayList<Integer>();
        e.add(7);
        e.add(8);
        e.add(9);

        ArrayList<ArrayList> c = new ArrayList<ArrayList>();
        c.add(b);
        c.add(d);
        c.add(e);

        System.out.println(c.get(0).get(0));
        System.out.println(c.get(1).get(1));
        System.out.println(c.get(2).get(0));

    }


}
