package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 22/01/2017.
 */

public class MainActivity extends AppCompatActivity{

    TextView welcomeText, playerFundsTextView;
//    EditText playerNameEditTextView;
    Button playBlackjackButton;
    Intent playBlackjackIntent;
    Intent changePlayerIntent;
    String savedName;
    String savedFundsString;
    String playerName;
    String betAmountStr;
    int betAmountInt;
    EditText placeBetEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        playerFundsTextView = (TextView)findViewById(R.id.main_player_funds_text_view_id);
        welcomeText = (TextView)findViewById(R.id.welcome_text_id);
        playBlackjackButton = (Button) findViewById(R.id.play_blackjack_button_id);
        placeBetEditText = (EditText)findViewById(R.id.place_bet_edit_text_id);

        playBlackjackIntent = new Intent(MainActivity.this, BlackjackActivity.class);
        changePlayerIntent = new Intent(MainActivity.this, NewPlayerActivity.class);

        savedName = SavedNamePreferences.getSavedName(this);
        savedFundsString = SavedNamePreferences.getSavedFunds(this);


        //funds at top of page
        String fundsString = "Funds: " + savedFundsString;
        playerFundsTextView.setText(fundsString);



        if (savedName != null && !savedName.isEmpty()) {
            playerName = savedName;
            String text = "Current player: " + playerName;
            welcomeText.setText(text);
        } else {
            //redirect to make new player page
            startActivity(changePlayerIntent);

        }

        Log.d(getClass().toString(), "onCreate was called in main activity");
    }

    //listener
    public void onBlackjackButtonPressed(View view) {
        Log.d(getClass().toString(), "onBlackjackButtonPressed was clicked.");
        betAmountStr = placeBetEditText.getText().toString();
//        betAmountInt = Integer.parseInt(betAmountStr);
        if (!betAmountStr.isEmpty() && Integer.parseInt(betAmountStr) > Integer.parseInt(savedFundsString)) {
                Toast.makeText(MainActivity.this, R.string.toast_insufficient_funds, Toast.LENGTH_SHORT).show();
        } else {
            playBlackjackIntent.putExtra("bet_placed_string", betAmountStr);
            startActivity(playBlackjackIntent);
        }
    }

    public void onChangePlayerButtonPressed(View view) {
        startActivity(changePlayerIntent);
        Log.d(getClass().toString(), "onBlackjackButtonPressed was called.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.change_user_menu_item_id) {
            startActivity(changePlayerIntent);
            return true;

        } else if (item.getItemId() == R.id.pay_in_menu_item_id) {
            Intent payInIntent = new Intent(MainActivity.this, PayInActivity.class);
            startActivity(payInIntent);
            return true;

        } else if (item.getItemId() == R.id.cash_out_menu_item_id) {
            Intent cashOutIntent = new Intent(MainActivity.this, CashOutActivity.class);
            startActivity(cashOutIntent);
            return true;

        } else if (item.getItemId() == R.id.instructions_menu_item_id) {
            Intent instructionsIntent = new Intent(MainActivity.this, InstructionsActivity.class);
            startActivity(instructionsIntent);
            return true;

        } else if (item.getItemId() == R.id.player_stats_menu_item_id) {
            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }

    }
}

