package ccsf.cs195.woofy;

/*
Program note: This is to test if all the table are accessible.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class SQLiteTest {

    static DatabaseFunction databaseFunction;
    private SQLiteDatabase db;
    static ArrayList<String> allTable = new ArrayList<>();
    static  ArrayList<ArrayList> tempString;

    private String name;

    @Parameterized.Parameters
    public static ArrayList<String> data() {
        databaseFunction = new DatabaseFunction();
        databaseFunction.initDatabase(InstrumentationRegistry.getInstrumentation().getTargetContext());
        tempString = databaseFunction.getDatabase("SELECT \n" +
                "    name\n" +
                "FROM \n" +
                "    sqlite_master\n" +
                "WHERE \n" +
                "    type ='table' AND \n" +
                "    name NOT LIKE 'sqlite_%';");
        for(int i = 0; i < tempString.size(); i++) {
            allTable.add((String) tempString.get(i).get(0));
        }
        return allTable;
    }

    public SQLiteTest(String name) {
        this.name = name;

    }
    @Before
    public void setUp() {
        databaseFunction = new DatabaseFunction();
        databaseFunction.initDatabase(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }


    @Test
    public void testDataBaseConnection() {
        databaseFunction.openDatabase();
        databaseFunction.getDatabaseCount(name);
        assertTrue(0 < databaseFunction.getDatabaseCount(name).size());
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("ccsf.cs195.woofy", appContext.getPackageName());
    }
}