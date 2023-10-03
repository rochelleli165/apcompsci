public class school {
    private classroom[] classrooms;
    private String name;

    public school(classroom[] c, String n){
        classrooms = c;
        name = n;
    }

    public classroom[] getClassrooms(){
        return classrooms;
    }

    public String getName(){
        return name;
    }

    public void setClassrooms(classroom[] c){
        classrooms = c;
    }
    public void setName(String n){
        name = n;
    }
}
