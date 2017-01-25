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
 * Created by user on 25/01/2017.
 */

public class NewPlayerActivity extends AppCompatActivity {

    EditText playerNameEditTextView;
    Button addNewPlayer;
    String savedName;
    String savedFunds;
    String newPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player_layout);

        playerNameEditTextView = (EditText) findViewById(R.id.enter_player_name_id);
        addNewPlayer = (Button)findViewById(R.id.new_player_button_id);
        //name and funds of current player
        savedName = SavedNamePreferences.getSavedName(this);
        savedFunds = SavedNamePreferences.getSavedFunds(this);

        //archive the current player before making the new one (do this after button is clicked)

        Log.d(getClass().toString(), "onCreate was called in new player activity");
    }

    public void onNewPlayerButtonPressed(View view) {
        if (savedName != null && !savedName.isEmpty()) {
            //should save player and funds in savedprefs
            SavedNamePreferences.setArchivedPlayer(this, savedName, savedFunds);
        }

        newPlayerName = playerNameEditTextView.getText().toString();
        SavedNamePreferences.setSavedName(this, newPlayerName);
        SavedNamePreferences.setSavedFunds(this, "300");
    }




}
