import java.util.*;
public class boba extends drink {
    private ArrayList<String> toppings;

    public boba (String t, int i, int s, ArrayList<String> toppings){
        super(t, i, s);
        this.toppings = new ArrayList<String>();
        this.toppings.add("none");
    }

    public String getToppings(int x){
        return this.toppings.get(x);
    }

    public void setToppings(int i, String T){
        this.toppings.set(i, T);
    }


}
