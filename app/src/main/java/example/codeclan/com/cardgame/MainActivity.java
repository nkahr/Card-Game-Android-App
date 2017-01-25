package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 22/01/2017.
 */

public class MainActivity extends AppCompatActivity{

    TextView welcomeText;
//    EditText playerNameEditTextView;
    Button playBlackjackButton;
    Intent playBlackjackIntent;
    Intent changePlayerIntent;
    String savedName;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        welcomeText = (TextView)findViewById(R.id.welcome_text_id);
        playBlackjackButton = (Button) findViewById(R.id.play_blackjack_button_id);
//        playerNameEditTextView = (EditText)findViewById(R.id.enter_player_name_id);

        playBlackjackIntent = new Intent(MainActivity.this, BlackjackActivity.class);
        changePlayerIntent = new Intent(MainActivity.this, NewPlayerActivity.class);

        savedName = SavedNamePreferences.getSavedName(this);

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
        playBlackjackIntent.putExtra("player_name", playerName);
        startActivity(playBlackjackIntent);
        Log.d(getClass().toString(), "onBlackjackButtonPressed was called.");
    }

    public void onChangePlayerButtonPressed(View view) {
        startActivity(changePlayerIntent);
        Log.d(getClass().toString(), "onBlackjackButtonPressed was called.");
    }
}
