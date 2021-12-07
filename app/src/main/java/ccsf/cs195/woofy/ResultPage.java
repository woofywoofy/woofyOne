package ccsf.cs195.woofy;
/*
Program Note: This class is the backend of the result page, that display the final result
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResultPage extends AppCompatActivity {

    private static final String dogTable = "DogTable";
    private DatabaseFunction linkDatabase = new DatabaseFunction();
    private ArrayList<String> databaseReturn;
    private int totalDog;
    private List<Pair<ArrayList,Integer>> sortedList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        totalDog = Integer.valueOf(     //Calculate number of dogs in database
                linkDatabase.getDatabaseCount(dogTable).get(0));
        ArrayList selectdog =        //return all answer value from the user's selections
                QuestionPage.getAnswerArrayList();
        ArrayList<ArrayList> returnData;

        //Fetch matching data from database with user input
        returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                "size <= " +selectdog.get(0) +
                " AND Children >= " + selectdog.get(1)+
                " AND ShedLevel <= " + selectdog.get(2)+
                " AND SalivaLevel <= " + selectdog.get(3)+
                " AND Friendliness >= " + selectdog.get(4)+
                " AND AmountOfMotion <= " + selectdog.get(5)+
                " AND WoofLevel <= " + selectdog.get(6));

        //Re-fetch with less operand if the return data from previous fetch is less than 5
        if(returnData.size() < 5)
        {
            returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                    "size <= " + selectdog.get(0) +
                    " AND Children >= " + selectdog.get(1)+
                    " AND ShedLevel <= " + selectdog.get(2)+
                    " AND SalivaLevel <= " + selectdog.get(3)+
                    " AND WoofLevel <= " + selectdog.get(6));
        }

        //Re-fetch with less operand if the return data from previous fetch is less than 5
        if(returnData.size() < 5)
        {
            returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                    "size <= " + selectdog.get(0) +
                    " AND Children >= " + selectdog.get(1)+
                    " AND ShedLevel <= " + selectdog.get(2)+
                    " AND WoofLevel <= " + selectdog.get(6));
        }

        //Re-fetch with less operand if the return data from previous fetch is less than 5
        if(returnData.size() < 5)
        {
            returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                    "size <= " + selectdog.get(0) +
                    " AND Children >= " + selectdog.get(1)+
                    " AND ShedLevel <= " + selectdog.get(2)+
                    " AND WoofLevel <= " + selectdog.get(6));
        }
        System.out.println("Total returned data" + returnData.size());

        //Calculate match percentage between user input data and the dog's data
        for(int i = 0; i < returnData.size(); i++) {
            double matchPercent = 0;
            databaseReturn = returnData.get(i);
            double countElements = 0.0;
            for(int j = 0; j < selectdog.size(); j++) {

                if(Double.parseDouble(databaseReturn.get(j+2)) != 0){
                    double percent = (Double.parseDouble(selectdog
                            .get(j).toString())/Double
                            .parseDouble(databaseReturn.get(j+2)))*100.0;

                    if(percent > 100.0) {

                        if (percent % 100 == 0) {
                            matchPercent = matchPercent + 100;
                        } else {
                            matchPercent = matchPercent + (percent % 100);
                        }
                    } else {
                        matchPercent = matchPercent + percent;
                    }
                    countElements= countElements + 1.0;
                }
            }
            matchPercent = matchPercent/countElements;
            int roundedPercent = (int) Math.round(matchPercent);

            //Sort all data from less match to most match
            if(sortedList == null || sortedList.isEmpty()) {
                sortedList.add(Pair.create(databaseReturn,roundedPercent));
            } else {
                for (int n = 0; n < sortedList.size(); n++) {
                    if(roundedPercent <= sortedList.get(n).second) {
                        sortedList.add(n, Pair.create(databaseReturn,roundedPercent));
                        break;
                    } else if(n == sortedList.size()-1) {
                        sortedList.add(n+1, Pair.create(databaseReturn,roundedPercent));
                        break;
                    }
                }
            }
        }
        System.out.println("Total data in sortedList" + sortedList.size());

        //Floating button that allows user to go back to the beginning of the app
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain(view);
            }
        });

        LinearLayout contentView = findViewById(R.id.content); //Designated view to dispay result

        //Limiting the final result page to only display 10 or less dogs
        int count = 10;
        if (sortedList.size() < 10)
        if(sortedList.size() < 10) {
            count = sortedList.size();
        }
        contentGenerator(count, contentView);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    //Back to beginning of the app
    public void backToMain(View view) {
        Intent intent = new Intent(ResultPage.this,LandingPage.class);
        startActivity(intent);
    }

    //Backend logic to generate the result page with final result
    public void contentGenerator(int numberOfElement, LinearLayout contentView){
        for (int i = 1; i <= numberOfElement; i++) {

            //Creating new image view that display the dog's picture
            ImageView im = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams
                            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 90, 0, 0);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            im.setClickable(true);
            im.setFocusable(true);
            String newUri = (String) sortedList.get(     //casting url data into string
                    sortedList.size()-i).first.get(10);
            im.setOnClickListener(new View.OnClickListener(){   //setting onClick functionality that open a link of the dog
                public void onClick(View v){
                Uri uriUrl = Uri.parse(newUri);
                Intent WebView = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(WebView);
                }
            });
            im.setLayoutParams(lp);

            //Creating new textView for the name of breed
            TextView tv1 = new TextView(this);
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams
                            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv1.setLayoutParams(lp2);
            tv1.setTextColor(getResources().getColor(R.color.main_blue));
            tv1.setTextSize(2, 25);
            tv1.setTypeface(Typeface.DEFAULT_BOLD);
            tv1.setGravity(Gravity.CENTER);

            //Creating new text view for the match percentage info
            TextView tv2 = new TextView(this);
            LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams
                            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv2.setLayoutParams(lp3);
            tv2.setTextColor(getResources().getColor(R.color.main_blue));
            tv2.setTextSize(2, 20);
            tv2.setTypeface(Typeface.DEFAULT);
            tv2.setGravity(Gravity.CENTER);

            //Setting data into the created views
            try {       //Setting picture to the created image view with URL
                new ImageTask(im).execute(new URL((String) sortedList.get(sortedList.size() - i).first.get(9)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            tv1.setText((String) sortedList.get(        //Setting breed name to the created textview
                    sortedList.size() - i).first.get(0));
            tv2.setText((sortedList.get(        //Setting match percentage to the created textview
                    sortedList.size() - i).second) + "% match");

            //Add created view to the designated view to display in result page
            contentView.addView(im);
            contentView.addView(tv1);
            contentView.addView(tv2);
        }
    }
}
