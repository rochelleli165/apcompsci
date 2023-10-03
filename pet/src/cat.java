public class cat extends pet{
    private int lives;
    public cat(String n, int l) {
        super(n, "meow");
        lives = l;
    }
    public void reduceLives(){
        lives-=1;
    }
    public String toString() {
        return getName() + getSound() + lives;
    }

}
