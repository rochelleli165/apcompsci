public class main {
    public static void main(String[] args) {
        shoe defie = new shoe();

        shoe rochelle = new shoe("Nike", 12, "purple");

        shoe alison = new shoe("Rainbow", 8, "white");

        shoe y[] = new shoe[3];
        y[0] = rochelle;
        y[1] = defie;
        y[2] = alison;

        y[1].setBrand("Toms");
        y[1].setColor("gray");
        y[1].setSize(7);


        System.out.println(smartSubstring( "Michael", -1,-4));



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

    public static String reverse(String a) {
        int l = a.length();
        String x;
        String b = "";
        for (int i = l-1 ; i >= 0; i--) {
            int k = i+1;
            x = a.substring(i,k);
            b = b+x;
        }
        return b;
    }

    public static String smartSubstring(String c, int a, int b){
        /* Example: smartSubstring( “Michael”, 1,5) -> Micha
           Example: smartSubstring( “Michael”, -1,-4) -> leah
        */
        if (a < 0) {
            a = c.length() + a;
            b = c.length() + b;
            String x = c.substring(b, a+1);
            return reverse(x);
        }

        else {
            String x = c.substring(a-1, b);
            return x;
        }
    }


}
