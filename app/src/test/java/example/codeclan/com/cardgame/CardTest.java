package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(StandardRank.ACE, StandardSuit.SPADES);
    }

    @Test
    public void canMakeStandardCard() {
        assertNotNull(card);
    }

    @Test
    public void canGetSuit() {
        assertEquals(StandardSuit.SPADES, card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(StandardRank.ACE, card.getRank());
    }

    @Test
    public void canSetSuit() {
        card.setSuit(StandardSuit.HEARTS);
        assertEquals(StandardSuit.HEARTS, card.getSuit());
    }

    @Test
    public void canSetRank() {
        card.setRank(StandardRank.TWO);
        assertEquals(StandardRank.TWO, card.getRank());
    }

    @Test
    public void canGetImgLink() {
        Card newCard = new Card(StandardRank.KING, StandardSuit.HEARTS, "image link");
        assertEquals("image link", newCard.getImgLink());
    }

    @Test
    public void canSetImgLink() {
        assertNull(card.getImgLink());
        card.setImgLink("hi I link to an image");
        assertEquals("hi I link to an image", card.getImgLink());
    }



}