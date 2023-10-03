public class card {
    private int number;
    private String name;
    private String suit;

    public card (int num, String s){
        number = num;
        name = realName(number);
        suit = s;
        fixNum(number);
    }

    public String realName(int num){
        String n;
        if (num == 11) {
            n = "Jack of ";
            return n;
        }
        else if (num == 12) {
            n = "Queen of ";
            return n;
        }
        else if (num == 13){
            n = "King of ";
            return n;
        }
        else if (num == 1){
            n = "Ace of ";
            return n;
        }
        else {
            n = num + " of ";
            return n;
        }
    }

    public void setNumber(int num){
        number = num;
    }
    public void setName(String n){
        name = n;
    }
    public void setSuit(String s) {
        suit = s;
    }

    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getSuit(){
        return suit;
    }

    public String toString(){
        return name + suit;
    }

    public void fixNum(int num){
        if (num > 10) {
            number = 10;
        }
    }

}
