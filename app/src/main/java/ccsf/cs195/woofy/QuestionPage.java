package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class QuestionPage extends AppCompatActivity {

    private static String dbpath = "/data/data/ccsf.cs195.woofy/databases/woofy.db";
    SQLiteDatabase db;
    private static final int intQuestionRow = 10;
    private static final String questionTable = "QuestionTable";
    private static final int intDogTableRow = 7;
    private static final  String dogTable = "DogTable";

    private RadioButton radioItem1;
    private RadioButton radioItem2;
    private RadioButton radioItem3;
    private RadioButton radioItem4;
    private RadioGroup radioItemGroup;

    TextView txtQuestion;
    TextView txtCounter;

    private int questionCounter = 1;
    private int questionTotal = 0;

    /*
    This needs to be cleaned up with a new class, then implementation needs to be tinkered with
    private int amountOfMotion;
    private int shedLevel;
    private int woofLevel;
    private int salivaLevel;
    private int selectedId;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

        txtQuestion = findViewById(R.id.textQuestion);
        txtCounter = findViewById(R.id.questionCounter);

        radioItemGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
        radioItem1 = (RadioButton) findViewById(R.id.radio_one);
        radioItem2 = (RadioButton) findViewById(R.id.radio_two);
        radioItem3 = (RadioButton) findViewById(R.id.radio_three);
        radioItem4 = (RadioButton) findViewById(R.id.radio_four);
        initDatabase(this);

        // Function to set Question and Responses
        setButtons();

        Button previousQuestionButton = (Button) findViewById(R.id.previous_button);
        previousQuestionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (questionCounter == 1) {
                    Toast.makeText(getBaseContext(), "You're already at the first question!", Toast.LENGTH_SHORT).show();
                } else {
                    questionCounter--;
                    setButtons();
                }
            }
        });

        Button nextQuestionButton = (Button) findViewById(R.id.next_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Possible start - Retrieve id of button selected - Not getting too ahead
                /*
                int selectedId = radioItemGroup.getCheckedRadioButtonId();
                Toast.makeText(getBaseContext(), String.valueOf(selectedId), Toast.LENGTH_LONG).show();
                 */

                if (radioItemGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getBaseContext(), "You need to select an option to continue!", Toast.LENGTH_SHORT).show();
                } else {
                    questionCounter++;
                    setButtons();
                }
            }
        });
    }

    public void setButtons() {
        String[] databaseReturn = getDatabase(questionTable, intQuestionRow, "Number", String.valueOf(questionCounter));

        if (questionCounter > questionTotal) {
            Intent intent = new Intent(QuestionPage.this, ResultPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            // Need to pass data to new Activity prior to finish() executing - What to pass?
            finish();
        } else {
            // Pending refinement of database
            //setPoints(databaseReturn, selectedId);

            radioItemGroup.clearCheck();
            txtCounter.setText(questionCounter + "/" + questionTotal);
            txtQuestion.setText(databaseReturn[1]);
            radioItem1.setText(databaseReturn[2]);
            radioItem2.setText(databaseReturn[3]);
            radioItem3.setText(databaseReturn[4]);
            radioItem4.setText(databaseReturn[5]);
        }
    }

    /*
    Method could be used to tally up total for global variables used for result.
    public void setPoints(String[] data, int id) {
        amountOfMotion += Integer.parseInt(data[id]);
        shedLevel += Integer.parseInt(data[id + 1]);
        woofLevel += Integer.parseInt(data[id + 2]);
        salivaLevel += Integer.parseInt(data[id + 3]);
    }
    */


    public void openDatabase() {
        db = SQLiteDatabase.openOrCreateDatabase(dbpath, null);
    }

    public void closeDatabase() {
        db.close();
    }

    public void initDatabase(Context context) {
        File folder = new File(context.getFilesDir().getParent(), "databases");
        File databaseFile = new File(folder, "woofy.db");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        if (databaseFile.exists()) {
            databaseFile.delete();
        }

        AssetManager assets = context.getAssets();
        try
        {
            InputStream open = assets.open("woofy.db");
            FileOutputStream fileOutStream = new FileOutputStream(databaseFile);
            byte[] byteReadWrite = new byte[1024];
            int len;
            while ((len = open.read(byteReadWrite)) != -1)
            {
                fileOutStream.write(byteReadWrite, 0, len);
            }
            fileOutStream.flush();
            fileOutStream.close();
            open.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public String[] getDatabase(String tableName, int databaseRow,String searchKey, String number) {
        openDatabase();
        String[] tempString = new String[databaseRow];
        Cursor cursor;

        // Separate query to retrieve current question count - Count total number of rows
        Cursor countCursor = db.rawQuery("SELECT * FROM " + tableName, null);
        questionTotal = countCursor.getCount();

        cursor = db.rawQuery("select * from "+ tableName +
                " where " + searchKey +" =? ;", new String[]{String.valueOf(number)});

        // Modified to use variable that performed query already
        if (questionTotal != 0) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                for (int i = 0; i < databaseRow; i++) {
                    tempString[i] = cursor.getString(i);
                }

            }
        }
        closeDatabase();
        return tempString;
    }
}