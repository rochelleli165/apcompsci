public class piece {
    //attributes
    private int xCor;
    private int yCor;
    private String type;
    private boolean king;

    public piece()
    {
        xCor = 0;
        yCor = 0;
        king = false;
        type = "blue";
    }

    public piece( int x, int y, String t, boolean b)
    {
        xCor = x;
        yCor = y;
        type = t;
        king = b;
    }

    public int getX()
    {
        return xCor;
    }

    public int getY()
    {
        return yCor;
    }

    public boolean kingStatus()
    {
        return king;
    }

    public String getType() { return type;}

    public void setX(int x)
    {
        xCor = x;
    }

    public void setY(int y)
    {
        yCor = y;
    }

    public void makeKing(boolean k)
    {
        king = k;
    }

    public void setType(String t) { type = t;}



}
