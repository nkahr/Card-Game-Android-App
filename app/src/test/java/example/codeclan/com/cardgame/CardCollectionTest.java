package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class CardCollectionTest {

    Card aceOfSpades;
    Card queenOfDiamonds;
    ArrayList<Card> cards = new ArrayList<>();
    CardCollection hand;

    @Before
    public void before() {
        aceOfSpades = new Card(StandardRank.ACE, StandardSuit.SPADES);
        queenOfDiamonds = new Card(StandardRank.QUEEN, StandardSuit.DIAMONDS);
        cards.add(aceOfSpades);
        cards.add(queenOfDiamonds);
        hand = new CardCollection(cards);

    }

    @Test
    public void canMakeCardCollection() {
        assertNotNull(hand);
    }

    @Test
    public void canGetCardsFromCollection() {
        assertEquals(cards, hand.getCards());
    }

    @Test
    public void canSetCardsInCollection() {
        CardCollection newHand = new CardCollection();
        newHand.setCards(cards);
        assertEquals(cards, newHand.getCards());
    }

    @Test
    public void canGetNumberOfCards() {
        assertEquals(2, hand.getNumberOfCards());
    }

    @Test
    public void canAddCard() {
        Card twoOfClubs = new Card(StandardRank.TWO, StandardSuit.CLUBS);
        hand.addCard(twoOfClubs);
        assertEquals(3, hand.getNumberOfCards());
    }

}