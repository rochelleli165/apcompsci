import java.util.*;
public class deck {
    private ArrayList<card> deck;
    public deck (ArrayList<card> d) {
        d = new ArrayList<card>();
    }

    public void setDeck(ArrayList<card> d){
        deck = d;
    }

    public ArrayList<card> getDeck(){
        return deck;
    }

    public void shuffle(ArrayList<card> d){
        for(int i = 0; i < 5000; i++) {
            int x = (int) (Math.random() * d.size());
            card holder = d.get(x);
            d.remove(x);
            d.add(holder);
        }
    }


}
