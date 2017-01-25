package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 23/01/2017.
 */

public class BlackjackRules implements Rules {


    //used in deck setup method
    public HashMap<Rank,Integer> setupPointsMap() {
        HashMap<Rank,Integer> pointsMap = new HashMap<>();

        pointsMap.put(StandardRank.ACE, 11);
        pointsMap.put(StandardRank.TWO, 2);
        pointsMap.put(StandardRank.THREE, 3);
        pointsMap.put(StandardRank.FOUR, 4);
        pointsMap.put(StandardRank.FIVE, 5);
        pointsMap.put(StandardRank.SIX, 6);
        pointsMap.put(StandardRank.SEVEN, 7);
        pointsMap.put(StandardRank.EIGHT, 8);
        pointsMap.put(StandardRank.NINE, 9);
        pointsMap.put(StandardRank.TEN, 10);
        pointsMap.put(StandardRank.JACK, 10);
        pointsMap.put(StandardRank.QUEEN, 10);
        pointsMap.put(StandardRank.KING, 10);

        return pointsMap;
    }

    // set up blackjack deck
    public CardCollection setupDeck() {
        HashMap<Rank, Integer> pointsMap = setupPointsMap();
        CardCollection deck = new CardCollection();
        Card card;
        for (Rank rank : StandardRank.values()) {
            for (Suit suit : StandardSuit.values()) {
                String imgLink = rank.toString().toLowerCase() + "_of_" + suit.toString().toLowerCase();
                card = new Card(rank, suit, imgLink);
                int points = pointsMap.get(rank);
                card.setPoints(points);
                deck.addCard(card);
            }
        }
        deck.shuffle();
        return deck;
    }


    public int getPlayersScore(Player player) {
        int playerScore = 0;

        for (Card card : player.getHand().getCards()) {
            playerScore += card.getPoints();
        }

        return playerScore;
    }


    public void changeAcePointsIfFound(Player player) {
        for (Card card : player.getHand().getCards()) {
            if (card.getRank() == StandardRank.ACE) {
                card.setPoints(1);
            }
        }
    }

    //check whether anyone has 21 or over (ends game)
    public boolean isGameOver(ArrayList<Player> players) {
        Player player = players.get(0);
        Player dealer = players.get(1);

        int playerScore = getPlayersScore(player);
        int dealerScore = getPlayersScore(dealer);

        if (playerScore > 21) {
            changeAcePointsIfFound(player);
            playerScore = getPlayersScore(player);
        }

        if (dealerScore > 21) {
            changeAcePointsIfFound(dealer);
            dealerScore = getPlayersScore(dealer);
        }

        if (playerScore >= 21 || dealerScore >= 21) {
            return true;
        }

        return false;
    }


    //should be called when isGameOver == true or after player sticks and dealer finishes his round?
    public String findWinner(ArrayList<Player> players) {

        Player player = players.get(0);
        Player dealer = players.get(1);

        int playerScore = getPlayersScore(player);
        int dealerScore = getPlayersScore(dealer);

        if (playerScore > 21) { // && dealerScore > 21
//            return "Dealer scored " + dealerScore + ", Player scored " + playerScore + ". Both bust!";
            return "You score " + playerScore + " points and bust!";
        }
        if (playerScore == dealerScore){
            return "You draw with " + playerScore + " points!";
        }
        if (dealerScore > 21) {
            return "Dealer scores " + dealerScore + " and busts. Player wins with " + playerScore + ".";
        }
//        if (playerScore > 21){
//            return "Player scores " + playerScore + " and busts. Dealer wins with " + dealerScore + ".";
//        }

        if (playerScore > dealerScore) {
            return "Dealer scored " + dealerScore + ". Player wins with " + playerScore + ".";
        }

        if (dealerScore > playerScore) {
            return "Player scored " + playerScore + ". Dealer wins with " + dealerScore + ".";

        }
        return "ERROR";
    }

//    public void dealerPlays(Game game) {
//
//        Player dealer = game.getPlayers().get(1);
//
//        int dealerScore = getPlayersScore(dealer);
//
//        while (dealerScore < 17) {
//            game.dealCardToPlayer(dealer);
//            dealerScore = getPlayersScore(dealer);
//        }
//    }

}
