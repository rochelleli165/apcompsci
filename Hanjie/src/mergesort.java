public class mergesort {
    public static void main(String[] args){
        int[] a = {5, 90, 8, 7, 10};

        mergesort(a);



    }

    public static void mergesort(int[] a){
        if(a.length == 1){

        }

        else{
            int length = a.length;
            int[] x = new int[length / 2];
            int[] y = new int[length - x.length];
            int mid = length/2;

            for (int i = 0; i < x.length; i++) {
                x[i] = a[i];
            }

            for( int i = mid; i < length; i++){
                y[i-mid] = a[i];
            }

            mergesort(x);
            mergesort(y);
            merging(a, x, y);
        }
    }

    public static void merging(int[] a, int[] x, int[] y){
        int x_counter = 0;
        int y_counter = 0;
        int a_index = 0;
        while(x_counter < x.length && y_counter < y.length){

            if(x[x_counter] < y[y_counter]){
                a[a_index] = x[x_counter];
                x_counter++;
            }
            else{
                a[a_index] = y[y_counter];
                y_counter++;
            }
            a_index++;



        }
        while (y_counter < y.length) {
            a[a_index] = y[y_counter];
            y_counter++;
            a_index++;
        }
        while (x_counter < x.length) {
            a[a_index] = x[x_counter];
            x_counter++;
            a_index++;
        }

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


}
