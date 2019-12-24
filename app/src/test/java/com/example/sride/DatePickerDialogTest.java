package com.example.sride;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.sride.activity.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowDatePickerDialog;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class DatePickerDialogTest {

    private Activity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void returnsTheInitialYearMonthAndDayPassedIntoTheDatePickerDialog() {
        activity.findViewById(R.id.selectDateCl).performClick();

        Locale.setDefault(Locale.US);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(activity.getApplicationContext(), null, 2012,
                        6, 7);
        datePickerDialog.onDateChanged(datePickerDialog.getDatePicker(),2012,
                6,7);

        assertEquals(2012, shadowOf(datePickerDialog).getYear());
        assertEquals(6, shadowOf(datePickerDialog).getMonthOfYear());
        assertEquals(7, shadowOf(datePickerDialog).getDayOfMonth());

        TextView textView = activity.findViewById(R.id.dateTv);
        assertNotNull("TextView is null", textView);
        textView.setText("7-7-2012");
        assertEquals("7-7-2012", textView.getText().toString());
    }

    @Test
    public void savesTheCallback() {
        DatePickerDialog.OnDateSetListener expectedDateSetListener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        // ignored
                    }
                };

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(activity.getApplicationContext(), expectedDateSetListener,
                        2012, 6, 7);
        ShadowDatePickerDialog shadowDatePickerDialog = shadowOf(datePickerDialog);
        assertEquals(shadowDatePickerDialog.getOnDateSetListenerCallback(), expectedDateSetListener);
    }
}

