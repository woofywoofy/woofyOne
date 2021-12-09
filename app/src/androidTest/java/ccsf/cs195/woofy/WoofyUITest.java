package ccsf.cs195.woofy;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WoofyUITest {

    @Rule
    public ActivityTestRule<LandingPage> mActivityTestRule = new ActivityTestRule<>(LandingPage.class);

    @Test //This is an automated test function. #1
    public void WoofyUITest1() throws Exception {

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button_begin), withText("Begin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.next_button), withText("Understand"),
                        childAtPosition(
                                allOf(withId(R.id.inscontent),
                                        childAtPosition(
                                                withId(R.id.instructio_scroll),
                                                0)),
                                2)));
        appCompatButton2.perform(scrollTo(), click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.radio_two), withText("Apartmant"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton3.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton2 = onView(
                allOf(withId(R.id.radio_one), withText("<20"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton2.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton4.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton3 = onView(
                allOf(withId(R.id.radio_two), withText("Planning"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton3.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton5.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton4 = onView(
                allOf(withId(R.id.radio_three), withText("1 hour - 1.5 hours"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton4.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton6.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton5 = onView(
                allOf(withId(R.id.radio_two), withText("I don't mind"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton5.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton7.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton6 = onView(
                allOf(withId(R.id.radio_three), withText("Yes I do"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton6.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton8.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton9.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton7 = onView(
                allOf(withId(R.id.radio_one), withText("Not at all"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton7.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton10.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton8 = onView(
                allOf(withId(R.id.radio_three), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton8.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton11.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton9 = onView(
                allOf(withId(R.id.radio_two), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton9.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton12.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton10 = onView(
                allOf(withId(R.id.radio_one), withText("Inside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton10.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton13.perform(click());

        Thread.sleep(500);

        pressBack();

        Thread.sleep(500);

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton14.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton11 = onView(
                allOf(withId(R.id.radio_one), withText("Not at all"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton11.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton15.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton12 = onView(
                allOf(withId(R.id.radio_three), withText("Outside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton12.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton16.perform(click());

        Thread.sleep(500);

        pressBack();

        Thread.sleep(500);

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton17.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton18.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton19 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton19.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton20 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton20.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton21 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton21.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton13 = onView(
                allOf(withId(R.id.radio_two), withText("20~49"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton13.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton22 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton22.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton14 = onView(
                allOf(withId(R.id.radio_one), withText("No"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton14.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton23 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton23.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton15 = onView(
                allOf(withId(R.id.radio_one), withText("<30 mins"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton15.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton24 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton24.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton25 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton25.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton16 = onView(
                allOf(withId(R.id.radio_two), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton16.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton26 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton26.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton17 = onView(
                allOf(withId(R.id.radio_one), withText("Inside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton17.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton27 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton27.perform(click());

        Thread.sleep(500);
    }

    @Test //This is an automated test function. #2
    public void WoofyUITest2() throws Exception{
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button_begin), withText("Begin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.next_button), withText("Understand"),
                        childAtPosition(
                                allOf(withId(R.id.inscontent),
                                        childAtPosition(
                                                withId(R.id.instructio_scroll),
                                                0)),
                                2)));
        appCompatButton2.perform(scrollTo(), click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.radio_one), withText("Single/Town House"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton3.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton2 = onView(
                allOf(withId(R.id.radio_two), withText("20~49"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton2.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton4.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton3 = onView(
                allOf(withId(R.id.radio_three), withText("Yes"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton3.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton5.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton4 = onView(
                allOf(withId(R.id.radio_four), withText("> 1.5 hours"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                3),
                        isDisplayed()));
        materialRadioButton4.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton6.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton5 = onView(
                allOf(withId(R.id.radio_one), withText("Yes, I'm allergic"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton5.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton7.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton6 = onView(
                allOf(withId(R.id.radio_two), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton6.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton8.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton7 = onView(
                allOf(withId(R.id.radio_three), withText("Outside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton7.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton9.perform(click());

        Thread.sleep(500);

        pressBack();

        Thread.sleep(500);

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton10.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton11.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton12.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton13.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton8 = onView(
                allOf(withId(R.id.radio_two), withText("Planning"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton8.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton14.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton15.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton16.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton9 = onView(
                allOf(withId(R.id.radio_three), withText("Yes I do"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton9.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton17.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton10 = onView(
                allOf(withId(R.id.radio_three), withText("Outside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton10.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton18.perform(click());

        Thread.sleep(500);
    }

    @Test //This is an automated test function. #3
    public void WoofyUITest3() throws Exception {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button_begin), withText("Begin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.next_button), withText("Understand"),
                        childAtPosition(
                                allOf(withId(R.id.inscontent),
                                        childAtPosition(
                                                withId(R.id.instructio_scroll),
                                                0)),
                                2)));
        appCompatButton2.perform(scrollTo(), click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.radio_two), withText("Apartmant"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton3.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton2 = onView(
                allOf(withId(R.id.radio_two), withText("20~49"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton2.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton4.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton3 = onView(
                allOf(withId(R.id.radio_two), withText("Planning"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton3.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton5.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton4 = onView(
                allOf(withId(R.id.radio_three), withText("1 hour - 1.5 hours"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton4.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton6.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton5 = onView(
                allOf(withId(R.id.radio_two), withText("I don't mind"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton5.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton7.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton6 = onView(
                allOf(withId(R.id.radio_four), withText("Not sure"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                3),
                        isDisplayed()));
        materialRadioButton6.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton8.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton7 = onView(
                allOf(withId(R.id.radio_two), withText("Inside & Outside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton7.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton9.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton8 = onView(
                allOf(withId(R.id.radio_one), withText("Not at all"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton8.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton10.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton9 = onView(
                allOf(withId(R.id.radio_three), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton9.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton11.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton10 = onView(
                allOf(withId(R.id.radio_two), withText("30 mins - 1 hour"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton10.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton12.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton13.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton11 = onView(
                allOf(withId(R.id.radio_two), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton11.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton14.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton12 = onView(
                allOf(withId(R.id.radio_three), withText("Outside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton12.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton15.perform(click());

        Thread.sleep(500);

        pressBack();

        Thread.sleep(500);

        ViewInteraction materialRadioButton13 = onView(
                allOf(withId(R.id.radio_one), withText("Inside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton13.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton16.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton14 = onView(
                allOf(withId(R.id.radio_one), withText("Not at all"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton14.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(R.id.previous_button), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                5),
                        isDisplayed()));
        appCompatButton17.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton15 = onView(
                allOf(withId(R.id.radio_four), withText("I do mind"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                3),
                        isDisplayed()));
        materialRadioButton15.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton18.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton16 = onView(
                allOf(withId(R.id.radio_two), withText("Some what"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                1),
                        isDisplayed()));
        materialRadioButton16.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton19 = onView(
                allOf(withId(R.id.next_button), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton19.perform(click());

        Thread.sleep(500);

        ViewInteraction materialRadioButton17 = onView(
                allOf(withId(R.id.radio_three), withText("Outside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                2),
                        isDisplayed()));
        materialRadioButton17.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton20 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton20.perform(click());

        Thread.sleep(500);

        pressBack();

        Thread.sleep(500);

        ViewInteraction materialRadioButton18 = onView(
                allOf(withId(R.id.radio_one), withText("Inside"),
                        childAtPosition(
                                allOf(withId(R.id.radioButtonGroup),
                                        childAtPosition(
                                                withId(R.id.content),
                                                3)),
                                0),
                        isDisplayed()));
        materialRadioButton18.perform(click());

        Thread.sleep(500);

        ViewInteraction appCompatButton21 = onView(
                allOf(withId(R.id.next_button), withText("Go Fetch"),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        appCompatButton21.perform(click());

        Thread.sleep(500);
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
