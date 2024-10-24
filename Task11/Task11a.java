package Task11;

import java.util.ArrayList;
import java.util.List;


public class Task11a{
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
    
        for(Suits suit:Suits.values()){
            for(Rank rank:Rank.values()){
                deck.add(new Card(suit, rank));
            }
        }
    
        String continueGame = "";
        while (!continueGame.equals("N")) {
            System.out.println("Welcome to Blackjack!");
            Player player = new Player(new ArrayList<>());
            Banker banker = new Banker(new ArrayList<>());
            Blackjack blackjack = new Blackjack(deck, player, banker);
            continueGame = blackjack.runGame();
        }
        System.out.println("Thanks for playing!");
    }
}
