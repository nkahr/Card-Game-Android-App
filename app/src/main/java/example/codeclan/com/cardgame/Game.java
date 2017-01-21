package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public abstract class Game {

    protected ArrayList<Player> players;
    protected CardCollection deck;

    //abstract methods
    public abstract void play();
    public abstract ArrayList<Player> getPlayers();
    public abstract void setPlayers(ArrayList<Player> players);


    //make default implementation to create standard deck, can be overridden
    public void setupDeck() {
        deck = new CardCollection();
        Card card;
        for (Rank rank : StandardRank.values()) {
            for (Suit suit : StandardSuit.values()) {
                card = new Card(rank, suit);
                deck.addCard(card);
            }
        }
        deck.shuffle();
    }

    //method only needs to be in abstract method
    public CardCollection getDeck() {
        return deck;
    }
}
