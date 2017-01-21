package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 21/01/2017.
 */

public class Blackjack extends Game {

    protected ArrayList<Player> players;
    protected ArrayList<Card> deck;

    public Blackjack(ArrayList<Player> players) {
        this.players = players;
    }

    public Blackjack() {
        this.players = new ArrayList<>();
    }



    public void setupDeck() {
        super.setupDeck(); //default 52
    }
    public void play() {}

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }



}
