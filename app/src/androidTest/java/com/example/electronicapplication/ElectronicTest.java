package com.example.electronicapplication;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ElectronicTest {
    @Rule
    public ActivityTestRule<BookingActivity> testRule = new ActivityTestRule<>(BookingActivity.class);
    String expected = "true";

    @Test
    public void ElectronicTest() {
        onView(withId(R.id.cfullname))
                .perform(typeText("ayushprasai"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.ccontact))
                .perform(typeText("987654321"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.clocation))
                .perform(typeText("jadibuti"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.cproblem))
                .perform(typeText("television"))
                .perform(ViewActions.closeSoftKeyboard());


        onView(withId(R.id.btncbook)).perform(click());
    }
}