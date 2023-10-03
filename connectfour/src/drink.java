public class drink {
    private String type;
    private int icepercentage;
    private int sweetpercentage;

    public drink(String t, int i, int s) {
        type = t;
        icepercentage = i;
        sweetpercentage = s;
    }

    public String getType(){
        return type;
    }
    public int getIcepercentage(){
        return icepercentage;
    }
    public int getSweetpercentage(){
        return sweetpercentage;
    }

    public void setType(String t){
        type = t;
    }
    public void setIcepercentage(int i){
        icepercentage = i;
    }
    public void setSweetpercentage(int s){
        sweetpercentage = s;
    }
}
