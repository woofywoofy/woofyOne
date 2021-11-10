package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionPage extends AppCompatActivity {

    private static final String questionTable = "QuestionTable";
    private static final String answerKeyTable = "AnswerKey";
    private int questNumberStart = 1;
    private int totalQuestion;
    private Button nextActivityButton;
    private Button applyActivityButton;
    private ArrayList<String> databaseReturn;
    private TextView txtQuestion;
    private RadioGroup radioButtonGroup;
    private static ArrayList<Integer> returnAnswer = new ArrayList<>();
    private RadioButton[] radioButtons = new RadioButton[4];
    private DatabaseFunction linkDatabase = new DatabaseFunction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseFunction.initDatabase(this);
        setContentView(R.layout.activity_question_page);

        txtQuestion = (TextView) findViewById(R.id.textQuestion);
        radioButtons[0] = (RadioButton) findViewById(R.id.radio_one);
        radioButtons[1] = (RadioButton) findViewById(R.id.radio_two);
        radioButtons[2] = (RadioButton) findViewById(R.id.radio_three);
        radioButtons[3] = (RadioButton) findViewById(R.id.radio_four);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        nextActivityButton = (Button) findViewById(R.id.next_button);
        applyActivityButton = (Button) findViewById(R.id.apply_button);
        applyActivityButton.setVisibility(View.GONE);

        totalQuestion = Integer.valueOf(linkDatabase.getDatabaseCount(questionTable).get(0));
        databaseReturn = linkDatabase.getDatabase(questionTable, "Number", questNumberStart);

        txtQuestion.setText(databaseReturn.get(1));
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(databaseReturn.get(i + 2));
        }
    }

    public void nextButton(View view) {
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        if (radioButtonID>0 && questNumberStart < totalQuestion) {
            saveAnswer(searchData());
            questNumberStart = questNumberStart + 1;

            if (questNumberStart == totalQuestion) applyActivityButton.setVisibility(View.VISIBLE);
            databaseReturn = linkDatabase.getDatabase(questionTable, "Number", questNumberStart);
            txtQuestion.setText(databaseReturn.get(1));

            for (int i = 0; i < radioButtons.length; i++) {
                radioButtons[i].setText(databaseReturn.get(i + 2));
            }
        }
    }

    public void applyButton(View view) {

        saveAnswer(searchData());
        Intent intent = new Intent(QuestionPage.this, ResultPage.class);
        startActivity(intent);
    }

    public void saveAnswer(ArrayList arrayList) {
        ArrayList<String> stringArrayList = (ArrayList<String>) arrayList.get(0);
        System.out.println(stringArrayList.toString());

        for (int i = 2; i < stringArrayList.size(); i++) {

            if (returnAnswer.size() < 7) {
                returnAnswer.add(Integer.valueOf(stringArrayList.get(i)));
            } else {
                returnAnswer.set(i - 2, returnAnswer.get(i - 2) + Integer.valueOf(stringArrayList.get(i)));
            }
        }
        System.out.println(returnAnswer);
    }

    public ArrayList searchData()
    {
        String selectAnswer = "";
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        if (radioButtonID > 0) {
            RadioButton radioButton = radioButtonGroup.findViewById(radioButtonID);
            selectAnswer = radioButton.getText().toString();
        }
        return linkDatabase.getDatabase("SELECT * FROM AnswerKey WHERE QuestionNumber = '" + (questNumberStart) + "' AND Answer = '" + selectAnswer.replace("'", "''") + "'");

    }

    public static ArrayList getAnswerArrayList()
    {
        return returnAnswer;
    }
}