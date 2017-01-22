package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class GameTest {

    Card aceOfSpades;
    Card queenOfDiamonds;
    ArrayList<Card> cards = new ArrayList<>();
    CardCollection hand;
    Player player;
    Player dealer;
    ArrayList<Player> players;
    Game game;
    Blackjack blackjackgame;

    @Before
    public void before() {
        aceOfSpades = new Card(StandardRank.ACE, StandardSuit.SPADES);
        queenOfDiamonds = new Card(StandardRank.QUEEN, StandardSuit.DIAMONDS);
        cards.add(aceOfSpades);
        cards.add(queenOfDiamonds);
        hand = new CardCollection(cards);
        player = new Player("Nina", hand);
        dealer = new Player("Dealer");
        players = new ArrayList<>();
        players.add(player);
        players.add(dealer);
        game = new Blackjack(players);
        blackjackgame = new Blackjack(players);
    }

    @Test
    public void canGetPlayers() {
        assertEquals(players, game.getPlayers());
    }

    @Test
    public void canSetPlayers() {
        game.setPlayers(new ArrayList<>(Arrays.asList(player)));
        assertEquals(1, game.getPlayers().size());

    }

    @Test
    public void canSetDeck() {
        game.setupDeck();
        assertEquals(52, game.getDeck().getNumberOfCards());
    }

    //made setupScoreMap() private so this doesn't work anymore
//    @Test
//    public void canSetUpScoreMap() {
//        blackjackgame.setupScoreMap();
//        assertEquals(2, (int) blackjackgame.getScoreMap().get(StandardRank.TWO));
//    }

    @Test
    public void canPlayBlackjack() {
        game.play();
//        Integer four = new Integer(4);
//        assertEquals(four, game.getScoreMap().get(StandardRank.FOUR));
    }

}