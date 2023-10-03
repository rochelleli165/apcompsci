import java.util.*;
import java.io.*;
public class compile {
    public static void main(String[]args){
        String data;
        ArrayList<variable> list = new ArrayList<variable>();
        try
        {
            File myObj = new File("src/test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();
                //each line has its own command, each command is on one line
                allot(data, list);
            }

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static String allot(String data, ArrayList<variable> list){
        //first character tells what kind of function it is
        //if there's nothing the line, or no data, it returns nothing
        if(data.length() == 0){
            return null;
        }
        String first = data.substring(0,1);

        String last = data.substring(data.length()-1, data.length());
        if(first.equals("0")){
            //assigning variables
            int space = data.indexOf(" ");
            if(space == -1){
                String name = data.substring(1);
                variable x = new variable(name);
                Scanner pen = new Scanner(System.in);
                System.out.println("What type");
                String type = pen.nextLine();
                if(type.equals("s")){
                    x.setType("String");
                    System.out.println("Enter value");
                    String value = pen.nextLine();
                    x.setString(value);
                }
                else if(type.equals("i")){
                    x.setType("Integer");
                    System.out.println("Enter value");
                    int value = pen.nextInt();
                    pen.nextLine();
                    x.setInteger(value);
                }
                else{
                    System.out.println("Error: not type");
                }
            }
            else {
                String name = data.substring(1, space);
                variable x = new variable(name);
                int quotation = data.indexOf("\"");
                String assignment = data.substring(0, space + 1);
                if (quotation != -1) {
                    x.setType("String");
                    String string = data.substring(quotation);
                    x.setString(string);
                } else {
                    x.setType("Integer");
                    int y = Integer.parseInt(data.substring(space+1));
                    x.setInteger(y);
                }
                list.add(x);
            }
        }
        else if(first.equals("1")){
            //adding, subtracting, multiplying, dividing, mod
            int space = data.indexOf(" ");
            int star = data.indexOf("*");
            //after 1, the next numbers are int a
            int a = Integer.parseInt(data.substring(1,space));
            //second int b is before star
            int b = Integer.parseInt(data.substring(space+1, star));
            //last three letters of line determine sign
            String sign = data.substring(data.length()-3);
            return math(a, b, sign);

        }
        else if(first.equals("2")){
            //loops
            int space = data.indexOf(" ");
            int iteratorNum = Integer.parseInt(data.substring(1, space));
            for(int i = 0; i < iteratorNum; i++){
                allot(data.substring(space+1), list);
            }
        }
        else if(first.equals("3")){
            //conditional statements
            int space = data.indexOf(" ");
            int star = data.indexOf("*");
            //comparison statement is after three and before 1st space
            String comparison = data.substring(1, space);
            //first int is
            int a = Integer.parseInt(comparison.substring(0, 1));
            int slash = data.indexOf("/");
            String compareSign = comparison.substring(1, slash-1);
            int b = Integer.parseInt(comparison.substring(slash, star-1));
            boolean bool = testbool(a, b, compareSign);
            if(bool){
                allot(data.substring(star+2), list);
            }
            else{
                return null;
            }

        }
        else if(first.equals("4")){
            //comment, do nothing
            return null;
        }
        else if(first.equals("5")){
            //print
            int space = data.indexOf(" ");
            String line = data.substring(space+1, space+2);
            if(data.length() == 3){
                data = " ";
            }
            else {
                data = data.substring(space + 2);
            }
            System.out.print(allot(data,list));
            if (line.equals("l")) {
                System.out.println();
            }
            else {
                return data;
            }

        }
        return data;

    }
    public static boolean testbool(int a, int b, String sign){
        if(sign.equals("<")){
            if(a < b){
                return true;
            }
            else{
                return false;
            }
        }
        else if(sign.equals("<=")){
            if(a <= b){
                return true;
            }
            else{
                return false;
            }
        }
        else if(sign.equals("==")){
            if(a == b){
                return true;
            }
            else{
                return false;
            }
        }
        else if(sign.equals(">")){
            if(a > b){
                return true;
            }
            else{
                return false;
            }
        }
        else if(sign.equals(">=")) {
            if(a >= b){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            System.out.println("No sign comparison");
        }
        return false;
    }
    public static String math(int a, int b, String sign){
        int c;
        if(sign.equals("add")){
            c = a + b;
        }
        else if(sign.equals("act")){
            c = a - b;
        }
        else if(sign.equals("ply")){
            c = a * b;
        }
        else if(sign.equals("ide")){
            c = a / b;
        }
        else if(sign.equals("mod")){
            c = a % b;
        }
        else{
            System.out.println("ERROR, no sign");
            c = 0;
        }
        return Integer.toString(c);


    }


}
