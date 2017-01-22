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

    public abstract void setupGame();

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
//    public abstract ArrayList<Player> getPlayers();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void dealCardToPlayer(Player player) {
        Card cardFromDeck = deck.removeFirstCard();
        player.addCardToHand(cardFromDeck);
    }

    protected void deal() {
        for (Player player : players) {
            Card cardFromDeck = deck.removeFirstCard();
            player.addCardToHand(cardFromDeck);
        }
    }

    protected void dealMultiple(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            deal();
        }
    }

    public HashMap<Player, Integer> getPlayerScores() {
        HashMap<Player, Integer> playerScores = new HashMap<>();
        for (Player p : players) {
            Integer pScore = 0;
            for (Card card : p.getHand().getCards()) {
                pScore += scoreMap.get(card.getRank());
            }
            playerScores.put(p, pScore);
        }
        return playerScores;
    }


//    public abstract void setPlayers(ArrayList<Player> players);
//    public abstract void setupScoreMap();

    //make default implementation to create standard deck, can be overridden
    public void setupDeck() {
        deck = new CardCollection();
        Card card;
        for (Rank rank : StandardRank.values()) {
            for (Suit suit : StandardSuit.values()) {
                String imgLink = rank.toString().toLowerCase() + "_of_" + suit.toString().toLowerCase();
                card = new Card(rank, suit, imgLink);
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

    public abstract Player checkForWinner();

//    public void play() {
//        setupDeck();
//    }

}
