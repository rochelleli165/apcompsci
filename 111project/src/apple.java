public class apple extends fruits{
    private String type;

    public apple(String c, double w, String t) {
        super(c, w);
        type = t;
    }

    public String getType(){
        return type;
    }

    public void setType(String t){
        type = t;
    }

    public String toString(){
        return "my color is " + getColor() + ". My weight is " + getWeight() + ". my type is " + type;
    }
}
