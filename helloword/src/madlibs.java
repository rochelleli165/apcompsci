/*
PEMDAS becomes PMMDAS
PMMDAS comes into work
tier 1: parenthesis
tier 2: multiplication/division/modulus
tier 3: addition/subtraction
 */

//header
import java.util.*;

public class madlibs {
    public static void main(String[] args){
        //tool to use to grab inputs
        Scanner pen = new Scanner(System.in);

        String plural_noun;
        System.out.println("Plural Noun.");
        plural_noun = pen.nextLine();
        pen.nextLine();

        String plural_noun1;
        System.out.println("Another Plural Noun.");
        plural_noun1 = pen.nextLine();

        String adjective;
        System.out.println("Adjective.");
        adjective = pen.nextLine();

        String noun;
        System.out.println("Noun.");
        noun = pen.nextLine();

        String verb;
        System.out.println("Verb.");
        verb = pen.nextLine();

        String adjective1;
        System.out.println("Adjective.");
        adjective1 = pen.nextLine();

        String plural_noun2;
        System.out.println("Plural Noun.");
        plural_noun2 = pen.nextLine();

        String plural_noun3;
        System.out.println("Another Plural Noun.");
        plural_noun3 = pen.nextLine();

        String verb1;
        System.out.println("Verb.");
        verb1 = pen.nextLine();

        String adverb;  //10
        System.out.println("Adverb.");
        adverb = pen.nextLine();

        String plural_noun4;
        System.out.println("Plural Noun.");
        plural_noun4 = pen.nextLine();

        String plural_noun5;
        System.out.println("Plural Noun.");
        plural_noun5 = pen.nextLine();

        int time;
        System.out.println("Number.");
        time = pen.nextInt();
        pen.nextLine();

        int days;
        System.out.println("Number.");
        days = pen.nextInt();
        pen.nextLine();

        int homework;
        System.out.println("Number.");
        homework = pen.nextInt();
        pen.nextLine();

        int quiz;
        System.out.println("Number.");
        quiz = pen.nextInt();
        pen.nextLine();

        int percentage;
        System.out.println("Number between 0 and 100.");
        percentage = pen.nextInt();
        pen.nextLine();

        String noun1;
        System.out.println("Noun.");
        noun1 = pen.nextLine();

        String noun2;
        System.out.println("Noun.");
        noun2 = pen.nextLine();

        String Day_of_the_Week; //20
        System.out.println("Day of the Week.");
        Day_of_the_Week = pen.nextLine();

        String noun3;
        System.out.println("Noun.");
        noun3 = pen.nextLine();

        String noun4;
        System.out.println("Noun.");
        noun4 = pen.nextLine();

        String adjective2;
        System.out.println("Adjective.");
        adjective2 = pen.nextLine();

        String adjective3;
        System.out.println("Adjective.");
        adjective3 = pen.nextLine();

        String emotion;
        System.out.println("Emotion.");
        emotion = pen.nextLine();

        String cost;
        System.out.println("Cost.");
        cost = pen.nextLine();

        String adjective4;
        System.out.println("Adjective.");
        adjective4 = pen.nextLine();

        String quality;
        System.out.println("Quality.");
        quality = pen.nextLine();

        String token;
        System.out.println("Token.");
        token = pen.nextLine();

        String time_frame;
        System.out.println("Time Frame.");
        time_frame = pen.nextLine();

        System.out.print("In this class we will use a variety of " + plural_noun + " and " + plural_noun1 + " to access information " +
                "to access " + noun +" to help us better " + verb + " the American Government." +
                " We will engage in " + adjective + " " + plural_noun1 + " and " + plural_noun2 + ", which will require you to work both " +
                adverb + " and in groups. Projects include " + plural_noun3 + ", " + plural_noun4 + ", and " + plural_noun5);

        System.out.println (". During this course we will be looking at " + adjective3 + " and " + adjective4 + " " + noun1 + " and " + noun2
                + ". In this course I will provide you with a " + noun3 + " and a " + noun4 + " to come to your own conclusions about " + plural_noun5 + " and sometimes" +
                "controversial topics."
        + percentage + "% of your grade is for tests." + (100-percentage) + "% will be for homework.");
        System.out.print("I will " + verb1 + " to all emails within " + time + " hours or later, " + days + "/7. " + Day_of_the_Week + " through Friday." +  "You can reach me through " +
                adjective1 + " Campus or email. The " +  adjective2 + " way to reach me is through email. Homework should be competed within " + homework + " minutes."
        + "I give out " + quiz + " quizzes per semester.");

        System.out.println(" If you happen to lose your textbook please pay " + cost + " along with " +
                "34 " + token +  ". Please don't be " + emotion + ". These are the rules. I expect students to be " + quality + " and " +
                "respectful. School lasts from " + time_frame + "!");





        /*
        int favNum;
        System.out.println("What is your favorite number?");
        favNum = pen.nextInt(); //ENTER SEVEN
        pen.nextLine(); //ENTER BUTTON
        System.out.println(favNum + " is a great number!");

        double gpa;
        System.out.println("What is your gpa?");
        gpa = pen.nextDouble();
        pen.nextLine();
        System.out.println(gpa + " is a great gpa!");

        String name;
        System.out.println("What is your name?");
        name = pen.nextLine();
        System.out.println(name + " is a great name!"); */

    }
}
