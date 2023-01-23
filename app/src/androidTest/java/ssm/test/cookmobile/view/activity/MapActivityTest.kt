package ssm.test.cookmobile.view.activity


import android.content.Context
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ssm.test.cookmobile.R


@RunWith(AndroidJUnit4::class)
class MapActivityTest {

    @get:Rule
    var mActivityRule: ActivityTestRule<MapActivity> = ActivityTestRule(
        MapActivity::class.java
    )

    @Test
    @Throws(Exception::class)
    fun validateAppContext() {
        // Context of the app under test.
        val appContext: Context = getTargetContext()
        Assert.assertEquals("ssm.test.cookmobile", appContext.getPackageName())
    }

    @Test
    fun onCreate() {
        onView(withId(R.id.map)).perform(click())
        val device = UiDevice.getInstance(getInstrumentation())
        val marker = device.findObject(UiSelector().clickable(true))
        marker.click()
    }

}