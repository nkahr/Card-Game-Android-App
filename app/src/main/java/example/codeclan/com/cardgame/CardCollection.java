package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 21/01/2017.
 */

public class CardCollection {

    private ArrayList<Card> cards;

    public CardCollection(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public CardCollection() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeFirstCard() {
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
