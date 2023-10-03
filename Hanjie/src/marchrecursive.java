public class marchrecursive {
    public static void main(String[] args){
        vc("dhruv");
    }
    public static void vc(String word){
        if(word.length() == 1){
            if(word == "a" ||word == "e" || word == "i" || word == "o" || word == "u"){
                System.out.print("v");
            }
            else{
                System.out.print("c");
            }
        }
        else{
            if(word.substring(0,1).equals("a") || word.substring(0,1).equals("e") || word.substring(0,1).equals("i") || word.substring(0,1).equals("o") || word.substring(0,1).equals("u")){
                System.out.print("v");
                String newword = word.substring(1, word.length());
                vc(newword);
            }
            else{
                System.out.print("c");
                String newword = word.substring(1, word.length());
                vc(newword);
            }
        }
    }

}
