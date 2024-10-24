package Task11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for(Suits suit:Suits.values()){
            for(Rank rank:Rank.values()){
                deck.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(deck);

        for(Card card:deck) {
            System.out.println(card.getSuit().getSuitName() + " " + card.getRank().getRankName());
        }
    }
}

