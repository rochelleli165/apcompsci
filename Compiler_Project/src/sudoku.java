import java.util.*;
public class sudoku {
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        int newRow;
        String cases = pen.nextLine();
        newRow = pen.nextInt();
        pen.nextLine();
        System.out.println();
        boolean solve;
        for(int i = 0; i < Integer.parseInt(cases); i++){
            int[][] board = new int[9][9];
            for(int j = 0; j < 9; j++) {
                String newLine = pen.nextLine();
                for (int k = 0; k < 9; k++) {
                    board[j][k] = Integer.parseInt(newLine.substring(0, 1));
                    if(newLine.length() >= 2) {
                        newLine = newLine.substring(2);
                    }
                }
            }
            display(board);
            boolean horsolve;
            boolean versolve;
            boolean squaresolve;
            //horizontal solving
            for(int l = 0; l < 9; l++){
                int[] row = new int[9];
                for(int m = 0; m < 9; m++){
                    board[l][m] = row[m];
                }
                if(solveNine(row)){
                    horsolve = true;
                }
                else{
                    horsolve = false;
                }

            }
            //vertical solving
            for(int n = 0; n < 9; n++){
                int[] col = new int[9];
                for(int o = 0; o < 9; o++){
                    board[o][n] = col[o];
                }
                if(solveNine(col)){
                    versolve = true;
                }
                else{
                    versolve = false;
                }

            }
            //square solving
            for(int q = 0; q < 9; q+=3){
                int[] square = new int[9];
                for(int r = 0; r < 9; r+=3){
                    int z = 0;
                    for(int x = 0; x < 3; x++){
                        for(int y = 0; y < 3; y++) {
                            square[z] = board[q][r];
                            z++;
                            q++;

                        }
                        q -= 3;
                        r++;
                    }
                    r-=3;
                }
                display(square);
            }

        }



    }
    public static void display(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void display(int[] board){
        System.out.println();
        for(int i = 0; i < 9; i++){
            System.out.print(board[i]);
        }
        System.out.println();
    }

    public static boolean solveNine(int[] group){
        boolean progress;
        boolean[] key = new boolean[9];
        for(int j = 0; j < 9; j++){
            key[j] = false;
        }
        for(int i = 0; i < 10; i++){

            if (group[i] < 10 && key[group[i]] == false){
                key[i] = true;
            }
            else{
                return false;
            }
        }
        progress = true;
        return progress;
    }


}
