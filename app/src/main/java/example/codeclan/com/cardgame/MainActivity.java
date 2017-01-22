package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 22/01/2017.
 */

public class MainActivity extends AppCompatActivity{

    EditText playerNameEditTextView;
    Button playBlackjackButton;
    Intent playBlackjackIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        playBlackjackButton = (Button) findViewById(R.id.play_blackjack_button_id);
        playerNameEditTextView = (EditText)findViewById(R.id.enter_player_name_id);

        playBlackjackIntent = new Intent(MainActivity.this, BlackjackActivity.class);

        Log.d(getClass().toString(), "\n\nonCreate was called in main activity\n\n");
    }

    //listener
    public void onBlackjackButtonPressed(View view) {
        playBlackjackIntent.putExtra("player_name", playerNameEditTextView.getText().toString());
        startActivity(playBlackjackIntent);
        Log.d(getClass().toString(), "onBlackjackButtonPressed was called.");
    }
}
