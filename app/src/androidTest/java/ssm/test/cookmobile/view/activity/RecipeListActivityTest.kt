package ssm.test.cookmobile.view.activity

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import ssm.test.cookmobile.R.id.recipeSearch
import ssm.test.cookmobile.R.string.activity_recipe_list_title


import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ssm.test.cookmobile.R.id.titleText

@RunWith(AndroidJUnit4::class)
class RecipeListActivityTest{

    @get:Rule
    var mActivityRule: ActivityTestRule<RecipeListActivity> = ActivityTestRule(
        RecipeListActivity::class.java
    )

    @Before
    fun setup() {
        Intents.init()
        intending(not(IntentMatchers.isInternal())).respondWith(
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
        onView(withId(recipeSearch)).perform(click())
        onView(withId(titleText)).check(matches(withText(activity_recipe_list_title)))
    }

    @Test
    fun validateExtraIntentRecipe() {
        mActivityRule.launchActivity(Intent())
        intended(hasComponent(RecipeListActivity::class.java.name))
    }
}