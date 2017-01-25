package example.codeclan.com.cardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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


    }
}
