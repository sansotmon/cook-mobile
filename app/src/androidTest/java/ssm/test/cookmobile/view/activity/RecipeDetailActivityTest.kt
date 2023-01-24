package ssm.test.cookmobile.view.activity

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.isInternal
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ssm.test.cookmobile.R


@RunWith(AndroidJUnit4::class)
class RecipeDetailActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<RecipeDetailActivity> = ActivityTestRule(
        RecipeDetailActivity::class.java
    )

    @Before
    fun setup() {
        Intents.init()
        intending(not(isInternal())).respondWith(
            Instrumentation.ActivityResult(
                Activity.RESULT_OK,
                null
            )
        )
    }

    @After
    fun clean() {
        Intents.release()
    }

    @Test
    fun onCreate() {
        onView(withId(R.id.btnLocation)).perform(click())
        onView(withId(R.id.labelDescription)).check(matches(withText(R.string.activity_recipe_detail_description)))
    }

    @Test
    fun validateIntentMap() {
        mActivityRule.launchActivity(Intent())
        intended(hasComponent(RecipeDetailActivity::class.java.name))
    }

}
