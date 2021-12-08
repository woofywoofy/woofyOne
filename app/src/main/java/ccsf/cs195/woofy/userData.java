package ccsf.cs195.woofy;
/*
Program Note: This class to memorize the selections of the user with radio button ID
 */
import java.util.ArrayList;
import java.util.Random;

public class userData {

    private ArrayList<Integer> radioButtonNum;

    // DEBUG VARIABLE
    private ArrayList<String> randomDogs;

    public userData() {
        this.radioButtonNum = new ArrayList<>();

        //DEBUG VARIABLE
        this.randomDogs = new ArrayList<>();
    }

    public void add(Integer id) {
        radioButtonNum.add(id);
    }

    public Integer get(Integer id) { return radioButtonNum.get(id); }

    public Integer set(Integer index, Integer id) { return radioButtonNum.set(index, id); }

    public int buttonSize() { return radioButtonNum.size(); }

    //DEBUG FUNCTION
    public int dogSize() { return randomDogs.size(); }

}
