public class classroom {
    private student[] students;
    private String name;

    public classroom(student[] s, String n){
        students = s;
        name = n;
    }

    public student[] getStudents(){
        return students;
    }

    public String getName(){
        return name;
    }

    public void setStudents(student[] s){
        students = s;
    }
    public void setName(String n){
        name = n;
    }


}
