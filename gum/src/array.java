public class array {
    public static void main (String[] args){
        int array[] = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i+1;
        }

        for (int i = 0; i < 10; i++) {
            if (i%2 == 1) {
                array[i] *= 5;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (i%3 == 0) {
                array[i] -= 6;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}

// System.out.ln(x.length);
