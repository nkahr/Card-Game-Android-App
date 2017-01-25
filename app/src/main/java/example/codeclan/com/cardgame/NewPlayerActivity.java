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


        //current name and funds
        savedName = SavedNamePreferences.getSavedName(this);
        savedFunds = SavedNamePreferences.getSavedFunds(this);

        //archive the current player before making the new one (do this after button is clicked)

        Log.d(getClass().toString(), "onCreate was called in new player activity");
    }

    public void onNewPlayerButtonPressed(View view) {


        newPlayerName = playerNameEditTextView.getText().toString(); //input name


        //don't do anything if name stayed the same
        if (savedName != newPlayerName) {

            //archive current player if exists
            if (savedName != null && !savedName.isEmpty()) {
                SavedNamePreferences.setArchivedPlayer(this, savedName, savedFunds);
            }

            boolean doesUserExist = SavedNamePreferences.getArchivedPlayer(this, newPlayerName) != null;

            if (doesUserExist) {
                SavedNamePreferences.setSavedName(this, newPlayerName);
                String archivedFunds = SavedNamePreferences.getArchivedPlayer(this, newPlayerName);
                SavedNamePreferences.setSavedFunds(this, archivedFunds);
            } else {
                SavedNamePreferences.setSavedName(this, newPlayerName);
                SavedNamePreferences.setSavedFunds(this, "300"); //default funds
            }
        }

        Intent goToWelcomePage= new Intent(NewPlayerActivity.this, MainActivity.class);
        startActivity(goToWelcomePage);

    }




}
