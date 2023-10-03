public class MathMethods {

    public static void sqrt(int a){
        int answer = 1;
        int remainder = a;
        for(int i = 2; i < a; i++){
            for(int j = 2; j < a; j++){
                if(a % (j*j) == 0){
                    answer = j * answer;
                    remainder = (a/j)/j;
                    a = (a/j)/j;
                }
            }
        }
        System.out.println(answer + "root" + remainder);
    }
}
