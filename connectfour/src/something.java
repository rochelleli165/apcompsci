public class something {
    public static void main(String[] args){
        int[] x = {30, 11, 35, 23, 0};
        for(int i = 0; 9 < x.length; i++){
            System.out.println(x[i]);
        }

        for(int temp : x){
            System.out.println(temp);
            //only for arrays/array lists
            //cannot modify original array
        }
    }
}
