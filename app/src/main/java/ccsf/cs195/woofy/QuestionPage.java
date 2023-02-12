package ccsf.cs195.woofy;
/*
Program Note: This class is the backend of the question page, that allow user to answer the survey
 */
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
        linkDatabase.initDatabase(this);
        setContentView(R.layout.activity_question_page);

        //Covert Views into java object
        txtQuestion = (TextView) findViewById(R.id.textQuestion);
        questionCounter = (TextView) findViewById(R.id.runningPicks);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        radioButtons[0] = (RadioButton) findViewById(R.id.radio_one);
        radioButtons[1] = (RadioButton) findViewById(R.id.radio_two);
        radioButtons[2] = (RadioButton) findViewById(R.id.radio_three);
        radioButtons[3] = (RadioButton) findViewById(R.id.radio_four);
        nextActivityButton = (Button)findViewById(R.id.next_button);
        totalQuestion = Integer.valueOf(linkDatabase.getDatabaseCount(questionTable).get(0));   //Calculate total question in current database
        questionCounter.setText(getString(R.string.question_counter, currentQuestion, totalQuestion));

        //Initial disabled invisible previous button
        previousBT = (Button) findViewById(R.id.previous_button);
        previousBT.setTextColor(Color.WHITE);
        previousBT.setEnabled(false);

        updateText();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    //Backend logic for the next button on question page
    public void nextButton(View view) {

        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();

        //Last question logic of question page
        if(currentQuestion == totalQuestion) {

            //Warning if button is pressed with no answer was selected
            if (radioButtonID <= 0) {
                Toast.makeText(getApplicationContext(),
                        "Please select a response prior to moving on!", Toast.LENGTH_SHORT).show();
            } else if (radioButtonID > 0) { //Next button logic if answer was

                saveAnswer(searchData());   //Add answer to arraylist

                //To result page as last question is answered
                Intent intent = new Intent(QuestionPage.this, ResultPage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        } else if(currentQuestion < totalQuestion){ //Questions before last question logic

            if (radioButtonID <= 0) {
                Toast.makeText(getApplicationContext(),
                        "Please select a response prior to moving on!", Toast.LENGTH_SHORT).show();
            } else if (radioButtonID > 0 && currentQuestion < totalQuestion) {
                saveAnswer(searchData());

                //Track current question count
                currentQuestion++;

                //Change next button text if the next question is last question
                if (currentQuestion == totalQuestion) {
                    nextActivityButton.setText("Go Fetch");
                }
                updateText();

                //Memorize answered questions answer with userData object
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

            //Enable previous button, visible after the first question
            if (currentQuestion > 1) {
                previousBT.setTextColor(Color.parseColor("#589dfc"));
                previousBT.setEnabled(true);
            }
        }
    }

    //Previous button backend
    public void previousButton(View view) {

        //Warning if the previous being click in first question page
        if (currentQuestion == 1) {
            Toast.makeText(getApplicationContext(),
                    "You're already at the beginning!", Toast.LENGTH_SHORT).show();
        } else {

            //If at last question page, next button text set back to next when previous is clicked
            if (currentQuestion == totalQuestion) {
                nextActivityButton.setText("Next");
            }

            currentQuestion--;

            //Disable previous button is first page
            if (currentQuestion == 1) {
                previousBT.setTextColor(Color.WHITE);
                previousBT.setEnabled(false);
            }


            //Reselected answered question from userData object
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

    //Update view text, and return question and answer from database by question tracker number
    public void updateText() {

        //Get question and answers from  database by using currentQuestion as question tracker
        databaseReturn = linkDatabase.getDatabase(questionTable, "Number", currentQuestion);
        txtQuestion.setText(databaseReturn.get(1));     //Update question text view
        questionCounter.setText(getString(R.string.question_counter, currentQuestion, totalQuestion));      //Question tracker display in question page

        //Update answer radioButtons
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(databaseReturn.get(i + 2));
        }
    }

    //Method to save all answered question's actual value into a arraylist
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

    //Get answer's actual value from database
    public ArrayList searchData()
    {
        String selectAnswer = "";
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        System.out.println(radioButtonID);
        if (radioButtonID > 0) {
            RadioButton radioButton = radioButtonGroup.findViewById(radioButtonID);
            selectAnswer = radioButton.getText().toString();
        }
        return linkDatabase.getDatabase("SELECT * FROM AnswerKey WHERE QuestionNumber = '" + (currentQuestion) + "' AND Answer = '" + selectAnswer.replace("'", "''") + "'");

    }

    //Return saved answer value arraylist
    public static ArrayList getAnswerArrayList()
    {
        return returnAnswer;
    }
}