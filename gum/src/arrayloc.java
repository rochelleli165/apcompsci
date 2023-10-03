public class arrayloc {
    public static void main(String[] args) {

    }
    public int arrayLocate(int a[], int index) {
       if (index < 0){
           int x = a[index];
           return x;
       }

       else {
           int x = a[a.length+1-index];
           return x;
       }
    }
}
