public class oddeven {
    public static void main(String[] args){
            oddeven(8);
            System.out.println();
            oddeven(5);
    }
    public static void oddeven(int a){
        if(a <= 0){
            System.out.print(0);
        }
        else{
            System.out.print(a);
            oddeven(a-2);
            if( a % 2 == 0) {
                System.out.print(a - 1);
            }
            else{
                System.out.print(a + 1);
            }

        }
    }



}
