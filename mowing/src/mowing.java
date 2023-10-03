import java.util.Scanner;

public class mowing {
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        System.out.println("Number of rows");
        int y = pen.nextInt();
        pen.nextLine();
        System.out.println("Number of columns");
        int x = pen.nextInt();
        pen.nextLine();

        String[][] lawn = new String[x][y];

//prints out lawn
        for(int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                lawn[j][i] = " . ";
            }
        }
//prints out random trees
        for(int i = 0; i < y; i++){
            int a = (int) (Math.random() * (x));
            int b = (int) (Math.random() * (y));

            lawn[a][b] = " T ";
        }
//prints out before mowing lawn
        for(int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                System.out.print(lawn[j][i]);
            }
            System.out.println();
        }

        System.out.println("X coord of lawn mower");
        int lawnX = pen.nextInt();
        pen.nextLine();
        System.out.println("Y coord of lawn mower");
        int lawnY = pen.nextInt();
        pen.nextLine();

        boolean stuck = false;

        if (checkFit(lawn, lawnX, lawnY)){
                fill(lawn, lawnX, lawnY);
        }
        else {
            System.out.println("You can't place your lawn mower there!");
            stuck = true;
        }

//prints lawn
        for(int i = 0; i < y; i++){
            for (int j = 0; j < x; j++){
                System.out.print(lawn[j][i]);
            }
            System.out.println();
        }

while(!stuck) {
//filling down
    for (int i = 0; i < y - 2; i++) {
        System.out.println(lawnX + " " + lawnY);
        if (checkFit(lawn, lawnX, lawnY)) {
            System.out.println("filled");
            fill(lawn, lawnX, lawnY);
        }
        for (int j = 0; j < x; j++) {
//filling to the right
            while (lawnX < x - 1 && !stuck) {
                lawnX += 1;
                if (checkFit(lawn, lawnX, lawnY)) {
                    fill(lawn, lawnX, lawnY);
                } else {
                    if (lawnX == 1) {
                        stuck = true;
                    } else {
                        lawnX -= 1;
                        stuck = true;
                    }
                }
            }
            stuck = false;
//filling to the left
            while (lawnX > 1 && !stuck) {
                lawnX -= 1;
                if (checkFit(lawn, lawnX, lawnY)) {
                    fill(lawn, lawnX, lawnY);
                } else {
                    lawnX += 1;
                    stuck = true;
                }
            }
        }
//checks if it can move down
        int testX = lawnX;
        boolean a = true;
        while(testX < x-1 && testX > 0 && a && lawnY < y-1) {
            if (lawnY < y - 2 && checkFit(lawn, testX, lawnY + 1)) {
                lawnX = testX;
                lawnY += 1;
                a = false;
            }
            else{
                System.out.println(testX + " " + lawnY + "+1 doesn't work.");
                testX++;
            }
        }
    }
//prints lawn
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            System.out.print(lawn[j][i]);
        }
        System.out.println();
    }
//filling up
    for (int i = 0; i < y - 1; i++) {
        System.out.println(lawnX + " " + lawnY);
        if (checkFit(lawn, lawnX, lawnY)) {
            fill(lawn, lawnX, lawnY);
        }

        for (int j = 0; j < x; j++) {
            //filling to the left
            while (lawnX > 0 && !stuck) {
                lawnX -= 1;
                if (checkFit(lawn, lawnX, lawnY)) {
                    fill(lawn, lawnX, lawnY);
                } else {
                    if (lawnX == 9) {
                        stuck = true;
                    } else {
                        lawnX += 1;
                        stuck = true;
                    }
                }
            }
//filling to the right
            while (lawnX < x && !stuck) {
                lawnX += 1;
                if (checkFit(lawn, lawnX, lawnY)) {
                    fill(lawn, lawnX, lawnY);
                } else {
                    if (lawnX == 1) {
                        stuck = true;
                    } else {
                        lawnX -= 1;
                        stuck = true;
                    }
                }

            }
            stuck = false;
        }
//check if it can move up
        boolean b = true;
        int testXup = lawnX;
        while(testXup < x-1 && testXup > 0 && lawnY > 1 && b) {
            if (lawnY > 1 && checkFit(lawn, testXup, lawnY - 1)) {
                lawnX = testXup;
                lawnY -= 1;
                b = false;
            }
            else{
                testXup--;
            }
        }
    }
    //prints out lawn
    System.out.println();
    for(int i = 0; i < y; i++){
        for (int j = 0; j < x; j++){
            System.out.print(lawn[j][i]);
        }
        System.out.println();
    }

    stuck = true;
}
    }

    public static boolean checkFit(String[][] lawn, int a, int b){
        boolean result = true;
        int counterx = 0;
        int countery = 0;
        if(a > 0) {
            a--;
        }
        if(b > 0) {
            b--;
        }
        while(counterx < 3 && a < lawn.length && a >= 0) {
            while(countery < 3 && b < lawn[0].length && b >= 0) {
                if (lawn[a][b] == " T ") {
                    result = false;
                    return result;
                }
                b++;
                countery++;
            }
            b = b-3;
            countery = countery-3;
            a++;
            counterx++;
        }
        return result;
    }

    public static void fill(String[][] lawn, int a, int b){
        int counterx = 0;
        int countery = 0;
        if(a > 0) {
            a--;
        }
        if(b > 0) {
            b--;
        }
        while(counterx < 3 && a < lawn.length && a >= 0) {
            while(countery < 3 && b < lawn[0].length && b >= 0) {
                lawn[a][b] = " C ";
                b++;
                countery++;
            }
            countery = countery-3;
            b = b-3;
            a++;
            counterx++;
        }

    }
}
