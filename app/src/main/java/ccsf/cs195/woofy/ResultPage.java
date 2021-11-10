package ccsf.cs195.woofy;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResultPage extends AppCompatActivity {

    private static final String dogTable = "DogTable";
    private DatabaseFunction linkDatabase = new DatabaseFunction();
    private ArrayList<String> databaseReturn;
    private int totalDog;
    private ImageView dogImage1;
    private ImageView dogImage2;
    private ImageView dogImage3;
    private TextView dogTextView1;
    private TextView dogTextView2;
    private TextView dogTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        totalDog = Integer.valueOf(linkDatabase.getDatabaseCount(dogTable).get(0));
        databaseReturn = linkDatabase.getDatabase(dogTable, "DogName", "Affenpinscher");
        dogTextView1 = (TextView)  findViewById(R.id.breed_name);
        dogTextView1.setText(databaseReturn.get(0));
        dogImage1 = (ImageView) findViewById(R.id.imageView);
        try {
            new ImageTask(dogImage1).execute(new URL(databaseReturn.get(9)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
