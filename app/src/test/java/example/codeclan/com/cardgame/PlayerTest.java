package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class PlayerTest {

    Card aceOfSpades;
    Card queenOfDiamonds;
    ArrayList<Card> cards = new ArrayList<>();
    CardCollection hand;
    Player player;

    @Before
    public void before() {
        aceOfSpades = new Card(StandardRank.ACE, StandardSuit.SPADES);
        queenOfDiamonds = new Card(StandardRank.QUEEN, StandardSuit.DIAMONDS);
        cards.add(aceOfSpades);
        cards.add(queenOfDiamonds);
        hand = new CardCollection(cards);
        player = new Player("Nina", hand);

    }

    @Test
    public void canGetPlayerName() {
        assertEquals("Nina", player.getName());
    }

    @Test
    public void canSetPlayerName() {
        player.setName("Dealer");
        assertEquals("Dealer", player.getName());
    }

    @Test
    public void canGetHand() {
        assertEquals(hand, player.getHand());
    }

    @Test
    public void canSetPlayersHand() {
        assertEquals(hand, player.getHand());
    }

    @Test
    public void canAddToPlayersHand() {
        Card tenOfHearts = new Card(StandardRank.TEN, StandardSuit.HEARTS);
        player.addCardToHand(tenOfHearts);
        assertEquals(3, player.getHand().getNumberOfCards());
    }

    @Test
    public void canGetPlayerScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void canSetPlayerScore() {
        player.setScore(7);
        assertEquals(7, player.getScore());
    }
}