package ccsf.cs195.woofy;
/*
Program note: This is to test if all the answer options in the question page are in the answer key.
 */

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;

@RunWith(Parameterized.class)
public class KeyTableCheck {

    static DatabaseFunction databaseFunction;
    private SQLiteDatabase db;
    static ArrayList<Object[]> allTable = new ArrayList<>();
    static  ArrayList<ArrayList> tempString;
    static Object[] set = new Object[2];
    private int num;
    private String name;


    @Parameterized.Parameters
    public static ArrayList<Object[]> data() {
        databaseFunction = new DatabaseFunction();
        databaseFunction.initDatabase(InstrumentationRegistry.getInstrumentation().getTargetContext());
        tempString = databaseFunction.getDatabase("Select  Number,Answer1, Answer2, Answer3, Answer4\n" +
                "From QuestionTable\n");
        for(int i = 0; i < tempString.size(); i++) {
            set[0] = Integer.parseInt((String)tempString.get(i).get(0));
            set[1] = (String) tempString.get(i).get(1);
            allTable.add(set);
            set[0] = Integer.parseInt((String)tempString.get(i).get(0));
            set[1] = (String) tempString.get(i).get(2);
            allTable.add(set);
            set[0] = Integer.parseInt((String)tempString.get(i).get(0));
            set[1] = (String) tempString.get(i).get(3);
            allTable.add(set);
            set[0] = Integer.parseInt((String)tempString.get(i).get(0));
            set[1] = (String) tempString.get(i).get(4);
            allTable.add(set);
        }
        return allTable;
    }

    public KeyTableCheck(int num,String name) {
        this.num = num;
        this.name = name;

    }
    @Before
    public void setUp() {
        databaseFunction = new DatabaseFunction();
        databaseFunction.initDatabase(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }


    @Test
    public void testAllKeyValue() {
        databaseFunction.openDatabase();
        assertTrue(databaseFunction.getDatabase(
                "Select Answer From AnswerKey where Answer  = "
                + "'" + name+ "'" + "AND QuestionNumber = " + num).size() == 1);
    }

}