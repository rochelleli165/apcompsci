public class Numbermain {
    public static void main(String[] args){
        Number x = new Number(54);
        numTree(x);
        displayMult(x);
    }
    public static void numTree(Number x){
        int starter = 2;
        boolean progress = true;
        while(starter < x.getValue() && progress){
            if(x.getValue() % starter != 0){

            }
            else {
                Number y = new Number(starter);
                Number z = new Number(x.getValue() / starter);
                x.setLeft(y);
                x.setRight(z);
                if(isPrime(z.getValue())){
                    progress = false;
                }
                else{
                    numTree(z);
                    progress = false;
                }

            }
            starter++;
        }
    }
    public static void displayMult(Number x){
        if (x.getRight() == null) {
            System.out.println(x.getValue());
        }
        else {
            System.out.println(x.getLeft().getValue());
            displayMult(x.getRight());
        }
    }
    public static boolean isPrime(int num){
        int i = 2;
        boolean isPrime;
        boolean stop = true;
        while(i<num && stop) {
            int answer = num % i;
            if (answer == 0) {
                stop = false;
                return false;
            }
            else {
                i++;
            }
        }
        return true;
    }
}
