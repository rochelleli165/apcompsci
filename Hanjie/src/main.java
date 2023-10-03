import java.util.*;
public class main {
    public static void main(String[] args) {
        String[][] board = new String[10][10];
        int[][] col = new int[10][3];
        int[][] row = new int[10][3];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = ".";
            }
        }
//input data for row
        row[0][0] = 1;
        row[0][1] = 4;
        row[0][2] = 1;
        row[1][0] = 1;
        row[1][1] = 4;
        row[1][2] = 1;
        row[2][0] = 1;
        row[2][1] = 2;
        row[2][2] = 1;
        row[3][0] = 0;
        row[3][1] = 0;
        row[3][2] = 2;
        row[4][0] = 0;
        row[4][1] = 0;
        row[4][2] = 2;
        row[5][0] = 0;
        row[5][1] = 0;
        row[5][2] = 0;
        row[6][0] = 0;
        row[6][1] = 0;
        row[6][2] = 4;
        row[7][0] = 0;
        row[7][1] = 6;
        row[7][2] = 1;
        row[8][0] = 0;
        row[8][1] = 0;
        row[8][2] = 8;
        row[9][0] = 0;
        row[9][1] = 0;
        row[9][2] = 10;
//input data for col
        col[0][0] = 0;
        col[0][1] = 3;
        col[0][2] = 1;
        col[1][0] = 0;
        col[1][1] = 0;
        col[1][2] = 2;
        col[2][0] = 0;
        col[2][1] = 0;
        col[2][2] = 3;
        col[3][0] = 0;
        col[3][1] = 2;
        col[3][2] = 4;
        col[4][0] = 0;
        col[4][1] = 5;
        col[4][2] = 4;
        col[5][0] = 0;
        col[5][1] = 5;
        col[5][2] = 4;
        col[6][0] = 0;
        col[6][1] = 2;
        col[6][2] = 4;
        col[7][0] = 0;
        col[7][1] = 0;
        col[7][2] = 3;
        col[8][0] = 0;
        col[8][1] = 0;
        col[8][2] = 2;
        col[9][0] = 3;
        col[9][1] = 1;
        col[9][2] = 1;

//creates node tree
        ArrayList<node> coordinates = findcoordinates(row, 0);
//set parents
        for(node i : coordinates){
            for(node j : i.getLeaves()){
                j.setParent(i);
            }
        }
        solve(board, row, 0, col, coordinates);
        System.out.println("solved");
    }





    public static ArrayList<node> findcoordinates(int[][] row, int row_index) {
        ArrayList<node> coordinates = new ArrayList<node>();
        int a = row[row_index][0];
        int b = row[row_index][1];
        int c = row[row_index][2];
        int total = a + b + c;
        int start = 0;
        int space = 2;
        int second_space = 2;
//with three values in row data
        while ( total <= 10 && b != 0){
            ArrayList<Integer> x = new ArrayList<Integer>();
            if(start + space + second_space < 10){
                x.add(start);
                x.add(start + space);
                if(a != 0) {
                    x.add(start + space * second_space);
                    total++;
                }
                node node = new node(x, row_index);
                coordinates.add(node);
            }
            else{
                start = 0;
                space++;
                x.add(start);
                x.add(start + space);
                node node = new node(x, row_index);
                coordinates.add(node);
            }
            start++;
            total++;
        }
//when two values in row data *done*
      /*  while (total <= 10 && a == 0 && b != 0) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            if (start + space < 10) {
                x.add(start);
                x.add(start + space);
                node node = new node(x, row_index);
                coordinates.add(node);
            }
            else {
                start = 0;
                space++;
                x.add(start);
                x.add(start + space);
                node node = new node(x, row_index);
                coordinates.add(node);
            }
            start++;
            total++;
        } */
//when only one value in row data *done*
        while (total <= 10 && a == 0 && b == 0) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            x.add(start);
            node node = new node(x, row_index);
            coordinates.add(node);
            start++;
            total++;
        }
//setting leaves *done*
        if(row_index != 9){
            row_index++;
            for(node i : coordinates){
                i.setLeaves(findcoordinates(row, row_index));
                for(node j : findcoordinates(row, row_index)){
                    j.setParent(i);
                }
            }
        }
        return coordinates;
    }

    public static void solve(String[][] board, int[][] row, int row_index, int[][] col, ArrayList<node> coordinates){
        if(row_index == 10){
            if(perfect(board, col)){
                display(board);
                System.out.println();
            }
            else{

            }
        }
        else{
            for(node i : coordinates){
                if(!i.getVisited()) {
                    row_index = i.getLevel();
                    resetrow(board, row_index);
                    fillrow(board, row, row_index, i);

                    //if reaches end or reaches a node where all children are visited already

                    if(i.getLeaves() == null){
                        i.setVisited(true);
                        solve(board, row, 10, col, coordinates);
                    }
                    else if(i.getLeaves().get(i.getLeaves().size() - 1).getVisited()){
                        i.setVisited(true);
                        resetrow(board, row_index);
                    }
                    else {
                        solve(board, row, row_index, col, i.getLeaves());
                    }

                }

            }
        }
    }
//fills row according to start points and row data *maybe done*
    public static void fillrow(String[][] board, int[][] row, int row_index,  node node){

        for (int j = 0; j < node.getPoints().size(); j++) { //the size of combination, for each number inside
            int index = 0;
            int num_x;

            while(index < 3){
                if(row[row_index][index] == 0 && index != 2) {
                    index++;
                }
                num_x = row[row_index][index];
                int a = node.getPoints().get(j);
                for (int i = 0; i < num_x; i++) {
                    board[row_index][i + a] = "X";
                }
                index++;
            }

        }
    }
//prints board *done*
    public static void display(String[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
//resets row of board back to "." *done*
    public static  void resetrow(String[][] board, int row_index){
        for(int i = 0; i < 10; i++){
            board[row_index][i] = ".";
        }
    }
//verifies all combinations and finds correct solution *maybe done*
    public static boolean perfect(String[][] board, int[][] col){
        display(board);
        int j = 0;
        while(j < 10){ //for each column
            System.out.println("Column number: " + j);
            int x_counter = 0;
            int col_index = 2; //starting with non-zero data value
            for(int i = 0; i < 10; i++) { //for each number in column
                if (board[i][j] == "X") {
                    x_counter++;
                }
                if (board[i][j] == "." && x_counter != 0) {
                    if (x_counter == col[j][col_index]) {
                        x_counter = 0;
                        col_index--;
                    }
                    else {
                        return false;
                    }
                }
                else if (i == 9 && x_counter != 0) {
                    if (x_counter == col[j][col_index]) {
                        x_counter = 0;
                    }
                    else {
                        return false;
                    }
                }
            }
            j++;
        }
        return true;
    }


}


