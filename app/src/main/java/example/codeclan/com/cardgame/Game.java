package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public abstract class Game {

    protected ArrayList<Player> players;
    protected CardCollection deck;
    protected HashMap<Rank, Integer> scoreMap;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.deck = new CardCollection();
        this.scoreMap = new HashMap<>();
    }

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new CardCollection();
        this.scoreMap = new HashMap<>();
    }
    //abstract methods
//    public abstract void play();
    public abstract ArrayList<Player> getPlayers();
    public abstract void setPlayers(ArrayList<Player> players);
//    public abstract void setupScoreMap();

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

    public HashMap<Rank,Integer> getScoreMap() {
        return scoreMap;
    }

    public void play() {
        setupDeck();

    }

}
