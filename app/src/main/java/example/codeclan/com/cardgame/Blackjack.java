package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Blackjack extends Game {

//    private ArrayList<Player> players;
//    private CardCollection deck;
//    private HashMap<Rank, Integer> scoreMap = new HashMap<>();

    public Blackjack(ArrayList<Player> players) {
        super(players);
    }

    public Blackjack() {
        super();
//        this.players = new ArrayList<>();

    }


    public HashMap<Rank,Integer> getScoreMap() {
        return scoreMap;
    }

//    public void setupDeck() {
//        super.setupDeck(); //default 52
//    }

    private void setupScoreMap() {
        scoreMap.put(StandardRank.ACE, 11);
        scoreMap.put(StandardRank.TWO, 2);
        scoreMap.put(StandardRank.THREE, 3);
        scoreMap.put(StandardRank.FOUR, 4);
        scoreMap.put(StandardRank.FIVE, 5);
        scoreMap.put(StandardRank.SIX, 6);
        scoreMap.put(StandardRank.SEVEN, 7);
        scoreMap.put(StandardRank.EIGHT, 8);
        scoreMap.put(StandardRank.NINE, 9);
        scoreMap.put(StandardRank.TEN, 10);
        scoreMap.put(StandardRank.JACK, 10);
        scoreMap.put(StandardRank.QUEEN, 10);
        scoreMap.put(StandardRank.KING, 10);
    }

    @Override
    public void play() {
        super.play();
        setupScoreMap();
        System.out.println(scoreMap.get(StandardRank.THREE));
        System.out.println(deck.getNumberOfCards());
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }



}
