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
            dealMultiple(2);
        }
    }


    public void takeTurn() {
        System.out.println("dealer took turn");
        BlackjackRules blackjackRules = (BlackjackRules) rules;
        int dealerScore = blackjackRules.getPlayersScore(dealer);

        while (dealerScore < 17) {
            dealCardToPlayer(dealer);
            dealerScore = blackjackRules.getPlayersScore(dealer);
            if (dealerScore > 21) {
                blackjackRules.changeAcePointsIfFound(dealer);
            }
            dealerScore = blackjackRules.getPlayersScore(dealer);
        }
    }

}
