package ccsf.cs195.woofy;


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
    private ImageView dogImage1;
    private TextView dogTextView1;
    private TextView matchPercentView;
    private List<Pair<ArrayList,Integer>> sortedList= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        totalDog = Integer.valueOf(linkDatabase.getDatabaseCount(dogTable).get(0));
        ArrayList selectdog = QuestionPage.getAnswerArrayList();
        ArrayList<ArrayList> returnData;

        returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                "size <= " +selectdog.get(0) +
                " AND Children >= " + selectdog.get(1)+
                " AND ShedLevel <= " + selectdog.get(2)+
                " AND SalivaLevel <= " + selectdog.get(3)+
                " AND Friendliness >= " + selectdog.get(4)+
                " AND AmountOfMotion <= " + selectdog.get(5)+
                " AND WoofLevel <= " + selectdog.get(6));

        if(returnData.size() < 5)
        {
            returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                    "size <= " + selectdog.get(0) +
                    " AND Children >= " + selectdog.get(1)+
                    " AND ShedLevel <= " + selectdog.get(2)+
                    " AND SalivaLevel <= " + selectdog.get(3)+
                    " AND WoofLevel <= " + selectdog.get(6));
        }

        if(returnData.size() < 5)
        {
            returnData = linkDatabase.getDatabase("SELECT * FROM DogTable WHERE " +
                    "size <= " + selectdog.get(0) +
                    " AND Children >= " + selectdog.get(1)+
                    " AND ShedLevel <= " + selectdog.get(2)+
                    " AND WoofLevel <= " + selectdog.get(6));
        }
        System.out.println("Total returned data" + returnData.size());

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain(view);
            }
        });

        LinearLayout contentView = findViewById(R.id.content);
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


    public void backToMain(View view) {
        Intent intent = new Intent(ResultPage.this,LandingPage.class);
        startActivity(intent);
    }

    public void contentGenerator(int numberOfElement, LinearLayout contentView){
        for (int i = 1; i <= numberOfElement; i++) {

            ImageView im = new ImageView(this);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams
                            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 90, 0, 0);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            im.setClickable(true);
            im.setFocusable(true);

            String newUri = (String) sortedList.get(sortedList.size()-i).first.get(10);
            im.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                Uri uriUrl = Uri.parse(newUri);
                Intent WebView = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(WebView);
                }
            });
            im.setLayoutParams(lp);

            TextView tv1 = new TextView(this);

            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams
                            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv1.setLayoutParams(lp2);
            tv1.setTextColor(getResources().getColor(R.color.main_blue));
            tv1.setTextSize(2, 25);
            tv1.setTypeface(Typeface.DEFAULT_BOLD);
            tv1.setGravity(Gravity.CENTER);

            TextView tv2 = new TextView(this);

            LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams
                            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv2.setLayoutParams(lp3);
            tv2.setTextColor(getResources().getColor(R.color.main_blue));
            tv2.setTextSize(2, 20);
            tv2.setTypeface(Typeface.DEFAULT);
            tv2.setGravity(Gravity.CENTER);


            try {
                new ImageTask(im).execute(new URL((String) sortedList.get(sortedList.size() - i).first.get(9)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            tv1.setText((String) sortedList.get(sortedList.size() - i).first.get(0));
            tv2.setText(String.valueOf(sortedList
                    .get(sortedList.size() - i).second) + "% match");

            contentView.addView(im);
            contentView.addView(tv1);
            contentView.addView(tv2);
        }
    }
}
