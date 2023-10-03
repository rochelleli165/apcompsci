public class student {
    private String name;
    private double GPA;

    public student(String n, double g){
        name = n;
        GPA = g;
    }

    public String getName(){
        return name;
    }

    public double getGPA(){
        return GPA;
    }

    public void setName(String n){
        name = n;
    }
    public void setGPA(double g){
        GPA = g;
    }
}
