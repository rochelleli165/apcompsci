import java.util.*;
public class arraylist {
    public static void main(String[] args){
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(20);
        x.add(11);
        x.add(35);
        x.set(1, 22);
        System.out.println(x.get(1));
        x.remove(1); //20, 35
        x.add(1, 23); //20, 23, 35
        System.out.println(x);
        System.out.println(x.size());
    }
}
