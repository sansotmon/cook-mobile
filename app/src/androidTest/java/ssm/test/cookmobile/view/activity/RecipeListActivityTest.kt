package ssm.test.cookmobile.view.activity

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import androidx.test.rule.ActivityTestRule
import org.junit.After

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

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
    }

    @Test
    fun refreshRecycler() {
    }

    @Test
    fun validateExtraIntentRecipe() {
        mActivityRule.launchActivity(Intent())
        intended(hasComponent(RecipeListActivity::class.java.name))
    }
}