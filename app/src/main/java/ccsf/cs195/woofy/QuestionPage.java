package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionPage extends AppCompatActivity {

    private static final String questionTable = "QuestionTable";
    private static final String answerKeyTable = "AnswerKey";
    private int currentQuestion = 1;
    private int totalQuestion;
    private Button nextActivityButton;
    private Button previousBT;
    private ArrayList<String> databaseReturn;
    private TextView txtQuestion;
    private TextView questionCounter;
    private RadioGroup radioButtonGroup;
    private RadioButton[] radioButtons = new RadioButton[4];
    private static ArrayList<Integer> returnAnswer = new ArrayList<>();
    private DatabaseFunction linkDatabase = new DatabaseFunction();
    private userData currentUser = new userData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseFunction.initDatabase(this);
        setContentView(R.layout.activity_question_page);
        txtQuestion = (TextView) findViewById(R.id.textQuestion);
        questionCounter = (TextView) findViewById(R.id.runningPicks);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        radioButtons[0] = (RadioButton) findViewById(R.id.radio_one);
        radioButtons[1] = (RadioButton) findViewById(R.id.radio_two);
        radioButtons[2] = (RadioButton) findViewById(R.id.radio_three);
        radioButtons[3] = (RadioButton) findViewById(R.id.radio_four);
        nextActivityButton = (Button)findViewById(R.id.next_button);

        totalQuestion = Integer.valueOf(linkDatabase.getDatabaseCount(questionTable).get(0));
        questionCounter.setText(getString(R.string.question_counter, currentQuestion, totalQuestion));
        previousBT = (Button) findViewById(R.id.previous_button);
        previousBT.setTextColor(Color.WHITE);

        updateText();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void nextButton(View view) {

        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        if (currentQuestion >= 1) {
            previousBT.setTextColor(Color.BLUE);
        }

        //
        if(currentQuestion == totalQuestion) {
            if (radioButtonID <= 0) {
                Toast.makeText(getApplicationContext(), "Please select a response prior to moving on!", Toast.LENGTH_SHORT).show();
            } else if (radioButtonID > 0) {
                saveAnswer(searchData());

                Intent intent = new Intent(QuestionPage.this, ResultPage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        } else if(currentQuestion < totalQuestion){

            if (radioButtonID <= 0) {
                Toast.makeText(getApplicationContext(), "Please select a response prior to moving on!", Toast.LENGTH_SHORT).show();
            } else if (radioButtonID > 0 && currentQuestion < totalQuestion) {
                saveAnswer(searchData());
                currentQuestion++;

                if (currentQuestion == totalQuestion) {
                    nextActivityButton.setText("Apply");
                }

                updateText();

                if (currentQuestion > currentUser.buttonSize()) {
                    currentUser.add(radioButtonID);
                } else {
                    currentUser.set(currentQuestion - 2, radioButtonID);
                }

                if (currentQuestion < currentUser.buttonSize()) {
                    switch (currentUser.get(currentQuestion - 1)) {
                        case R.id.radio_one:
                            radioButtons[0].setChecked(true);
                            radioButtonGroup.jumpDrawablesToCurrentState();
                            break;
                        case R.id.radio_two:
                            radioButtons[1].setChecked(true);
                            radioButtonGroup.jumpDrawablesToCurrentState();
                            break;
                        case R.id.radio_three:
                            radioButtons[2].setChecked(true);
                            radioButtonGroup.jumpDrawablesToCurrentState();
                            break;
                        case R.id.radio_four:
                            radioButtons[3].setChecked(true);
                            radioButtonGroup.jumpDrawablesToCurrentState();
                            break;
                    }
                } else {
                    radioButtonGroup.clearCheck();
                    radioButtonGroup.jumpDrawablesToCurrentState();
                }
            }
        }
    }


    public void previousButton(View view) {
        if (currentQuestion == 1) {
            Toast.makeText(getApplicationContext(), "You're already at the beginning!", Toast.LENGTH_SHORT).show();
        } else {

            if (currentQuestion == totalQuestion) {
                nextActivityButton.setText("Next");
            }

            currentQuestion--;

            if (currentQuestion == 1) {
                previousBT.setTextColor(Color.WHITE);
            }


            switch (currentUser.get(currentQuestion - 1)) {
                case R.id.radio_one:
                    radioButtons[0].setChecked(true);
                    radioButtonGroup.jumpDrawablesToCurrentState();
                    break;
                case R.id.radio_two:
                    radioButtons[1].setChecked(true);
                    radioButtonGroup.jumpDrawablesToCurrentState();
                    break;
                case R.id.radio_three:
                    radioButtons[2].setChecked(true);
                    radioButtonGroup.jumpDrawablesToCurrentState();
                    break;
                case R.id.radio_four:
                    radioButtons[3].setChecked(true);
                    radioButtonGroup.jumpDrawablesToCurrentState();
                    break;
            }

            updateText();
        }
    }

    public void updateText() {
        databaseReturn = linkDatabase.getDatabase(questionTable, "Number", currentQuestion);
        txtQuestion.setText(databaseReturn.get(1));
        questionCounter.setText(getString(R.string.question_counter, currentQuestion, totalQuestion));
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(databaseReturn.get(i + 2));
        }
    }

    public void saveAnswer(ArrayList arrayList) {

        if(arrayList.size() > 0) {
            ArrayList<String> stringArrayList = (ArrayList<String>) arrayList.get(0);
            System.out.println(stringArrayList.toString());

            for (int i = 2; i < stringArrayList.size(); i++) {

                if (returnAnswer.size() < totalQuestion) {
                    returnAnswer.add(Integer.valueOf(stringArrayList.get(i)));
                } else {
                    if (Integer.valueOf(stringArrayList.get(i)) > 0) {
                        returnAnswer.set(i - 2, Integer.valueOf(stringArrayList.get(i)));
                        break;
                    }
                }
            }
            System.out.println(returnAnswer);
        } else {
            System.out.println("Empty");
        }
    }

    public ArrayList searchData()
    {
        String selectAnswer = "";
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        if (radioButtonID > 0) {
            RadioButton radioButton = radioButtonGroup.findViewById(radioButtonID);
            selectAnswer = radioButton.getText().toString();
        }
        return linkDatabase.getDatabase("SELECT * FROM AnswerKey WHERE QuestionNumber = '" + (currentQuestion) + "' AND Answer = '" + selectAnswer.replace("'", "''") + "'");

    }

    public static ArrayList getAnswerArrayList()
    {
        return returnAnswer;
    }
}