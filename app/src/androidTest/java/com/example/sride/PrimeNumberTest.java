package com.example.sride;

import android.content.Context;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.sride.activity.MainActivity;
import com.example.sride.utils.AppUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4ClassRunner.class)
public class PrimeNumberTest {

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
    public void isPrimeNumberSuccessTest() {
        Log.e("@Test", "Performing Prime Number Success Test Case");
        boolean primeNumber =  AppUtils.isPrimeNumber(7);
        assertTrue(primeNumber);
    }

    @Test
    public void isPrimeNumberFail() {
        Log.e("@Test", "Performing Prime Number Failure Test Case");
        boolean primeNumber = AppUtils.isPrimeNumber(6);
        assertFalse(primeNumber);
    }

    @Test
    public void datePickerDialogTest() {
        Log.e("@Test", "Performing date check test");


        Espresso.onView((withId(R.id.selectDateCl)))
                .perform(ViewActions.click());


        // Run the Looper (this call is to be added)


       /* Espresso.onView((withId(R.id.calendarRl)))
                .perform(ViewActions.click());*/

       /* Looper.prepare();
        Looper.loop();
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(ApplicationProvider.getApplicationContext(), null, 2012, 6, 7);
        datePickerDialog.onDateChanged(datePickerDialog.getDatePicker(),2012,6,7);
        datePickerDialog.dismiss();
        Looper.myLooper().quit();

        Espresso.onView(withId(R.id.dateTv))
                .check(matches(withText("7" + "-" + (6 + 1) + "-" + "2012")));*/


        /*getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                Espresso.onView((withId(R.id.calendarRl)))
                        .perform(ViewActions.click());

                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(ApplicationProvider.getApplicationContext(), null, 2012, 6, 7);
                datePickerDialog.onDateChanged(datePickerDialog.getDatePicker(),2012,6,7);
                datePickerDialog.dismiss();

                Espresso.onView(withId(R.id.dateTv))
                        .check(matches(withText("7" + "-" + (6 + 1) + "-" + "2012")));

            }
        });*/

       /* getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Espresso.onView(withId(R.id.dateTv))
                        .check(matches(withText("7" + "-" + (6 + 1) + "-" + "2012")));
            }
        });*/


        /*Espresso.onView(withId(R.id.dateTv))
                .check(matches(withText("7" + "-" + (6 + 1) + "-" + "2012")));*/


        /*new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                Espresso.onView((withId(R.id.calendarRl)))
                        .perform(ViewActions.click());

                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(mActivityRule.getActivity(), null, 2012, 6, 7);

                datePickerDialog.dismiss();

                Espresso.onView(withId(R.id.dateTv))
                        .check(matches(withText("7" + "-" + (6 + 1) + "-" + "2012")));
            }
        });*/



        /*Espresso.onView(withId(R.id.dateTv))
                .check(matches(withText("7" + "-" + (6 + 1) + "-" + "2012")));*/


    }
}
