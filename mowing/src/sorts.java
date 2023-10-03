public class sorts {
    public static void main(String[] args){

        int array[] = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 16};

        for(int i = 0; i < 15; i++){
            System.out.print(array[i] + " ");
        }

    }
    public static int[] smartBubblesort(int[] a){
        boolean notorder = true;
        int counter = 0;
        while(notorder && counter < 14) {
            for (int i = 0; i < 14; i++) {
                if (a[i + 1] < a[i]) {
                    int c = a[i];
                    int b = a[i + 1];
                    a[i + 1] = c;
                    a[i] = b;
                }
                int x = 0;
                int answer = 0;
                while (x < 14) {
                    answer = answer + counting(a, x);
                    if(answer == 14){
                        notorder = false;
                    }
                    x++;
                }

            }

            counter++;
        }
        return a;
    }
    public static int[] insertionSort( int[] a) {
        for (int i = 1; i < a.length; i++){
            int holder = a[i];
            int j = i - 1;

            while (a[j] > holder){
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = holder;
        }
        return a;
    }
    public static int[] selectionSort( int[] a){
        int barrier = 0;
        for(int i = barrier; i < a.length; i++){
            int smallest = a[i];
            int index = i;
            for(int j = 1; j < a.length-barrier; j++){
                if(smallest > a[i+j]){
                    smallest = a[i+j];
                    index = i+j;
                }
            }
            int holder = a[barrier];
            a[barrier] = smallest;
            a[index] = holder;
            barrier++;
        }
        return a;
    }

    public static int counting(int[] array, int i){
        if(array[i] < array[i+1]){
            int count = 1;
            return count;
        }
        else{
            int count = 0;
            return count;
        }
    }




}
