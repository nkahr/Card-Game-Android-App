package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Blackjack extends Game {

    private boolean alreadySetUp;
    private Player player;
    private Player dealer;
//    private int playerScore;
//    private int dealerScore;
//    private ArrayList<Player> players;
//    private CardCollection deck;
//    private HashMap<Rank, Integer> scoreMap = new HashMap<>();


    public Blackjack(ArrayList<Player> players) {
        super(players);
        player = players.get(0);
        dealer = players.get(1);
//        playerScore = 0;
//        dealerScore = 0;
    }

    public Blackjack() {
        super();
        player = players.get(0);
        dealer = players.get(1);
//        playerScore = 0;
//        dealerScore = 0;
//        this.players = new ArrayList<>();
    }

    public void setupGame() {
        if(!alreadySetUp) {
            setupDeck();
            setupScoreMap();
            dealMultiple(2);
            alreadySetUp = true;
        }
    }

    public Player checkForWinner() {
        HashMap<Player, Integer> playerScoresMap = getPlayerScores();
        int playerScore = playerScoresMap.get(player);
        int dealerScore = playerScoresMap.get(dealer);

        if (playerScore == dealerScore) {
            return null;
        }

        if (playerScore > 21) {
            if (dealerScore <= 21) {
                return dealer;
            } else {
                return null;
            }
        }

        if (playerScore <= 21) {
            if (dealerScore > 21) {
                return player;
            }
            if (dealerScore <= 21 && dealerScore > playerScore) {
                return dealer;
            }
            if (dealerScore <= 21 && dealerScore < playerScore) {
                return player;
            }
        }
        return null;
    }


//    @Override
//    protected void deal() {
//        super.deal();
//        updateScores();
//    }
//
//    @Override
//    protected void dealMultiple(int numberOfCards) {
//        super.dealMultiple(numberOfCards);
//        updateScores();
//    }

//    public HashMap<Rank,Integer> getScoreMap() {
//        return scoreMap;
//    }

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

//    public void updateScores() {
//
//        for (Card card : player.getHand().getCards()) {
//            playerScore += scoreMap.get(card.getRank());
//        }
//        for (Card card : dealer.getHand().getCards()) {
//            dealerScore += scoreMap.get(card.getRank());
//        }
//    }

//    @Override
//    public void play() {
//        super.play();
//        setupScoreMap();
//        System.out.println(scoreMap.get(StandardRank.THREE));
//        System.out.println(deck.getNumberOfCards());
//    }

//    public ArrayList<Player> getPlayers() {
//        return players;
//    }

//    public void setPlayers(ArrayList<Player> players) {
//        this.players = players;
//    }



}
