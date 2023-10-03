public class mission {
    public static void main(String[] args){
        student alison = new student("Alison", 4.0);
        student pareek = new student("Pareek", 7.5);

        student[] students = new student[35];
        students[0] = alison;
        students[1] = pareek;

        classroom B2 = new classroom(students, "B2");

        classroom[] classrooms = new classroom[50];
        classrooms[0] = B2;

        school mission = new school(classrooms, "Jeff Evans");

        System.out.println(mission.getClassrooms()[0].getStudents()[1].getGPA());
    }
}
