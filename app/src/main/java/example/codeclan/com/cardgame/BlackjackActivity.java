package example.codeclan.com.cardgame;

import android.content.Intent;
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
    Intent getWinnerIntent;
    Game game;
    Player player, dealer;
    ArrayList<Player> players;
    TextView playerFundsTextView, pressDealTextView;
    String whoWonString, savedStatString, playerName;
    int playerCardCount, initialFunds, updatedFunds, changeInFunds, betAmountInt, playerFunds, potentialCardImageId;
    ImageView dealerFaceDown, dealerFaceUp, potentialCard, firstCardImageView, secondCardImageView;
    Button hitButton, stickButton, initialDealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_layout);
//
        Log.d(getClass().toString(), "\n\nonCreate was called in blackjack activity\n\n");

        //both of these should show up immediately in the blackjack activity
        initialDealButton = (Button) findViewById(R.id.initial_deal_button_id);
        pressDealTextView = (TextView) findViewById(R.id.your_cards_text_view_id);
        playerFundsTextView = (TextView)findViewById(R.id.player_funds_text_view_id);

        //winner text view
//        whoWonTextView = (TextView) findViewById(R.id.who_won_text_view_id);

        // create hit/stick button variables in order to make them invisible
        hitButton = (Button) findViewById(R.id.hit_button_id);
        stickButton = (Button) findViewById(R.id.stick_button_id);
        hitButton.setVisibility(View.INVISIBLE);
        stickButton.setVisibility(View.INVISIBLE);

        //get intent to get player name
        Intent playBlackjackIntent = getIntent();
        Bundle extras = playBlackjackIntent.getExtras();
        String betAmountStr = extras.getString("bet_placed_string");
        String emptyString = "";
        if (betAmountStr.equals(emptyString)) {
            betAmountInt = 0;
        } else {
            betAmountInt = Integer.parseInt(betAmountStr);
        }

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

        //make game object
        players = new ArrayList<>();
        players.add(player);
        players.add(dealer);
        game = new Blackjack(players);
        blackjackRules = (BlackjackRules) game.getRules();

        //funds at top of page
        initialFunds = player.getFunds();
        String fundsString = "Funds: " + Integer.toString(player.getFunds());
        playerFundsTextView.setText(fundsString);

        //make new intent --> give it the string that findWinner returns as extras
        getWinnerIntent = new Intent(BlackjackActivity.this, WinnerActivity.class);

    }

    public void onInitialDealButtonPressed(View view) {

        Log.d(getClass().toString(), "deal button was clicked");

        game.setupGame();

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

        if (blackjackRules.isGameOver(players)) {
            endOfGame();

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
        // get id of potential card image & set image & make visible

        playerCardCount = player.getHand().getNumberOfCards();
        int potentialCardId = getResources().getIdentifier("potential_card_" + playerCardCount + "_id", "id", this.getPackageName());
        potentialCard = (ImageView) findViewById(potentialCardId);
        Log.d(getClass().toString(), "potential_card_" + playerCardCount + "_id");
        potentialCardImageId = getResources().getIdentifier(player.getHand().getCards().get(playerCardCount - 1).getImgLink(), "drawable", this.getPackageName());
        potentialCard.setImageResource(potentialCardImageId);
        potentialCard.setVisibility(View.VISIBLE);

        boolean isGameOver = blackjackRules.isGameOver(players);
        System.out.println(isGameOver);
        if (isGameOver) {
            if (blackjackRules.getPlayersScore(player) >= 21) {
                game.takeTurn();
                blackjackRules.isGameOver(players);
                endOfGame();
            }

        }

    }

    public void onStickButtonPressed(View view) {

        game.takeTurn();

        blackjackRules.isGameOver(players);

        hitButton.setVisibility(View.INVISIBLE);
        stickButton.setVisibility(View.INVISIBLE);

        endOfGame();

    }

    public void endOfGame() {
        whoWonString = blackjackRules.findWinner(players, betAmountInt);
        updatedFunds = player.getFunds();
        SavedNamePreferences.setSavedFunds(this, Integer.toString(updatedFunds));
        getWinnerIntent.putExtra("winner_string", whoWonString);

        changeInFunds = updatedFunds - initialFunds;

        if (changeInFunds < 0) {
            savedStatString = "Loss: " + changeInFunds;
        } else if (changeInFunds == 0) {
            savedStatString = "Draw.";
        } else {
            savedStatString = "Win: " + changeInFunds;
        }

        ArrayList<String> stringsArray = SavedNamePreferences.getPlayerStats(this, player.getName());
//        ArrayList<String> stringsArray = new ArrayList<>();
        if (stringsArray == null) {
            stringsArray = new ArrayList<>();
            stringsArray.add(savedStatString);
        } else {
            stringsArray.add(savedStatString);
        }

        SavedNamePreferences.setPlayerStats(this, stringsArray, player.getName());

        startActivity(getWinnerIntent);
    }

}

