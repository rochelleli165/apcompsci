import java.util.*;
public class main {
    public static void main(String[] args){
        Scanner pen = new Scanner(System.in);
        ArrayList<card> deck = new ArrayList<card>();
        deck d = new deck(deck);
        for(int i = 1; i < 14; i++){
            card x = new card (i, "Spades");
            deck.add(x);
        }
        for(int i = 1; i < 14; i++){
            card x = new card (i, "Hearts");
            deck.add(x);
        }
        for(int i = 1; i < 14; i++){
            card x = new card (i, "Diamonds");
            deck.add(x);
        }
        for(int i = 1; i < 14; i++){
            card x = new card (i, "Clovers");
            deck.add(x);
        }

        d.shuffle(deck);
        System.out.println(deck);

        boolean bankrupt = false;
        boolean progress = true;
        player one = new player(500, "Sally");
        player dealer = new player(500, "Dealer");
        while(!bankrupt && progress){
            d.shuffle(deck);
            System.out.println("Enter bet number:");
            int bet = pen.nextInt();
            pen.nextLine();
            System.out.println(one.getName() + ", here are your cards:");
            System.out.println(deck.get(0) + " and " + deck.get(1));
            System.out.println("Here is one of the dealer's card: " + deck.get(2));

            ArrayList<card> x = new ArrayList<card>();
            x.add(deck.get(0));
            x.add(deck.get(1));

            ArrayList<card> y = new ArrayList<card>();
            y.add(deck.get(2));
            y.add(deck.get(3));

            int total = deck.get(0).getNumber() + deck.get(1).getNumber();
            int dealerTotal = deck.get(2).getNumber() + deck.get(3).getNumber();
            int draw = 4;
            boolean stand = false;
            while(total <= 21 && stand == false){
                System.out.println("1. Hit 2. Stand 3. Quit game");
                int choice = pen.nextInt();
                pen.nextLine();
                if (choice == 1){
                    draw++;
                    System.out.println(deck.get(draw));
                    x.add(deck.get(draw));
                    total = total + deck.get(draw).getNumber();
                }
                else if (choice == 2){
                    stand = true;
                }
                else if (choice == 3) {
                    stand = true;
                    progress = false;
                }
            }
            total = trueTotal(x);
            if (total > 21) {
                System.out.println("You lose!");
                one.setBank(one.getBank() - bet);
                System.out.println("You have: " + one.getBank());
            }
            else if (stand){
                System.out.print("Dealer's cards: " + deck.get(2) +" and "+ deck.get(3));
                while(dealerTotal < 17) {
                    draw++;
                    System.out.print(" and " + deck.get(draw));
                    y.add(deck.get(draw));
                    dealerTotal = dealerTotal + deck.get(draw).getNumber();
                }
                System.out.println();
                if(dealerTotal > 21){
                    System.out.println("You Win!");
                    one.setBank(one.getBank() + (3*bet/2));
                    System.out.println("You have: " + one.getBank());
                }
                else if (dealerTotal > total){
                    System.out.println("You lose!");
                    one.setBank(one.getBank() - bet);
                    System.out.println("You have: " + one.getBank());
                }
                else if (dealerTotal < total){
                    System.out.println("You Win!");
                    one.setBank(one.getBank() + (3*bet/2));
                    System.out.println("You have: " + one.getBank());
                }
                else {
                    System.out.println("Equal... no one gets money.");
                }
            }
            else {
                System.out.println("You have quit the game.");
                progress = false;
            }
            if (one.getBank() <= 0) {
                System.out.println("You're broke lol.");
                bankrupt = true;
            }


        }

    }
    public static int trueTotal(ArrayList<card> deck){
        boolean Ace = false;
        int secondTotal = 0;
        int total = 0;
        for(int i = 0; i < deck.size(); i++){
            total = total + deck.get(i).getNumber();
        }
        for(int i = 0; i < deck.size(); i++){
            if (deck.get(i).getName() == "Ace of " ){
                Ace = true;
            }
        }
        if (Ace) {
            for(int i = 0; i < deck.size(); i++){
                if (deck.get(i).getName() != "Ace of "){
                    secondTotal = secondTotal + deck.get(i).getNumber();
                }
                else if (deck.get(i).getName() == "Ace of " && (secondTotal + 11) < 21){
                    secondTotal = secondTotal + 11;
                }
                else {
                    secondTotal += 1;
                }
            }
            if (secondTotal > 21) {
                return total;
            }
            else {
                return secondTotal;
            }
        }
        else {
            return total;
        }
    }
}
