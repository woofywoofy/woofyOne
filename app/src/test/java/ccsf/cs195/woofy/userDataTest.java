package ccsf.cs195.woofy;
/*
Program Note: This is to check if the userdata class is set to hold integer,
and if it will be clear after the app is close
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static junit.framework.Assert.assertTrue;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class userDataTest {

    userData ud = new userData();
    ResultPage rp = new ResultPage();

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        ud.get(1);
    }
    @Test
    public void add() {
        ud.add(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set() {
        ud.set(1,1);
    }

    @Test
    public void set2() {
        ud.add(2);
        ud.set(0,1);
        assertTrue(ud.get(0) == 1);
    }

}