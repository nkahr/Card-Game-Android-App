package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user on 25/01/2017.
 */

public class WinnerActivity extends AppCompatActivity{

    TextView winnerTextView;
    String whoWonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_layout);
        winnerTextView = (TextView)findViewById(R.id.winner_text_id);
        winnerTextView.setText(whoWonText);

        Intent winnerIntent = getIntent();
        Bundle extras = winnerIntent.getExtras();
        whoWonText = extras.getString("winner_string");
        winnerTextView.setText(whoWonText);

    }
}
