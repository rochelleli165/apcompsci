import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        System.out.println("Number of runners");
        int num;
        num = pen.nextInt();
        pen.nextLine();

        runners[] list = new runners[num];
        for(int i = 0; i < list.length; i++){
            System.out.println("Score");
            int score;
            score = pen.nextInt();
            pen.nextLine();
            System.out.println("Gender");
            String gender = pen.nextLine();
            list[i] = new runners(score, gender);
        }

        boolean notorder = true;
        int counter = 0;
        while(notorder && counter < list.length-1) {
            for (int i = 0; i < list.length-1; i++) {
                if (list[i + 1].getScore() < list[i].getScore()) {
                    int a = list[i].getScore();
                    int b = list[i + 1].getScore();
                    String c = list[i].getGender();
                    String d = list[i+1].getGender();
                    list[i + 1].setScore(a);
                    list[i].setScore(b);
                    list[i + 1].setGender(c);
                    list[i].setGender(d);
                }
            }

            counter++;
        }
 //first place overall
        System.out.println(list[0].getScore());
//first place women
        int i = 2;
        boolean x = true;
        while (i < list.length && x){
            if(list[i].getGender() == "F"){
                System.out.println(list[i].getScore());
                x = false;
            }
            i++;
        }
//first and second place men
        int j = 2;
        int count = 0;
        while (j < list.length && count < 2) {
            if(list[j].getGender() == "M"){
                System.out.println(list[j].getScore());
                count++;
            }
            j++;
        }

    }
}
