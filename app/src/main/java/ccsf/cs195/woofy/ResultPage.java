package ccsf.cs195.woofy;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class ResultPage extends AppCompatActivity {

    private static final String dogTable = "DogTable";
    private DatabaseFunction linkDatabase = new DatabaseFunction();
    private ArrayList<String> databaseReturn;
    private int totalDog;
    private ImageView dogImage1;
    private ImageView dogImage2;
    private ImageView dogImage3;
    private ImageView dogImage4;
    private TextView dogTextView1;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        totalDog = Integer.valueOf(linkDatabase.getDatabaseCount(dogTable).get(0));
        dogTextView1 = (TextView)  findViewById(R.id.breed_name1);
        dogImage1 = (ImageView) findViewById(R.id.imageView);
        dogImage2 = (ImageView) findViewById(R.id.imageButton4);
        dogImage3 = (ImageView) findViewById(R.id.imageButton5);
        dogImage4 = (ImageView) findViewById(R.id.imageButton6);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        setDogs();
    }

    // Slide out animation when user changes screens - Broke suddenly - Keeping to debug
    /*
    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

     */

    // FOR DEMO ONLY - REBUILDING RIGHT AFTER DEMO
    public void setDogs() {
        databaseReturn = linkDatabase.getDatabase(dogTable, "DogName", "Miniature Pinscher");
        dogTextView1.setText(databaseReturn.get(0));
        try {
            new ImageTask(dogImage1).execute(new URL(databaseReturn.get(9)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        databaseReturn = linkDatabase.getDatabase(dogTable, "DogName", "Cesky Terrier");
        try {
            new ImageTask(dogImage2).execute(new URL(databaseReturn.get(9)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        databaseReturn = linkDatabase.getDatabase(dogTable, "DogName", "Stabyhoun");
        try {
            new ImageTask(dogImage3).execute(new URL(databaseReturn.get(9)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        databaseReturn = linkDatabase.getDatabase(dogTable, "DogName", "Wirehaired Pointing Griffon");
        try {
            new ImageTask(dogImage4).execute(new URL(databaseReturn.get(9)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
