import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Card {
    private String suit;
    private String rank;
    private int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }
}

class Player {
    private List<Card> hand;
    private int score;

    public Player() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        score += card.getValue();

        // Adjust for Ace if score goes over 21
        if (score > 21) {
            for (Card c : hand) {
                if (c.getValue() == 11) {
                    score -= 10;
                    break;
                }
            }
        }
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return hand + " (Score: " + score + ")";
    }
}

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Player player = new Player();
        Player dealer = new Player();

        // Initial cards
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        System.out.println("Dealer's hand: [" + dealer.getHand().get(0) + ", Hidden]");
        System.out.println("Your hand: " + player);

        // Player's turn
        while (true) {
            System.out.println("Do you want to (H)it or (S)tand?");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("H")) {
                player.addCard(deck.drawCard());
                System.out.println("Your hand: " + player);
                if (player.getScore() > 21) {
                    System.out.println("You busted! Dealer wins.");
                    scanner.close();
                    return;
                }
            } else if (choice.equals("S")) {
                break;
            } else {
                System.out.println("Invalid choice. Please choose (H)it or (S)tand.");
            }
        }

        // Dealer's turn
        System.out.println("Dealer's hand: " + dealer);
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.drawCard());
            System.out.println("Dealer's hand: " + dealer);
            if (dealer.getScore() > 21) {
                System.out.println("Dealer busted! You win.");
                scanner.close();
                return;
            }
        }

        // Compare scores
        if (player.getScore() > dealer.getScore()) {
            System.out.println("You win!");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
