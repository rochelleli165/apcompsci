public class fibonacci {
    public static void main(String[] args){
       int num = 1;
       int num1 = 1;
       int answer;

       boolean progress = true;

       while (progress == true) {
           answer = num + num1;
           System.out.println(answer);
           num = num1;
           num1 = answer;
       }


    }
}
