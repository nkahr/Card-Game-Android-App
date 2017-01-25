package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 25/01/2017.
 */

public class PayInActivity extends AppCompatActivity {

    EditText payInEditText;
    Button payInButton;
    String payInAmountStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_in_layout);
        payInEditText = (EditText)findViewById(R.id.pay_in_edit_text_id);
        payInButton = (Button)findViewById(R.id.pay_in_button_id);
    }

    public void onPayInButtonPressed(View view) {
        Log.d(getClass().toString(), "onPayInButtonPressed was clicked.");
        payInAmountStr = payInEditText.getText().toString();

        //change funds in sharedPrefs
        int funds = Integer.parseInt(SavedNamePreferences.getSavedFunds(this));
        int payInAmountInt = Integer.parseInt(payInAmountStr);
        String newFundsStr = Integer.toString(funds + payInAmountInt);
        SavedNamePreferences.setSavedFunds(this, newFundsStr);

        //go back
        Intent goToWelcomePage= new Intent(PayInActivity.this, MainActivity.class);
        startActivity(goToWelcomePage);
    }
}
