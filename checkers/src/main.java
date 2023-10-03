import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        piece[][] board = new piece[8][8];
        //setting the board up first
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < 8; j = j + 2) {
                    board[i][j] = new piece(j, i, "black", false);
                }
                for (int j = 1; j < 8; j = j + 2) {
                    board[i][j] = new piece();
                }
            } else if (i == 1) {
                for (int j = 1; j < 8; j = j + 2) {
                    board[i][j] = new piece(j, i, "black", false);
                }
                for (int j = 0; j < 8; j = j + 2) {
                    board[i][j] = new piece();
                }
            } else if (i == 6) {
                for (int j = 0; j < 8; j = j + 2) {
                    board[i][j] = new piece(j, i, "red", false);
                }
                for (int j = 1; j < 8; j = j + 2) {
                    board[i][j] = new piece();
                }
            } else if (i == 5 || i == 7) {
                for (int j = 1; j < 8; j = j + 2) {
                    board[i][j] = new piece(j, i, "red", false);
                }
                for (int j = 0; j < 8; j = j + 2) {
                    board[i][j] = new piece();
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = new piece();
                }
            }
        }
        int turn = 0;
        boolean progress = true;
        while (progress) {
            printboard(board);
            if(turn % 2 == 0) {
                System.out.println("Red's turn.");
            }
            else {
                System.out.println("Black's turn.");
            }
            checkvalidpiece(turn, board);
            checkking(board);
            turn++;
            progress = readwin(board);

        }
    }

    public static void printboard(piece[][] board) {
        //printing out the board
        System.out.println("--0----1----2----3----4----5----6----7--");
        for (int i = 0; i < 8; i++) {
            System.out.println("----------------------------------------");
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                if (board[i][j].getType() == "red" && !board[i][j].kingStatus()) {
                    System.out.print(" r ");
                }
                else if (board[i][j].getType() == "red" && board[i][j].kingStatus()) {
                    System.out.print(" R ");
                }
                else if (board[i][j].getType() == "black" && !board[i][j].kingStatus()) {
                    System.out.print(" b ");
                }
                else if (board[i][j].getType() == "black" && board[i][j].kingStatus()) {
                    System.out.print(" B ");
                }
                else {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.print(" " + i);
            System.out.println();
        }
        System.out.println("----------------------------------------");

    }

    public static void checkvalidpiece(int turn, piece[][] board){
        Scanner pen = new Scanner(System.in);
        System.out.println("Choose the piece you want to move");
        System.out.println("Enter x coordinate");
        int x;
        x = pen.nextInt();
        pen.nextLine();
        System.out.println("Enter y coordinate");
        int y;
        y = pen.nextInt();
        pen.nextLine();
        if (turn % 2 == 0) {
            if(board[y][x].getType() != "red"){
                System.out.println("Invalid piece");
                checkvalidpiece(turn, board);
            }
            else {
                movepiece(x, y, turn, board);
            }
        }
        else if (turn % 2 == 1) {
            if(board[y][x].getType() != "black"){
                System.out.println("Invalid piece");
                checkvalidpiece(turn, board);
            }
            else {
                movepiece(x, y, turn, board);
            }
        }
    }

    public static void movepiece(int x, int y, int turn, piece[][] board){
        Scanner pen = new Scanner(System.in);
        System.out.println("Choose the place where you want to move the piece");
        System.out.println("Enter new x coordinate");
        int newx;
        newx = pen.nextInt();
        pen.nextLine();
        System.out.println("Enter new y coordinate");
        int newy;
        newy = pen.nextInt();
        pen.nextLine();


        if(board[newy][newx].getType() != "red" && board[newy][newx].getType() != "black" && isvalidmove(x, y, newx, newy, turn, board) ) {
            board[y][x].setX(0);
            board[y][x].setY(0);
            board[y][x].setType("blue");

            if(board[y][x].kingStatus()){
                board[newy][newx].makeKing(true);
                board[y][x].makeKing(false);
            }

            board[newy][newx].setX(newx);
            board[newy][newx].setY(newy);

            if (turn % 2 == 0) {
                board[newy][newx].setType("red");
            }
            else if (turn % 2 == 1) {
                board[newy][newx].setType("black");
            }
        }
        else {
            System.out.println("Invalid move");
            checkvalidpiece(turn, board);
        }

        doubleeatcheck(newx, newy, turn, board);
    }

    public static boolean isvalidmove(int x, int y, int newx, int newy, int turn, piece[][] board) {
        boolean isvalid;
        if(!board[y][x].kingStatus()) {
            if (board[y][x].getType() == "red" && newy == y - 1 && (newx == x + 1 || newx == x - 1)) {
                isvalid = true;
                return isvalid;
            }

            else if(board[y][x].getType() == "black" && newy == y + 1 && (newx == x + 1 || newx == x - 1)) {
                isvalid = true;
                return isvalid;
            }
            else if (caneat(x, y, newx, newy, turn, board)){
                caneliminate(x, y, newx, newy, board);
                isvalid = true;
                return isvalid;
            }
            else {
                isvalid = false;
                return isvalid;
            }
        }
        else if(board[y][x].kingStatus()){
            if (board[y][x].getType() == "red" && newy == y - 1 && (newx == x + 1 || newx == x - 1)) {
                isvalid = true;
                return isvalid;
            }

            else if(board[y][x].getType() == "black" && newy == y + 1 && (newx == x + 1 || newx == x - 1)) {
                isvalid = true;
                return isvalid;
            }
            else if (board[y][x].getType() == "red" && newy == y + 1 && (newx == x + 1 || newx == x - 1)) {
                isvalid = true;
                return isvalid;
            }

            else if(board[y][x].getType() == "black" && newy == y - 1 && (newx == x + 1 || newx == x - 1)) {
                isvalid = true;
                return isvalid;
            }
            else if (caneat(x, y, newx, newy, turn, board)){
                caneliminate(x, y, newx, newy, board);
                isvalid = true;
                return isvalid;
            }
            else {
                isvalid = false;
                return isvalid;
            }
        }
        else {
            isvalid = false;
            return isvalid;
        }
    }
    public static boolean caneat(int x, int y, int newx, int newy, int turn, piece[][] board){
        boolean caneat;
        if(y-2 < 8 && x-2 > 0 && turn % 2 == 0 && board[y-1][x-1].getType() == "black" && board[y-2][x-2].getType() == "blue" && board[y-2][x-2] == board[newy][newx]) {
            caneat = true;
            return caneat;
        }
        else if(x+2 < 8 && turn % 2 == 0 && board[y-1][x+1].getType() == "black" && board[y-2][x+2].getType() == "blue" && board[y-2][x+2] == board[newy][newx]) {
            caneat = true;
            return caneat;
        }

         else if(y+2 < 8 && x-2 > 0 && turn % 2 == 1 && board[y+1][x-1].getType() == "red" && board[y+2][x-2].getType() == "blue" && board[y+2][x-2] == board[newy][newx]) {
            caneat = true;
            return caneat;
        }
        else if(x+2 < 8 && y+2 < 8 && turn % 2 == 1 && board[y+1][x+1].getType() == "red" && board[y+2][x+2].getType() == "blue" && board[y+2][x+2] == board[newy][newx]) {
            caneat = true;
            return caneat;
        }
        else if(board[y][x].kingStatus()){
            if(y+2 < 8 && x-2 > 0 && turn % 2 == 0 && board[y+1][x-1].getType() == "black" && board[y+2][x-2].getType() == "blue" && board[y+2][x-2] == board[newy][newx]) {
                caneat = true;
                return caneat;
            }
            else if(x+2 < 8 && y+2 < 8 && turn % 2 == 0 && board[y+1][x+1].getType() == "black" && board[y+2][x+2].getType() == "blue" && board[y+2][x+2] == board[newy][newx]) {
                caneat = true;
                return caneat;
            }

            else if(y-2 > 0 && x-2 > 0 && turn % 2 == 1 && board[y-1][x-1].getType() == "red" && board[y-2][x-2].getType() == "blue" && board[y-2][x-2] == board[newy][newx]) {
                caneat = true;
                return caneat;
            }
            else if(x+2 < 8 && y-2 > 0 && turn % 2 == 1 && board[y-1][x+1].getType() == "red" && board[y-2][x+2].getType() == "blue" && board[y-2][x+2] == board[newy][newx]) {
                caneat = true;
                return caneat;
            }
            else {
                caneat = false;
                return caneat;
            }
        }
        else {
            caneat = false;
            return caneat;
        }
    }

    public static void caneliminate(int x, int y, int newx, int newy, piece[][] board){
        board[(y+newy)/2][(x+newx)/2].setType("blue");
        board[(y+newy)/2][(x+newx)/2].setX(0);
        board[(y+newy)/2][(x+newx)/2].setY(0);
    }

    public static void doubleeatcheck(int newx, int newy, int turn, piece[][] board){
        Scanner pen = new Scanner(System.in);
        if(newx+2 < 8 && newy+2 < 8 && turn % 2 == 1 && board[newy+1][newx+1].getType() == "red" && board[newy+2][newx+2].getType() == "blue") {
            System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
            int choice;
            choice = pen.nextInt();
            pen.nextLine();
            if (choice == 1) {
                movepiece(newx, newy, turn, board);
            }
        }
        else if(newy+2 < 8 && newx-2 > 0 && turn % 2 == 1 && board[newy+1][newx-1].getType() == "red" && board[newy+2][newx-2].getType() == "blue") {
            System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
            int choice;
            choice = pen.nextInt();
            pen.nextLine();
            if (choice == 1) {
                movepiece(newx, newy, turn, board);
            }
        }
        else if(newx+2 < 8 && newy-2 > 0 && turn % 2 == 0 && board[newy-1][newx+1].getType() == "black" && board[newy-2][newx+2].getType() == "blue") {
            System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
            int choice;
            choice = pen.nextInt();
            pen.nextLine();
            if (choice == 1) {
                movepiece(newx, newy, turn, board);
            }
        }
        else if(newx - 2 > 0 && newy-2 > 0 && turn % 2 == 0 && board[newy-1][newx-1].getType() == "black" && board[newy-2][newx-2].getType() == "blue") {
            System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
            int choice;
            choice = pen.nextInt();
            pen.nextLine();
            if (choice == 1) {
                movepiece(newx, newy, turn, board);
            }
        }
        else if(board[newy][newx].kingStatus()){
            if(newx+2 < 8 && newy-2 > 0 && turn % 2 == 1 && board[newy-1][newx+1].getType() == "red" && board[newy-2][newx+2].getType() == "blue") {
                System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
                int choice;
                choice = pen.nextInt();
                pen.nextLine();
                if (choice == 1) {
                    movepiece(newx, newy, turn, board);
                }
            }
            else if(newy-2 > 0 && newx-2 > 0 && turn % 2 == 1 && board[newy-1][newx+1].getType() == "red" && board[newy-2][newx-2].getType() == "blue") {
                System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
                int choice;
                choice = pen.nextInt();
                pen.nextLine();
                if (choice == 1) {
                    movepiece(newx, newy, turn, board);
                }
            }
            else if(newx+2 < 8 && newy+2 < 8 && turn % 2 == 0 && board[newy+1][newx+1].getType() == "black" && board[newy+2][newx+2].getType() == "blue") {
                System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
                int choice;
                choice = pen.nextInt();
                pen.nextLine();
                if (choice == 1) {
                    movepiece(newx, newy, turn, board);
                }
            }
            else if(newy+2 < 8 && newx-2 > 0 && turn % 2 == 0 && board[newy+1][newx+1].getType() == "black" && board[newy+2][newx-2].getType() == "blue") {
                System.out.println("You can eat again. Do you want to? 1. Yes 2. No");
                int choice;
                choice = pen.nextInt();
                pen.nextLine();
                if (choice == 1) {
                    movepiece(newx, newy, turn, board);
                }
            }
        }
    }

    public static boolean readwin(piece[][] board){
        int counterred = 0;
        int counterblack = 0;
        boolean readwin;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getType() == "red") {
                    counterred++;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getType() == "black") {
                    counterblack++;
                }
            }
        }

        if(counterred == 0) {
            System.out.println("Black wins.");
            readwin = false;
            return readwin;
        }
        else if (counterblack == 0){
            readwin = false;
            return readwin;
        }
        else {
            readwin = true;
            return readwin;
        }
    }

    public static void checkking(piece[][] board){
        for(int i = 0; i < 8; i++){
            if(board[0][i].getType() == "red") {
                System.out.println("King Piece. Promoted!");
                board[0][i].makeKing(true);
            }
        }
        for(int i = 0; i < 8; i++){
            if(board[7][i].getType() == "black") {
                board[7][i].makeKing(true);
            }
        }

    }


}
