package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionPage extends AppCompatActivity {

    private static final String questionTable = "QuestionTable";
    private int questNumberStart = 1;
    private int totalQuestion;
    private Button nextActivityButton;
    private Button applyActivityButton;
    private ArrayList<String> databaseReturn;
    private TextView txtQuestion;
    private RadioButton radioItem1;
    private RadioButton radioItem2;
    private RadioButton radioItem3;
    private RadioButton radioItem4;
    private DatabaseFunction linkDatabase = new DatabaseFunction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseFunction.initDatabase(this);
        setContentView(R.layout.activity_question_page);

        txtQuestion =(TextView) findViewById(R.id.textQuestion);
        radioItem1 = (RadioButton) findViewById(R.id.radioItem1);
        radioItem2 = (RadioButton) findViewById(R.id.radioItem2);
        radioItem3 = (RadioButton) findViewById(R.id.radioItem3);
        radioItem4 = (RadioButton) findViewById(R.id.radioItem4);
        nextActivityButton = (Button)findViewById(R.id.next);
        applyActivityButton = (Button) findViewById(R.id.apply);
        applyActivityButton.setVisibility(View.GONE);

        totalQuestion = Integer.valueOf(linkDatabase.getDatabaseCount(questionTable).get(0));
        databaseReturn = linkDatabase.getDatabase(questionTable,"Number", questNumberStart);

        txtQuestion.setText(databaseReturn.get(1));
        radioItem1.setText(databaseReturn.get(2));
        radioItem2.setText(databaseReturn.get(3));
        radioItem3.setText(databaseReturn.get(4));
        radioItem4.setText(databaseReturn.get(5));
    }

    public void nextButton(View view) {
        if (questNumberStart < totalQuestion) {
            questNumberStart = questNumberStart + 1;
        }
        if (questNumberStart == totalQuestion) applyActivityButton.setVisibility(View.VISIBLE);
        databaseReturn = linkDatabase.getDatabase(questionTable, "Number", questNumberStart);
        txtQuestion.setText(databaseReturn.get(1));
        radioItem1.setText(databaseReturn.get(2));
        radioItem2.setText(databaseReturn.get(3));
        radioItem3.setText(databaseReturn.get(4));
        radioItem4.setText(databaseReturn.get(5));
    }

    public void applyButton(View view)
    {
        Intent intent = new Intent(QuestionPage.this, ResultPage.class);
        startActivity(intent);
    }
}