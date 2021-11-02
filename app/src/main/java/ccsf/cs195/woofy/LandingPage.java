package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingPage extends AppCompatActivity {

    // Define global variable to pass to next activity
    TextView textQuestion;

    //Button to move to next activity
    Button nextActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        nextActivityButton = (Button)findViewById(R.id.button_begin);
        textQuestion = (TextView)findViewById(R.id.textQuestion);

        nextActivityButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(LandingPage.this, QuestionPage.class);
                startActivity(intent);
            }
        });
    }
}