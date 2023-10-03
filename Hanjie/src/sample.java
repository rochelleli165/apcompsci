import java.util.*;
public class sample {
    public static void main(String[] args){
        String[][] board = new String[3][4];
        int[][] column = new int[4][2];
        int[][] row = new int[3][2];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                board[i][j] = ".";
            }
        }
//list of inputted data
        column[0][0] = 0;
        column[0][1] = 2;
        column[1][0] = 1;
        column[1][1] = 1;
        column[2][0] = 0;
        column[2][1] = 3;
        column[3][0] = 0;
        column[3][1] = 1;

        row[0][0] = 0;
        row[0][1] = 2;
        row[1][0] = 1;
        row[1][1] = 1;
        row[2][0] = 0;
        row[2][1] = 4;

//creates node tree
        ArrayList<node> coordinates = findcoordinates(row, 0);
//set parents
        for(node i : coordinates){
            for(node j : i.getLeaves()){
                j.setParent(i);
            }
        }
        solve(board, row, 0, column, coordinates);







    }
    public static ArrayList<node> findcoordinates(int[][] row, int row_index) {
        ArrayList<node> coordinates = new ArrayList<node>();

        int a = row[row_index][0];
        int b = row[row_index][1];
        int total = a + b;
        int start = 0;
        int space = 2;
//when two values in row data
        while (total <= 4 && a != 0) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            if (start + space < 4) {
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
        }
//when only one value in row data
        while (total <= 4 && a == 0) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            x.add(start);
            node node = new node(x, row_index);
            coordinates.add(node);
            start++;
            total++;
        }
//setting leaves
        if(row_index != 2){
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
        if(row_index == 3){
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
                        solve(board, row, 3, col, coordinates);
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

    public static void display(String[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void reset(String[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                board[i][j] = ".";
            }
        }
    }
    public static  void resetrow(String[][] board, int row_index){
        for(int i = 0; i < 4; i++){
            board[row_index][i] = ".";
        }
    }

    public static void fillrow(String[][] board, int[][] row, int row_index,  node node){

        for (int j = 0; j < node.getPoints().size(); j++) { //the size of combination, for each number inside
            int num_x;
            if (row[row_index][0] != 0) {
                num_x = row[row_index][0];
            }
            else {
                num_x = row[row_index][1];
            }
            int a = node.getPoints().get(j);
            for (int i = 0; i < num_x; i++) {
                board[row_index][i + a] = "X";
            }
        }
    }
    public static boolean perfect(String[][] board, int[][] col){
            int j = 0;
            while(j < 4){ //for each column
                int x_counter = 0;
                int col_index = 1;
                for(int i = 0; i < 3; i++) { //for each number in column
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
                    else if (i == 2 && x_counter != 0) {
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
