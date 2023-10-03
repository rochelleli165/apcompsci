import java.util.*;
public class bobamain {
    public static void main(String[] args){
        drink[] x = new drink[3];
        x[0] = new drink("juice", 50, 30);
        x[1] = new drink("water", 0, 0);
        x[2] = new drink("smoothie", 50, 50);
        boba[] y = new boba[3];
        ArrayList<String> z = new ArrayList<String>();
        ArrayList<String> a;
        y[0] = new boba("boba", 50, 50, z );
        y[1] = new boba("boba", 100, 50,z);
        y[2] = new boba("boba", 20, 50, z);
        y[1].setType("jasmine milk tea");
        y[1].setIcepercentage(50);
        y[1].setSweetpercentage(30);
        y[1].setToppings(0, "pudding");

        System.out.println(y[1].getToppings(0));

    }
}
