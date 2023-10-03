public class interface1 implements MSJstuff {

    public void displaylhospitalRule(){
        System.out.println("an indeterminate form 0/0 or ∞/∞ all we need to do is differentiate the numerator and differentiate the denominator and then take the limit.");
    }

    public boolean isLiu( String x ) {
        boolean isliu;
        if (x == "Liu") {
            isliu = true;
            return isliu;
        }
        else {
            isliu = false;
            return isliu;
        }
    }
    public int round (double a ) {
        int x = (int) a;
        double decimal = a-x;
        if (decimal >= 0.5) {
            return (int) a + 1;
        }
        else {
            return (int) a;
        }
    }


}
