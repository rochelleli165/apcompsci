import java.util.*;
public class stringpractice {
    public static void main(String[] args){
       ArrayList<Integer> x = new ArrayList<Integer> ();
       x.add(30);
       x.add(11);
       x.add(9);
       x.add(23);
       x.add(0);
       System.out.println(x);
       x.set(2, 35);
       System.out.println(x);
       x.remove(1);
       x.remove(1);
       System.out.println(x);
       x.set(2, 5);
       x.add(1, 3);
       x.add(2, 22);

       System.out.println(x);

    }
}
