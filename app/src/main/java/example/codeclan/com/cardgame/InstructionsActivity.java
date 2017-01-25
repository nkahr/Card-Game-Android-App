package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 25/01/2017.
 */

public class InstructionsActivity extends AppCompatActivity {

    TextView instructionsTextView;
    Intent goHomeIntent;
    Button goHomeButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions_layout);

        instructionsTextView = (TextView) findViewById(R.id.instructions_text_id);
        goHomeButton = (Button)findViewById(R.id.home_button_id);

    }

    public void onHomeButtonPressed(View view) {
        Log.d(getClass().toString(), "onHomeButtonPressed was clicked.");

        goHomeIntent = new Intent(InstructionsActivity.this, MainActivity.class);
        startActivity(goHomeIntent);
    }
}
