package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class Player {

    private String name;
    private CardCollection hand;
    private int score;

    public Player(String name, CardCollection hand) {
        this.name = name;
        this.hand = hand;
    }

    public Player(String name) {
        this.name = name;
        this.hand = new CardCollection();
    }

    public String getName() {
        return name;
    }

    public CardCollection getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
