import java.util.*;
public class tictactoe {
    public static void main (String[] args)
    {
        System.out.println("Welcome to Tic-Tac-Toe");
        boolean progress = true;
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";
        String five = "5";
        String six = "6";
        String seven = "7";
        String eight = "8";
        String nine = "9";
        int i = 0; //to tell whose turn it is
        int s = 0; //to calculate stalemate
        while (progress == true) {

            System.out.println(one + "|" + two + "|" + three);  //format of tic tac toe
            System.out.println("=====");
            System.out.println(four + "|" + five + "|" + six);
            System.out.println("=====");
            System.out.println(seven + "|" + eight + "|" + nine);

            Scanner pen = new Scanner(System.in);
            int choose;  //int player 1 and 2 enters
                if (i % 2 == 0) {  //player 1 has a turn with evens, player 2 is odds
                    System.out.println("Player 1 pick a number.");
                    choose = pen.nextInt();
                    pen.nextLine();
                    if (choose == 1) {
                        one = "O";
                    }
                    else if (choose == 2) {
                        two = "O";
                    }
                    else if (choose == 3) {
                        three = "O";
                    }
                    else if (choose == 4) {
                        four = "O";
                    }
                    else if (choose == 5) {
                        five = "O";
                    }
                    else if (choose == 6) {
                        six = "O";
                    }
                    else if (choose == 7) {
                        seven = "O";
                    }
                    else if (choose == 8) {
                        eight = "O";
                    }
                    else if (choose == 9) {
                        nine = "O";
                    }
                i++;
                }
                else {
                    System.out.println("Player 2 pick a number.");
                    choose = pen.nextInt();
                    pen.nextLine();
                    if (choose == 1) {
                        one = "X";
                    }
                    else if (choose == 2) {
                        two = "X";
                    }
                    else if (choose == 3) {
                        three = "X";
                    }
                    else if (choose == 4) {
                        four = "X";
                    }
                    else if (choose == 5) {
                        five = "X";
                    }
                    else if (choose == 6) {
                        six = "X";
                    }
                    else if (choose == 7) {
                        seven = "X";
                    }
                    else if (choose == 8) {
                        eight = "X";
                    }
                    else if (choose == 9) {
                        nine = "X";
                    }
                    i++;
                }

                if (one == two && two == three) {  //total of eight combinations to check
                    if (i % 2 == 1) { //to check who wins based on i (which numbered turn)
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }

             else if (four == five && five == six) {
                if (i % 2 == 1) {
                    System.out.println("Player One Wins.");
                    progress = false;
                }
                else {
                    System.out.println("Player Two Wins.");
                    progress = false;
                }
            }

                else if (seven == eight && eight == nine) {
                    if (i % 2 == 1) {
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }


                else if (one == four && four == seven) {
                    if (i % 2 == 1) {
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }

                else if (two == five && five == eight) {
                    if (i % 2 == 1) {
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }

                else if (three == six && six == nine) {
                    if (i % 2 == 1) {
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }

                else if (one == five && five == nine) {
                    if (i % 2 == 1) {
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }

                else if (three == five && five == seven) {
                    if (i % 2 == 1) {
                        System.out.println("Player One Wins.");
                        progress = false;
                    }
                    else {
                        System.out.println("Player Two Wins.");
                        progress = false;
                    }
                }

                s++; //if nothing, check how many times program has run. If ran nine times, then Stalemate
                if (s == 9) {
                    System.out.println("Stalemate");
                    progress = false;
                }

        }


    }


}
