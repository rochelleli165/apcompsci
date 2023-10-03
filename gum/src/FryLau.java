import java.util.Scanner;

//when doing math with ints/doubles, java will default to doubles

// casting
//int a = 9
//double b = (double) a
//double c = 4.9;
//int d = (int) c; so c is 4 and not 4.9

public class FryLau {
    public static void main(String[] args) {
        Scanner pen = new Scanner(System.in);
        int a ;
        a = pen.nextInt();
        pen.nextLine();

        int b ;
        b = pen.nextInt();
        pen.nextLine();

        int c ;
        c = pen.nextInt();
        pen.nextLine();

        int d ;
        d = pen.nextInt();
        pen.nextLine();

        int e ;
        e = pen.nextInt();
        pen.nextLine();

        int f ;
        f = pen.nextInt();
        pen.nextLine();

        int g ;
        g = pen.nextInt();
        pen.nextLine();

        mean(a, b, c, d, e, f, g);
        mode(a, b, c, d, e, f, g);
        median(a, b, c, d, e, f, g);

    }

    public static void mean(int a, int b, int c, int d, int e, int f, int g) {
        double mean = (a+b+c+d+e+f+g)/7;
        System.out.println(mean);
    }

    public static void median(int a, int b, int c, int d, int e, int f, int g) {

        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;

        if (a >= b)
            count++;
        if (a >= c)
            count++;
        if (a >= d)
            count++;
        if (a >= e)
            count++;
        if (a >= f)
            count++;
        if (a >= g)
            count++;

        if (b >= a)
            count1++;
        if (b >= c)
            count1++;
        if (b >= d)
            count1++;
        if (b >= e)
            count1++;
        if (b >= f)
            count1++;
        if (b >= g)
            count1++;

        if (c >= a)
            count2++;
        if (c >= b)
            count2++;
        if (c >= d)
            count2++;
        if (c >= e)
            count2++;
        if (c >= f)
            count2++;
        if (c >= g)
            count2++;

        if (d >= a)
            count3++;
        if (d >= b)
            count3++;
        if (d >= c)
            count3++;
        if (d >= e)
            count3++;
        if (d >= f)
            count3++;
        if (d >= g)
            count3++;

        if (e >= a)
            count4++;
        if (e >= b)
            count4++;
        if (e >= c)
            count4++;
        if (e >= d)
            count4++;
        if (e >= f)
            count4++;
        if (e >= g) {
            count4++;
        }
        if (f >= a)
            count5++;
        if (f >= b)
            count5++;
        if (f >= c)
            count5++;
        if (f >= d)
            count5++;
        if (f >= e)
            count5++;
        if (f >= g) {
            count5++;
        }

        if (g >= a)
            count6++;
        if (g >= b)
            count6++;
        if (g >= c)
            count6++;
        if (g >= d)
            count6++;
        if (g >= e)
            count6++;
        if (g >= f) {
            count6++;
        }



        if (count == 3) {
            System.out.println(a);
        }
        else if (count1 == 3) {
            System.out.println(b);
        }
        else if (count2 == 3) {
            System.out.println(c);
        }
        else if (count3 == 3) {
            System.out.println(d);
        }
        else if (count4 == 3) {
            System.out.println(e);
        }
        else if (count5 == 3) {
            System.out.println(f);
        }
        else if (count6 == 3) {
            System.out.println(g);
        }
    }
    public static void mode(int a, int b, int c, int d, int e, int f, int g) {
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

            if (a == b)
                count++;
            if (a == c)
                count++;
            if (a == d)
                count++;
            if (a == e)
                count++;
            if (a == f)
                count++;
            if (a == g)
                count++;
            if (b == c)
                count1++;
            if (b == d)
                count1++;
            if (b == e)
                count1++;
            if (b == f)
                count1++;
            if (b == g)
                count1++;
            if (c == d)
                count2++;
            if (c == e)
                count2++;
            if (c == f)
                count2++;
            if (c == g)
                count2++;
            if (d == e)
                count3++;
            if (d == f)
                count3++;
            if (d == g)
                count3++;
            if (e == f)
                count4++;
            if (e == g)
                count4++;
            if (f == g)
                count5++;



        if (count == 0 && count1 == 0 && count2 == 0 && count3 == 0 && count4 == 0 && count5 == 0) {
            System.out.println("No Mode");
        } else {

            if (count >= count1 && count >= count2 && count >= count3 && count >= count4 && count >= count5) {
                System.out.println(a);
            }
            if (count1 >= count && count1 >= count2 && count1 >= count3 && count1 >= count4 && count1 >= count5) {
                System.out.println(b);
            }
            if (count2 >= count && count2 >= count1 && count2 >= count3 && count2 >= count4 && count2 >= count5) {
                System.out.println(c);
            }
            if (count3 >= count && count3 >= count1 && count3 >= count2 && count3 >= count4 && count3 >= count5) {
                System.out.println(d);
            }
            if (count4 >= count && count4 >= count1 && count4 >= count2 && count4 >= count3 && count4 >= count5) {
                System.out.println(e);
            }
            if (count5 >= count && count5 >= count1 && count5 >= count2 && count5 >= count3 && count5 >= count4) {
                System.out.println(f);
            }

        }


    }

}

