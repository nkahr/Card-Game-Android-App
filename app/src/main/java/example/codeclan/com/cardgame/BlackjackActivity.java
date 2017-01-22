package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BlackjackActivity extends AppCompatActivity{

    Button initialDealButton;
    TextView yourCardsTextView;
    ImageView firstCardImageView;
    ImageView secondCardImageView;
    String playerName;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_layout);

        initialDealButton = (Button) findViewById(R.id.initial_deal_button_id);
        yourCardsTextView = (TextView) findViewById(R.id.your_cards_text_view_id);

        Intent playBlackjackIntent = getIntent();
        Bundle extras = playBlackjackIntent.getExtras();

        playerName = extras.getString("player_name");

        yourCardsTextView.setText("Hi " + playerName + ", press 'deal' to start a game of blackjack.");
    }

    public void onInitialDealButtonPressed(View view) {

        //make a new game object
        Player dealer = new Player("Dealer");
        Player player = new Player(playerName);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(dealer);
        game = new Blackjack(players);
        System.out.println(game.getPlayers().size());
        game.setupDeck();
        game.dealMultiple(2);

        int imageId1 = getResources().getIdentifier(player.getHand().getCards().get(0).getImgLink(), "drawable", this.getPackageName());
        int imageId2 = getResources().getIdentifier(player.getHand().getCards().get(1).getImgLink(), "drawable", this.getPackageName());

        firstCardImageView = (ImageView) findViewById(R.id.initial_card_1_id);
        secondCardImageView = (ImageView) findViewById(R.id.initial_card_2_id);

        firstCardImageView.setImageResource(imageId1);
        secondCardImageView.setImageResource(imageId2);

    }
}
