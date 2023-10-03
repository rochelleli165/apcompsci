public class shoe {
    private String brand;
    private double size;
    private String color;

    public shoe() {
        brand = "kirkland shoes";
        size = 8;
        color = "hot pink";
    }

    public shoe(String b, double s, String c) {
        brand = b;
        size = s;
        color = c;
    }

    public String getBrand() {
        return brand;
    }

    public double getSize() {
        return size;
    }

    public String getColor(){
        return color;
    }



    public void setBrand(String b){
        brand = b;
    }

    public void setSize(double s){
        size = s;
    }

    public void setColor(String c){
        color = c;
    }







}
