package ssm.test.cookmobile.view.adapter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ssm.test.cookmobile.R
import ssm.test.cookmobile.view.activity.RecipeListActivity


@RunWith(AndroidJUnit4::class)
class RecipeListRecyclerAdapterTest {

    private val ITEM_POSITION = 5

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<RecipeListActivity> =
        ActivityScenarioRule(RecipeListActivity::class.java)

    @Test(expected = PerformException::class)
    fun validateItemNotExist() {
        onView(withId(R.id.recipeRecycler))
            .perform(
                RecyclerViewActions.scrollTo<RecipeListRecyclerAdapter.ViewHolder>(
                    hasDescendant(withText("not in the list")))
            )
    }

    @Test(expected = PerformException::class)
    fun scrollToBelow() {
        onView(withId(R.id.recipeRecycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecipeListRecyclerAdapter.ViewHolder>(
                    ITEM_POSITION, click()
                )
            )
    }

    @Test
    fun validateIsScrollAsRecycler() {
        isRecyclable()
    }

    private fun isRecyclable(): Matcher<RecipeListRecyclerAdapter.ViewHolder?> {
        return object : TypeSafeMatcher<RecipeListRecyclerAdapter.ViewHolder?>() {
            override fun matchesSafely(item: RecipeListRecyclerAdapter.ViewHolder?): Boolean {
                item?.let {
                    return it.isRecyclable
                }
                return false
            }

            override fun describeTo(description: Description) {
                description.appendText("is recyclable")
            }
        }
    }
}