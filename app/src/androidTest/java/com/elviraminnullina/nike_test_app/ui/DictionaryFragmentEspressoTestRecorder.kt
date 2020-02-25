package com.elviraminnullina.nike_test_app.ui

import androidx.fragment.app.FragmentTransaction
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.elviraminnullina.nike_test_app.MainActivity
import com.elviraminnullina.nike_test_app.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DictionaryFragmentEspressoTestRecorder {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(
        MainActivity::class.java
    )

    @Test
    fun testEventFragment() {
        activityActivityTestRule.activity
            .runOnUiThread(Runnable { val fragment: DictionaryFragment? = startFragment() })
        onView(withId(R.id.sort_by_textView)).check(matches(withText("Sort by")))
    }

    private fun startFragment(): DictionaryFragment? {
        val activity: MainActivity = activityActivityTestRule.activity as MainActivity
        val transaction: FragmentTransaction =
            activity.supportFragmentManager.beginTransaction()
        val voiceFragment = DictionaryFragment()
        transaction.add(voiceFragment, "voiceFragment")
        transaction.commit()
        return voiceFragment
    }
}
