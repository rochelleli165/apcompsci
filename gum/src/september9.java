public class september9 {
    public static void main (String[] args) {
        int x = 1;
        for (int j = 0; j < 5; j++){
            System.out.println();
            for (int i = 0; i < 5-x; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < x; i++) {
                System.out.print(x);
            }
            x++;
        }
    }
}
