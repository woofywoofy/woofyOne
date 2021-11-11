package ccsf.cs195.woofy;

import java.util.ArrayList;
import java.util.Random;

public class userData {

    private ArrayList<Integer> radioButtonId;

    // DEBUG VARIABLE
    private ArrayList<String> randomDogs;

    public userData() {
        this.radioButtonId = new ArrayList<>();

        //DEBUG VARIABLE
        this.randomDogs = new ArrayList<>();
    }

    public void add(Integer id) {
        radioButtonId.add(id);
    }

    public Integer get(Integer id) { return radioButtonId.get(id); }

    public Integer set(Integer index, Integer id) { return radioButtonId.set(index, id); }

    public int buttonSize() { return radioButtonId.size(); }

    //DEBUG FUNCTION
    public int dogSize() { return randomDogs.size(); }

}
