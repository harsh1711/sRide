package com.example.sride;

import android.content.Context;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.sride.activity.MainActivity;
import com.example.sride.utils.DateUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4ClassRunner.class)
public class DataUtilsTest {

    private Context appContext;

    @Test
    public void useAppContext() {
        appContext = ApplicationProvider.getApplicationContext();
        assertEquals("com.example.sride", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void weekDayStringSuccessTest() {
        Log.e("@Test", "Performing Week Day String Success Test Case");
        String dayString = DateUtils.getDayString(1);
        assertEquals("sunday",dayString.toLowerCase());
    }

    @Test
    public void weekDayStringFailureTest() {
        Log.e("@Test", "Performing Week Day String Failure Test Case");
        String dayString = DateUtils.getDayString(1);
        assertTrue(!"monday".equalsIgnoreCase(dayString.toLowerCase()));
    }


    @Test
    public void DateInStringSuccessTest() {
        Log.e("@Test", "Performing Date In String Success Test Case");
        String dayString = DateUtils.getDateInString(17,10,1992);
        assertEquals("17-11-1992",dayString.toLowerCase());
    }

    @Test
    public void DateInStringFailureTest() {
        Log.e("@Test", "Performing Date In String Failure Test Case");
        String dayString = DateUtils.getDateInString(17,11,1992);
        assertTrue(!"17-11-1993".equalsIgnoreCase(dayString.toLowerCase()));
    }
}
