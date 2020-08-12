package com.venkat.mastermindgame

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)
    private lateinit var mainActivity: MainActivity
    @Before
    fun setUp() {
        mainActivity = activityTestRule.activity
    }
    @Test
    fun activity_not_null()
    {
        assertNotNull(mainActivity)
    }
    @Test
    fun verify_ui_elements_on_startup()
    {
        onView(withId(R.id.secret)).check(matches(isDisplayed()))
        onView(withId(R.id.one)).check(matches(isDisplayed()))
        onView(withId(R.id.two)).check(matches(isDisplayed()))
        onView(withId(R.id.three)).check(matches(isDisplayed()))
        onView(withId(R.id.four)).check(matches(isDisplayed()))
        onView(withId(R.id.check)).check(matches(isDisplayed()))
    }
    @After
    fun tearDown() {
    }

}