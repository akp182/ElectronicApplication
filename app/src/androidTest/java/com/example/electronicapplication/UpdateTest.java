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
public class UpdateTest {
    @Rule
    public ActivityTestRule<UpdateActivity> testRule = new ActivityTestRule<>(UpdateActivity.class);

    @Test
    public void UpdateTest() {

        onView(withId(R.id.tvFirst))
                .perform(typeText("aayush"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.tvLast))
                .perform(typeText("prasai"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.tvPhone))
                .perform(typeText("987654321"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.tvUser))
                .perform(typeText("akptop"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btnUpdate)).perform(click());
    }
}