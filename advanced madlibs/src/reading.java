import java.util.*;
import java.io.*;  // Import the File class

public class reading {



        public static void main( String[] args)
        {

    //reading
    try
    {
      File myObj = new File("stuff.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine())
      {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }




            //writing
            try
            {
                FileWriter myWriter = new FileWriter("stuff.txt");
                myWriter.write("Hooooooo club MIP\n");
                myWriter.write("go Bringhurst Blazers\n\n");
                myWriter.write("5.0 7 APS\n");
                myWriter.write("You'll set the curve for the SAT\n");
                myWriter.write("sine sine cosine sine");
                myWriter.write("\"3.14159\"\n");
                myWriter.write("Bringhurst -> Hopkins -> MSJ -> UCR or UCLA\n");
                myWriter.write("#topHumansInLife\n");

                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }
            catch (IOException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


        }
    }

