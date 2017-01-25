package example.codeclan.com.cardgame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BlackjackActivity extends AppCompatActivity {


    BlackjackRules blackjackRules;
    Button initialDealButton;
    TextView pressDealTextView;
    String playerName;
    Game game;
    Player player;
    Player dealer;
    ArrayList<Player> players;
    ImageView firstCardImageView;
    ImageView secondCardImageView;
    TextView whoWonTextView;
    TextView playerFundsTextView;
    int playerFunds;
//    ImageView dynamicImageView;

    int playerCardCount;

    ImageView dealerFaceDown;
    ImageView dealerFaceUp;

    Button hitButton;
    Button stickButton;

    //  //potential cards
    ImageView potentialCard;
    int potentialCardImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_layout); //set content view - still not sure what this does
//
        Log.d(getClass().toString(), "\n\nonCreate was called in blackjack activity\n\n");

        //both of these should show up immediately in the blackjack activity
        initialDealButton = (Button) findViewById(R.id.initial_deal_button_id);
        pressDealTextView = (TextView) findViewById(R.id.your_cards_text_view_id);
        playerFundsTextView = (TextView)findViewById(R.id.player_funds_text_view_id);

        //winner text view
        whoWonTextView = (TextView) findViewById(R.id.who_won_text_view_id);

        // create hit/stick button variables in order to make them invisible
        hitButton = (Button) findViewById(R.id.hit_button_id);
        stickButton = (Button) findViewById(R.id.stick_button_id);
        hitButton.setVisibility(View.INVISIBLE);
        stickButton.setVisibility(View.INVISIBLE);

        //get intent to get player name
//        Intent playBlackjackIntent = getIntent();
//        Bundle extras = playBlackjackIntent.getExtras();
//        playerName = extras.getString("player_name");


        //use savedprefs to get playername
        playerName = SavedNamePreferences.getSavedName(this);
        //set textview to greet the player using the name passed by the intent
        pressDealTextView.setText("Hi " + playerName + ", press 'deal' to start a game of blackjack.");
        //create a game object
        dealer = new Player("Dealer");
        player = new Player(playerName);


        //get funds from sharedprefs and set them in player object
        playerFunds = Integer.parseInt(SavedNamePreferences.getSavedFunds(this));
        player.setFunds(playerFunds);




        players = new ArrayList<>();
        players.add(player);
        players.add(dealer);
        game = new Blackjack(players);
        blackjackRules = (BlackjackRules) game.getRules();
        playerFundsTextView.setText(player.getFunds());
    }

    public void onInitialDealButtonPressed(View view) {

        Log.d(getClass().toString(), "\n\ndeal button was clicked\n\n");

        game.setupGame();
        game.dealMultiple(2);

        // get image id for the three images that will then be applied to the ImageViews
        int imageId1 = getResources().getIdentifier(player.getHand().getCards().get(0).getImgLink(), "drawable", this.getPackageName());
        int imageId2 = getResources().getIdentifier(player.getHand().getCards().get(1).getImgLink(), "drawable", this.getPackageName());
        int dealerImageId = getResources().getIdentifier(dealer.getHand().getCards().get(1).getImgLink(), "drawable", this.getPackageName());

        //get variables for all four cards
        firstCardImageView = (ImageView) findViewById(R.id.initial_card_1_id);
        secondCardImageView = (ImageView) findViewById(R.id.initial_card_2_id);
        dealerFaceDown = (ImageView) findViewById(R.id.dealer_card_1_id);
        dealerFaceUp = (ImageView) findViewById(R.id.dealer_card_2_id);

        //apply imageIDs to ImageViews
        firstCardImageView.setImageResource(imageId1);
        secondCardImageView.setImageResource(imageId2);
        dealerFaceUp.setImageResource(dealerImageId);

        //change visibility of things (make cards visible and deal button invisible)
        firstCardImageView.setVisibility(View.VISIBLE);
        secondCardImageView.setVisibility(View.VISIBLE);
        dealerFaceUp.setVisibility(View.VISIBLE);
        dealerFaceDown.setVisibility(View.VISIBLE);
        initialDealButton.setVisibility(View.GONE);
        pressDealTextView.setVisibility(View.GONE);

        Log.d(getClass().toString(), "\n\nbefore if statement\n\n");


        if (blackjackRules.isGameOver(players)) {
            String whoWonString = blackjackRules.findWinner(players);
            whoWonTextView.setText(whoWonString);
            whoWonTextView.setVisibility(View.VISIBLE);
        } else {
            hitButton.setVisibility(View.VISIBLE);
            stickButton.setVisibility(View.VISIBLE);
        }

        Log.d(getClass().toString(), "player: " + player.getHand().getCards().get(0).getRank() +
                " and " + player.getHand().getCards().get(1).getRank());
        Log.d(getClass().toString(), "dealer: " + dealer.getHand().getCards().get(0).getRank() +
                " and " + dealer.getHand().getCards().get(1).getRank());
    }



    public void onHitButtonPressed(View view) {
        game.dealCardToPlayer(player);
        playerCardCount = player.getHand().getNumberOfCards();
        // get id of potential card image
        Resources res = getResources();
        System.out.println("potential_card_" + playerCardCount + "_id");
        int potentialCardId = res.getIdentifier("potential_card_" + playerCardCount + "_id", "id", this.getPackageName());
        System.out.println(potentialCardId);
        potentialCard = (ImageView) findViewById(potentialCardId);


        potentialCardImageId = getResources().getIdentifier(player.getHand().getCards().get(playerCardCount - 1).getImgLink(), "drawable", this.getPackageName());
        System.out.println(potentialCardImageId);
        potentialCard.setImageResource(potentialCardImageId);
        potentialCard.setVisibility(View.VISIBLE);

        boolean isGameOver = blackjackRules.isGameOver(players);
        System.out.println(isGameOver);
        if (isGameOver) {
            if (blackjackRules.getPlayersScore(player) > 21) {
                game.takeTurn();
                blackjackRules.isGameOver(players);
                hitButton.setVisibility(View.GONE);
                stickButton.setVisibility(View.GONE);
                String whoWonString = blackjackRules.findWinner(players);
                whoWonTextView.setText(whoWonString);
                whoWonTextView.setVisibility(View.VISIBLE);
            }


            if (blackjackRules.getPlayersScore(player) == 21) {
                game.takeTurn();
                blackjackRules.isGameOver(players);
                hitButton.setVisibility(View.INVISIBLE);
                stickButton.setVisibility(View.INVISIBLE);
                String whoWonString = blackjackRules.findWinner(players);
                whoWonTextView.setText(whoWonString);
                whoWonTextView.setVisibility(View.VISIBLE);
            }
        }

    }

    public void onStickButtonPressed(View view) {

        game.takeTurn();

        blackjackRules.isGameOver(players);

        hitButton.setVisibility(View.INVISIBLE);
        stickButton.setVisibility(View.INVISIBLE);
        String whoWonString = blackjackRules.findWinner(players);
        whoWonTextView.setText(whoWonString);
        whoWonTextView.setVisibility(View.VISIBLE);

    }
}

