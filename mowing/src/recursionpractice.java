public class recursionpractice {
    public static void main (String[] args){
        System.out.println(fact(5));
        stars(3);
        System.out.println(sum(4, 5));
        System.out.println(product(5, 5));
        System.out.println(power(2,3));
        System.out.println(sumofdigits(1724));
    }
    public static void stars(int a){
        if(a == 0) {

        }
        else{
            for(int i = a; i > 0; i--){
                System.out.print("*");
            }
            System.out.println();
            stars(a-1);
        }
    }
    public static int sum(int a, int b){
        if(b == 0){
            return a;
        }
        return 1 + sum(a,b-1);
    }
    public static int product(int a, int b){
        if(b == 0){
            return 0;
        }
        return sum(a, product(a,b-1));
    }
    public static int power(int a, int b){
        if(b == 0) {
            return 1;
        }
        return product(a, power(a, b-1));
    }
    public static int sumofdigits(int x){
        if(x / 10 == 0){
            return 1;
        }
        int y =  (x / 10) * 10;
        int z = x - y;
        return z + sumofdigits(x / 10);
    }

    public static int fact(int n){
  //base case
        if(n == 1) {
            return 1;
        }
        return n* fact(n-1);
    }

}
