public class fruits {
    private String color;
    private double weight;

    public fruits(String c, double w){
        color = c;
        weight = w;
    }

    public String getColor() {
        return color;
    }

    public double getWeight(){
        return weight;
    }

    public void setColor(String c){
        color = c;
    }

    public void setWeight(double w){
        weight = w;
    }

    public String toString(){
        return "my color is " + color + " . My weight is " + weight;
    }
}
