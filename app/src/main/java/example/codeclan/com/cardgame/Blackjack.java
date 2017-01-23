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
//


    //CONSTRUCTORS
    public Blackjack(ArrayList<Player> players) {
        super(players);
        player = players.get(0);
        dealer = players.get(1);
        rules = new BlackjackRules(); //implement BlackjackRules
    }

    public void setupGame() {
        if(!alreadySetUp) {
            BlackjackRules blackjackRules = (BlackjackRules) rules;
            deck = blackjackRules.setupDeck(); //make deck with 52 cards
        }
    }










//    public Blackjack() {
//        super();
//        player = players.get(0);
//        dealer = players.get(1);
//    }
//
//    public void setupGame() {
//        if(!alreadySetUp) {
//            rules = new BlackjackRules();
//            setupDeck();
//            setupScoreMap();
//            dealMultiple(2);
//            alreadySetUp = true;
//        }
//    }
//
//    public Player checkForWinner() {
//        HashMap<Player, Integer> playerScoresMap = getPlayerScores();
//        int playerScore = playerScoresMap.get(player);
//        int dealerScore = playerScoresMap.get(dealer);
//
//        if (playerScore == dealerScore) {
//            return null;
//        }
//
//        if (playerScore > 21) {
//            if (dealerScore <= 21) {
//                return dealer;
//            } else {
//                return null;
//            }
//        }
//
//        if (playerScore <= 21) {
//            if (dealerScore > 21) {
//                return player;
//            }
//            if (dealerScore <= 21 && dealerScore > playerScore) {
//                return dealer;
//            }
//            if (dealerScore <= 21 && dealerScore < playerScore) {
//                return player;
//            }
//        }
//        return null;
//    }
//
//    public int getScore(Player player) {
//        HashMap<Player, Integer> playerScoresMap = getPlayerScores();
//        return playerScoresMap.get(player);
//    }
//
//    private void setupScoreMap() {
//        scoreMap.put(StandardRank.ACE, 11);
//        scoreMap.put(StandardRank.TWO, 2);
//        scoreMap.put(StandardRank.THREE, 3);
//        scoreMap.put(StandardRank.FOUR, 4);
//        scoreMap.put(StandardRank.FIVE, 5);
//        scoreMap.put(StandardRank.SIX, 6);
//        scoreMap.put(StandardRank.SEVEN, 7);
//        scoreMap.put(StandardRank.EIGHT, 8);
//        scoreMap.put(StandardRank.NINE, 9);
//        scoreMap.put(StandardRank.TEN, 10);
//        scoreMap.put(StandardRank.JACK, 10);
//        scoreMap.put(StandardRank.QUEEN, 10);
//        scoreMap.put(StandardRank.KING, 10);
//    }
//
//    //only allow to hit if score is less than 21
//    @Override
//    public void dealCardToPlayer(Player player) {
//        if (getScore(player) < 21){
//            super.dealCardToPlayer(player);
//        }
//    }

}
