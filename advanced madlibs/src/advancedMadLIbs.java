import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class advancedMadLIbs {
    public static void main(String[] args){
        String data;
        ArrayList<String> wordlist = new ArrayList<String>();
        try
        {
            File myObj = new File("God.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();
                data = convert(data);
                wordlist.add(data);
            }

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        write(wordlist);



    }
    public static String convert(String data){
        ArrayList<String> wordlist = new ArrayList<String>();
        for(int i = 0; i < data.length(); i++){
            if(data.substring(i, i+1).equals(" ")){
                wordlist.add(data.substring(0, i+1));
                data = data.substring(i+1);
                i = 0;
            }
        }
        wordlist.add(data);
        for(int i = 0; i < wordlist.size(); i++){
            if(wordlist.get(i).equals("God ")){
                wordlist.set(i, "Rochelle ");
            }
        }
        String newdata = "";
        for(int i = 0; i < wordlist.size(); i++) {
            newdata += wordlist.get(i);
        }

        return newdata;
    }
    public static void write(ArrayList<String> wordlist){
        try
        {
            FileWriter myWriter = new FileWriter("newStory.txt");
            for(String x : wordlist) {
                myWriter.write(x + "\n");
            }
            myWriter.close();

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
