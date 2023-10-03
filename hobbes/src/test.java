public class test {
    /**
     * A tester method to test the built-in Java method Integer.parseInt();
     * @return true if all tests pass, false otherwise
     */
    public static boolean test(){
        //scenario 1: typical use
        {
           String input = "5";
           int expected = 5;
           if(Integer.parseInt(input) != expected){
               return false;
           }
           input = "-5";
           expected = -5;
            if(Integer.parseInt(input) != expected){
                return false;
            }
        }
        //scenario 2 illegal input
        {
            String input = "five";
            int expected = 5;
            //if(Integer.parseInt(input) != expected) return false;
        }
        return true;
    }
    public static void main(String[] args){
        //test a Java-provided method
        System.out.println("Test result: " + test());
    }

}
