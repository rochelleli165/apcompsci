import java.util.*;
public class dinosaurSpeed {
    public static void main(String[] args){
        String input1;
        input1 = """
NAME,LEG_LENGTH,DIET
Hadrosaurus,1.2,herbivore
Struthiomimus,0.92,omnivore
Velociraptor,1.0,carnivore
Euoplocephalus,1.6,herbivore
Stegosaurus,1.40,herbivore
Tyrannosaurus Rex,2.5,carnivore""";

        String input2;
        input2 = """
NAME,STRIDE_LENGTH,STANCE
Euoplocephalus,1.87,quadrupedal
Stegosaurus,1.90,quadrupedal
Tyrannosaurus Rex,5.76,bipedal
Hadrosaurus,1.4,bipedal
Struthiomimus,1.34,bipedal
Velociraptor,2.72,bipedal""";

        String input3;
        input3 = """
DIET,SALUTATION
herbivore,KALE
omnivore,FOOD
carnivore,ROAR
""";
        HashMap <String, String> dinosaurDietSalutation = new HashMap<String, String>();
        String[] lines2 = input3.split(System.lineSeparator());
        int z = 0;
        for(String line : lines2){
            z++;
            if(z == 1){
                continue;
            }
            String[] column = line.split(",");
            dinosaurDietSalutation.put(column[0], column[1]);
            //System.out.println("Line number " + x + ": " + line);
        }
        HashMap <String, Double> dinosaurLegLength = new HashMap<String, Double>();
        HashMap <String, String> dinosaurDiet = new HashMap<String, String>();
        String[] lines = input1.split(System.lineSeparator());
        int x = 0;
        for(String line : lines){
            x++;
            if(x == 1){
                continue;
            }
            String[] column = line.split(",");
            dinosaurLegLength.put(column[0], Double.parseDouble(column[1]));
            dinosaurDiet.put(column[0], column[2]);
            //System.out.println("Line number " + x + ": " + line);
        }
        HashMap <String, Double> dinosaurStrideLength = new HashMap<String, Double>();
        String[] lines1 = input2.split(System.lineSeparator());
        int y = 0;
        for(String line : lines1){
            y++;
            String[] columns = line.split(",");
            if(y == 1 || !columns[2].equals("bipedal")){
                continue;
            }
            dinosaurStrideLength.put(columns[0], Double.parseDouble(columns[1]));
            //System.out.println("Line number " + y + ": " + line);
        }
        HashMap<String, Double> dinosaurSpeed = new HashMap<String, Double>();
        for(String key : dinosaurStrideLength.keySet()){
            double LEG_LENGTH = dinosaurLegLength.get(key);
            double STRIDE_LENGTH = dinosaurStrideLength.get(key);
            double speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * Math.sqrt(LEG_LENGTH * 9.8);
            String newKey = dinosaurDietSalutation.get(dinosaurDiet.get(key));
            dinosaurSpeed.put((newKey + "! " + key), speed);
        }
        int listLength = dinosaurSpeed.size();
        int maxStringLength = 0;
        for(String key : dinosaurSpeed.keySet()){
            maxStringLength = Math.max(maxStringLength, key.length());
        }
        int numStars = 7 + maxStringLength + (int)Math.log10(listLength);
        if(listLength > 0) {
            for (int i = 0; i < numStars; i++) {
                System.out.print("*");
            }
            System.out.println();
            int j = 1;
            dinosaurSpeed.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
                    //.forEach(entry -> System.out.println("* " + j++ + ")" + entry.getKey() + " *"));
            for(String key : dinosaurSpeed.keySet()){
                int padLength = (maxStringLength-key.length());
                System.out.print("* " + j++ + ") " + key);
                for(int k = 0; k < padLength; k++){
                    System.out.print(" ");
                }
                System.out.println(" *");
            }
            //.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
            for (int i = 0; i < numStars; i++) {
                System.out.print("*");
            }
        }
    }


}
