public class printthree {
    public static void main(String[] args){
       printStar(2, 3);


    }
    public static void printStar(int b, int a){
        if(b == 0){

        }
        else{
            printrow(a);
            System.out.println();
            printStar(b-1, a);

        }

    }
    public static void printrow(int a){
        if(a == 0 ){

        }
        else{
            System.out.print("*");
            printrow(a-1);
        }
    }
}
