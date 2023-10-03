public class rectangle {
    private double length;
    private double width;

    public rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public double getLength() { return length;}
    public double getWidth() { return width;}

    public void setLength(double l){ length = l;}
    public void setWidth(double w){width = w;}

    public double getArea() {
        double area = length * width;
        return area;
    }

    public double getPerimeter() {
        double perimeter = 2*(length) * 2*(width);
        return perimeter;
    }

    public boolean isSquare() {
        boolean square;
        if (length == width) {
            square = true;
            return square;
        }

        else {
            square = false;
            return square;
        }
    }

    public boolean isAreaEqualtoPerimeter() {
        boolean equal;
        if (getArea() == getPerimeter()) {
            equal = true;
            return equal;
        }

        else {
            equal = false;
            return equal;
        }
    }
}
