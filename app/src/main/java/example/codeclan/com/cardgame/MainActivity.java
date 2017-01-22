package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 22/01/2017.
 */

public class MainActivity extends AppCompatActivity{

    Button playBlackjackButton;
    Intent playBlackjackIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        playBlackjackButton = (Button) findViewById(R.id.play_blackjack_button);
        playBlackjackIntent = new Intent(MainActivity.this, BlackjackActivity.class);

        Log.d(getClass().toString(), "/nONCREATE WAS CALLED");
    }

    public void onBlackjackButtonPressed(View view) {
        startActivity(playBlackjackIntent);
        Log.d(getClass().toString(), "onBlackjackButtonPressed was called.");
    }
}
