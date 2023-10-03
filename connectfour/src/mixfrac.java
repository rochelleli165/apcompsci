public class mixfrac {
    private int wNum;
    private frac fraction;
    public mixfrac (int w, frac f) {
        wNum = w;
        fraction = f;
    }
    public mixfrac (int w, int n, int d){
        wNum = w;
        fraction = new frac(n,d);
    }

    //setters
    public void setWhole(int w){
        wNum = w;
    }
    public void setFraction(frac f){
        fraction = f;
    }

    public frac getImproper() {
        int num = wNum * fraction.getDen() + fraction.getNum();
        int den = fraction.getDen();
        frac x = new frac(num, den);
        return x;
    }
}
