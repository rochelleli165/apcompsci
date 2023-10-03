import java.util.Scanner;

public class connectfour {
    public static void main(String[] args) {
       Scanner pen = new Scanner(System.in);
        String[][] board = new String[7][6];
        boolean progress = true;

        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 6; j++) {
                board[i][j] = "0 ";
            }
        }


        while (progress) {
            int x = 0;
            boolean status = true;
            while(x < 42 && status) {

                for(int i = 0; i < 7; i++) {
                    for(int j = 0; j < 6; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("Number of int 0-5");
                int num;
                num = pen.nextInt();
                pen.nextLine();
                boolean check = true;
                int y = 6;
                while(check){
                    if (y == -1) {
                        System.out.println("No more space left!");
                        check = false;
                    }
                    if(board[y][num] == "0 ") {
                        String p;
                        if (x % 2 == 0) {
                            p = "R ";
                            board[y][num] = p;
                            check = false;
                        }

                        else if (x % 2 == 1) {
                            p = "Y ";
                            board[y][num] = p;
                            check = false;
                        }
                    }
                    else if(board[y][num] != "0 ") {
                        y--;
                    }
                }

                //horizontal check
                for(int i = 0; i < 7; i++) {
                    for( int j = 0; j < 3; j++) {
                        if (board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3] && board[i][j] != "0 "){
                            System.out.println("game over");
                            if (x % 2 == 0) {
                                System.out.println("red wins");
                            }

                            else if (x % 2 == 1) {
                               System.out.println("yellow wins");
                            }
                            progress = false;
                            status = false;
                        }
                    }
                }
                //vertical check
                for(int i = 0; i < 6; i++) {
                    for( int j = 0; j < 4; j++) {
                        if (board[j][i] == board[j+1][i] && board[j+1][i] == board[j+2][i] && board[j+2][i] == board[j+3][i] && board[j][i] != "0 "){
                            System.out.println("game over");
                            if (x % 2 == 0) {
                                System.out.println("red wins");
                            }

                            else if (x % 2 == 1) {
                                System.out.println("yellow wins");
                            }
                            progress = false;
                            status = false;
                        }
                    }
                }
                //diagonal check 1
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j< 4; j++) {
                        if(board[j][i] == board[j+1][i+1] && board[j+2][i+2] == board[j+1][i+1] && board[j+2][i+2] == board[j+3][i+3] && board[j][i] != "0 ") {
                            System.out.println("game over");
                            if (x % 2 == 0) {
                                System.out.println("red wins");
                            }

                            else if (x % 2 == 1) {
                                System.out.println("yellow wins");
                            }
                            progress = false;
                            status = false;
                        }
                    }
                }
                //diagonal check 2
                for(int i = 5; i > 3; i--) {
                    for(int j = 0; j < 4; j++) {
                        if(board[j][i] == board[j+1][i-1] && board[j+2][i-2] == board[j+1][i-1] && board[j+2][i-2] == board[j+3][i-3] && board[j][i] != "0 ") {
                            System.out.println("game over");
                            if (x % 2 == 0) {
                                System.out.println("red wins");
                            }

                            else if (x % 2 == 1) {
                                System.out.println("yellow wins");
                            }
                            progress = false;
                            status = false;
                        }
                    }
                }
                x++;
            }
        }
    }
}
