public class player {
    private int bank;
    private String name;

    public player (int b, String n) {
        bank = b;
        name = n;
    }

    public void setBank(int b){
        bank = b;
    }
    public void setName(String n){
        name = n;
    }

    public int getBank(){
        return bank;
    }
    public String getName(){
        return name;
    }
}
