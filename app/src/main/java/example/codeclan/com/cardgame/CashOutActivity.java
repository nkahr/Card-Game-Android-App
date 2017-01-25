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

public class CashOutActivity extends AppCompatActivity {

    EditText cashOutEditText;
    Button cashOutButton;
    String cashOutAmountStr;
    TextView insufficientFundsTextView;
    Intent goToWelcomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_out_layout);
        cashOutEditText = (EditText)findViewById(R.id.cash_out_edit_text_id);
        cashOutButton = (Button)findViewById(R.id.cash_out_button_id);
        insufficientFundsTextView = (TextView)findViewById(R.id.insufficient_funds_text_view_id);
    }

    public void onCashOutButtonPressed(View view) {
        Log.d(getClass().toString(), "onCashOutButtonPressed was clicked.");
        cashOutAmountStr = cashOutEditText.getText().toString();

        //change funds in sharedPrefs
        int funds = Integer.parseInt(SavedNamePreferences.getSavedFunds(this));
        int cashOutAmountInt = Integer.parseInt(cashOutAmountStr);

        int newFunds = funds - cashOutAmountInt;
        if (newFunds > 0) {
            String newFundsStr = Integer.toString(newFunds);
            SavedNamePreferences.setSavedFunds(this, newFundsStr);
            goToWelcomePage = new Intent(CashOutActivity.this, MainActivity.class);
            startActivity(goToWelcomePage);
        } else {
            insufficientFundsTextView.setVisibility(View.VISIBLE);
        }

    }
}
