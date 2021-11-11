package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/* 11/2/2021 - Modify apply button (made next button do same thing)
             - Define radioGroup to control buttons and receive button signature
             - Enable previous button
             - Include checks to catch errors for next and previous buttons


   11/6/2021 - Working on class userData to track radioId's for previous function
             - Debugging function to fetch radioId's as well - Not able to store at the moment

   11/9/2021 - Begin working on 2D application of arraylist (Optimize to use DatabaseFunction method)
             - Attempt to use radiobuttonID to check previous answers
             - Keeping try-catch statement for debugging
             - Fill in questions that were previous answered
             - Transitions broke application all of sudden. Keeping in to debug
*/

public class QuestionPage extends AppCompatActivity {

    private static final String questionTable = "QuestionTable";
    private static final String answerKeyTable = "AnswerKey";
    private int currentQuestion = 0;
    private int totalQuestion;
    private Button nextActivityButton;
    private ArrayList<ArrayList<String>> databaseReturn;
    private TextView txtQuestion;
    private RadioGroup radioButtonGroup;
    private RadioButton radioItem1;
    private RadioButton radioItem2;
    private RadioButton radioItem3;
    private RadioButton radioItem4;
    private DatabaseFunction linkDatabase = new DatabaseFunction();
    private userData currentUser = new userData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseFunction.initDatabase(this);
        setContentView(R.layout.activity_question_page);
        txtQuestion =(TextView) findViewById(R.id.textQuestion);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        radioItem1 = (RadioButton) findViewById(R.id.radio_one);
        radioItem2 = (RadioButton) findViewById(R.id.radio_two);
        radioItem3 = (RadioButton) findViewById(R.id.radio_three);
        radioItem4 = (RadioButton) findViewById(R.id.radio_four);
        nextActivityButton = (Button)findViewById(R.id.next_button);

        totalQuestion = Integer.valueOf(linkDatabase.getDatabaseCount(questionTable).get(0));

        // Pulls all questions/responses into 2D ArrayList
        databaseReturn = linkDatabase.getAllDatabase(questionTable);
        setText();
    }

    // Slide out animation when user changes screens - Broke suddenly - Keeping to debug
    /*
    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

     */

    public void nextButton(View view) {
        // Verify if answer is checked and remind with message if not - Skips method
        if (radioButtonGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select a response prior to moving on!", Toast.LENGTH_SHORT).show();
        } else if (currentQuestion < totalQuestion - 1) {

            if (currentQuestion >= currentUser.buttonSize()) {
                currentUser.add(radioButtonGroup.getCheckedRadioButtonId());
            } else {
                currentUser.set(currentQuestion, radioButtonGroup.getCheckedRadioButtonId());
            }

            currentQuestion++;

            if (currentQuestion == totalQuestion) {
                nextActivityButton.setText("Apply");
            }

            setText();

            if (currentQuestion < currentUser.buttonSize()) {
                switch (currentUser.get(currentQuestion)) {
                    case R.id.radio_one:
                        radioItem1.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                    case R.id.radio_two:
                        radioItem2.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                    case R.id.radio_three:
                        radioItem3.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                    case R.id.radio_four:
                        radioItem4.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                }

            } else {
                    // Reset button selection after each answer + Cut animation out
                    radioButtonGroup.clearCheck();
                    radioButtonGroup.jumpDrawablesToCurrentState();
                }
            }
            else {
                Intent intent = new Intent(QuestionPage.this, ResultPage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
    }


    public void previousButton(View view) {
        if (currentQuestion == 0) {
            Toast.makeText(getApplicationContext(), "You're already at the beginning!", Toast.LENGTH_SHORT).show();
        } else {
            if (currentQuestion == totalQuestion) {
                nextActivityButton.setText("Next");
            }

            currentQuestion--;

                switch (currentUser.get(currentQuestion)) {
                    case R.id.radio_one:
                        radioItem1.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                    case R.id.radio_two:
                        radioItem2.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                    case R.id.radio_three:
                        radioItem3.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                    case R.id.radio_four:
                        radioItem4.setChecked(true);
                        radioButtonGroup.jumpDrawablesToCurrentState();
                        break;
                }

            setText();
        }
    }

    public void setText() {
        txtQuestion.setText(databaseReturn.get(currentQuestion).get(1));
        radioItem1.setText(databaseReturn.get(currentQuestion).get(2));
        radioItem2.setText(databaseReturn.get(currentQuestion).get(3));
        radioItem3.setText(databaseReturn.get(currentQuestion).get(4));
        radioItem4.setText(databaseReturn.get(currentQuestion).get(5));
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