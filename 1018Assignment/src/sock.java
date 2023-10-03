public class sock {
    private double size;
    private String color;

    public sock() {
        size = 10;
        color = "White";
    }

    public sock(double s, String c){
        size = s;
        color = c;
    }

    public double getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(double s) {
        size = s;
    }

    public void setColor(String c) {
        color = c;
    }
}

