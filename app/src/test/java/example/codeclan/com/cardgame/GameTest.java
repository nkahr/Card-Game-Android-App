package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class GameTest {

    Game game;
    Player player;
    Player dealer;
    ArrayList<Player> players = new ArrayList<>();
    BlackjackRules blackjackRules;

    @Before
    public void before() {
        player = new Player("Nina");
        dealer = new Player("Dealer");
        players.add(player);
        players.add(dealer);
        game = new Blackjack(players);
        blackjackRules = (BlackjackRules)game.getRules();
    }

    @Test
    public void canCreateStandardDeck() {
        CardCollection deck = blackjackRules.setupDeck();
        assertEquals(52, deck.getNumberOfCards());
        assertNotNull(deck.getCards().get(0).getPoints());
    }

    @Test
    public void canDealACardToOnePlayer() {
        game.setupGame();
        game.dealCardToPlayer(player);
        assertEquals(1, player.getHand().getNumberOfCards());
    }

    @Test
    public void canDealACardToEachPlayer() {
        game.setupGame();
        game.deal();
        assertEquals(1, player.getHand().getNumberOfCards());
        assertEquals(1, dealer.getHand().getNumberOfCards());
    }

    @Test
    public void canDealTwoCardsToEachPlayer() {
        game.setupGame();
        game.dealMultiple(2);
        assertEquals(2, player.getHand().getNumberOfCards());
        assertEquals(2, dealer.getHand().getNumberOfCards());
    }








//    @Test
//    public void canCheckWhetherGameIsOver() {
//        game.setupGame();
//        game.dealMultiple(3);
//        System.out.println(blackjackRules.isGameOver(game));
//    }


    //tests for methods in abstract game class

//    Card aceOfSpades;
//    Card queenOfDiamonds;
//    ArrayList<Card> cards = new ArrayList<>();
//    CardCollection hand;
//    Player player;
//    Player dealer;
//    ArrayList<Player> players;
//    Game game;
//    Blackjack blackjackgame;

//    @Before
//    public void before() {
//        aceOfSpades = new Card(StandardRank.ACE, StandardSuit.SPADES);
//        queenOfDiamonds = new Card(StandardRank.QUEEN, StandardSuit.DIAMONDS);
//        cards.add(aceOfSpades);
//        cards.add(queenOfDiamonds);
//        hand = new CardCollection(cards);
//        player = new Player("Nina");
//        dealer = new Player("Dealer");
//        players = new ArrayList<>();
//        players.add(player);
//        players.add(dealer);
//        game = new Blackjack(players);
//        blackjackgame = new Blackjack(players);
//    }
//
//    @Test
//    public void canGetPlayers() {
//        assertEquals(players, blackjackgame.getPlayers());
//        assertEquals(players, game.getPlayers());
//    }
//
//    @Test
//    public void canSetPlayers() {
//        game.setPlayers(new ArrayList<>(Arrays.asList(player)));
//        assertEquals(1, game.getPlayers().size());
//
//    }
//
//    @Test
//    public void canSetDeck() {
//        game.setupDeck();
//        assertEquals(52, game.getDeck().getNumberOfCards());
//    }
//
//    //made setupScoreMap() private so this doesn't work anymore
////    @Test
////    public void canSetUpScoreMap() {
////        blackjackgame.setupScoreMap();
////        assertEquals(2, (int) blackjackgame.getScoreMap().get(StandardRank.TWO));
////    }
//
////    @Test
////    public void canPlayBlackjack() {
////        game.play();
//////        Integer four = new Integer(4);
//////        assertEquals(four, game.getScoreMap().get(StandardRank.FOUR));
////    }
//
//    @Test
//    public void canSetUpGame() {
//        game.setupGame();
//        assertNotNull(game.getScoreMap());
//        assertEquals(48, game.getDeck().getNumberOfCards());
//        CardCollection playersHand = players.get(0).getHand();
//        int numberOfCardsInHand = playersHand.getNumberOfCards();
//        assertEquals(2, numberOfCardsInHand);
//        CardCollection dealersHand = players.get(1).getHand();
//        int numberOfCardsInDealersHand = dealersHand.getNumberOfCards();
//        assertEquals(2, numberOfCardsInDealersHand);
//    }
//
//    @Test
//    public void canDealCardToPlayer() {
//        game.setupGame();
//        game.dealCardToPlayer(player);
//        CardCollection playersHand = players.get(0).getHand();
//        int numberOfCardsInHand = playersHand.getNumberOfCards();
//        assertEquals(3, numberOfCardsInHand);
//    }
//
//    @Test
//    public void canGetPlayersScoresHashMap() {
//        game.setupGame();
//        assertNotNull(game.getPlayerScores());
//        assertNotEquals(new HashMap<Player, Integer>(), game.getPlayerScores());
//    }




}