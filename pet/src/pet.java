public class pet {
    private String name;
    private String sound;

    public pet () {
        name = null;
        sound = "none";
    }

    public pet (String n, String s){
        name = n;
        sound = s;
    }

    public String getName() {
        return name;
    }
    public String getSound() {
        return sound;
    }

    public void setName(String n) {
        name = n;
    }
    public void setSound(String s) {
        sound = s;
    }

    public String toString() {
        return name + sound;
    }
}
