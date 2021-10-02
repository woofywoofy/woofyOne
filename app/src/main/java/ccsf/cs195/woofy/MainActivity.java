package ccsf.cs195.woofy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static String dbpath = "/data/data/ccsf.cs195.woofy/databases/woofy.db";
    SQLiteDatabase db;
    private static final int intQuestionRow = 10;
    private static final String questionTable = "QuestionTable";
    private static final int intDogTableRow = 7;
    private static final  String dogTable = "DogTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtQuestion =
                (TextView) findViewById(R.id.textQuestion);

        RadioButton radioItem1 = (RadioButton) findViewById(R.id.radioItem1);
        RadioButton radioItem2 = (RadioButton) findViewById(R.id.radioItem2);
        RadioButton radioItem3 = (RadioButton) findViewById(R.id.radioItem3);
        RadioButton radioItem4 = (RadioButton) findViewById(R.id.radioItem4);
        initDatabase(this);
        String[] databaseReturn = getDatabase(questionTable,intQuestionRow,"Number","2");
        txtQuestion.setText(databaseReturn[1]);
        radioItem1.setText(databaseReturn[2]);
        radioItem2.setText(databaseReturn[3]);
        radioItem3.setText(databaseReturn[4]);
        radioItem4.setText(databaseReturn[5]);
    }

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


        cursor = db.rawQuery("select * from "+ tableName +
                " where " + searchKey +" =? ;", new String[]{String.valueOf(number)});


        if (cursor.getCount() != 0) {
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