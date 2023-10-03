public class variable {
    private String name;
    private String type;
    private String string;
    private int integer;
    private double doub;
    private boolean bool;

    public variable(String n) {
        n = name;
    }
    public String getName(){return name;}
    public String getType(){return type;}
    public String getString(){return string;}
    public int getInteger(){return integer;}
    public double getDouble(){return doub;}
    public boolean getBoolean(){return bool;}

    public void setType(String t){type = t;}
    public void setString(String s){string = s;}
    public void setInteger(int i){integer = i;}
    public void setDouble(double d){doub = d;}
    public void setBoolean(boolean b){bool = b;}




}