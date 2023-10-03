public class Number {
    private int value;
    private Number Left;
    private Number Right;
    public Number(int v){
        value = v;
        Left = null;
        Right = null;
    }
    public int getValue(){
        return value;
    }
    public Number getLeft(){
        return Left;
    }
    public Number getRight(){
        return Right;
    }
    public void setValue(int v){
        value = v;
    }
    public void setLeft(Number l){
        Left = l;
    }
    public void setRight(Number r){
        Right = r;
    }


}
