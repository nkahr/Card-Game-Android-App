package example.codeclan.com.cardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 25/01/2017.
 */

public class ProfileActivity extends AppCompatActivity{

    TextView nameTextView;
    TextView fundsTextView;
    TextView statsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        nameTextView = (TextView)findViewById(R.id.name_text_view_id);
        fundsTextView = (TextView)findViewById(R.id.funds_text_view_id);
        statsTextView = (TextView)findViewById(R.id.player_stats_text_view_id);

        String playerName = SavedNamePreferences.getSavedName(this);
        String playerFunds = SavedNamePreferences.getSavedFunds(this);
        ArrayList<String> statStrings= SavedNamePreferences.getPlayerStats(this, playerName);
        nameTextView.setText(playerName);
        fundsTextView.setText("Funds: " + playerFunds);

        String printedString = "";
        if (statStrings != null) {
            for (String item : statStrings) {
                printedString += item + "\n";
            }
        }
        statsTextView.setText(printedString);

    }
}
