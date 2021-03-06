package com.example.sride.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sride.R;
import com.example.sride.databinding.ActivityMainBinding;
import com.example.sride.model.WeatherDataDto;
import com.example.sride.model.WeatherDto;
import com.example.sride.utils.AppUtils;
import com.example.sride.utils.DateUtils;
import com.example.sride.viewmodel.MainActivityViewModel;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentViewToActivityBinding();
        initViewModel();
        setWeatherDto();
        setLayoutClickHandler();
        observerWeatherDtoChanges();
    }

    private void observerWeatherDtoChanges() {
        mainActivityViewModel.getWeather().observe(this, new Observer<WeatherDto>() {
            @Override
            public void onChanged(WeatherDto weatherDto) {
                updateValue(weatherDto);
            }
        });
    }

    private void setLayoutClickHandler() {
        ClickHandler handlers = new ClickHandler(this);
        activityMainBinding.setClickHandler(handlers);
    }

    private void setWeatherDto() {
        activityMainBinding.setWeatherDataDto(new WeatherDataDto());
    }

    private void initViewModel() {
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }

    private void setContentViewToActivityBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
    }

    private void updateValue(final WeatherDto weatherDto) {
        if (weatherDto != null) {
            setTemperatureLayoutVisibility(View.VISIBLE);
            activityMainBinding.setWeatherDataDto(weatherDto.getCurrently());
        }
    }

    public class ClickHandler {
        Context context;

        ClickHandler(Context context) {
            this.context = context;
        }

        public void buttonClicked() {
            openDateDialogPicker();
        }
    }

    private void openDateDialogPicker() {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        activityMainBinding.dateTv.setText(DateUtils.getDateInString(
                                dayOfMonth, monthOfYear, year));
                        checkIfDateIsPrimeOrNor(dayOfMonth, monthOfYear, year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void checkIfDateIsPrimeOrNor(int dayOfMonth, int monthOfYear, int year) {
        if (AppUtils.isPrimeNumber(dayOfMonth)) {
            fetchWeatherDetails(dayOfMonth, monthOfYear, year);
        } else {
            Toast.makeText(this, getString(R.string.select_prime_date), Toast.LENGTH_LONG).show();
            setTemperatureLayoutVisibility(View.GONE);
        }
    }

    private void fetchWeatherDetails(int dayOfMonth, int monthOfYear, int year) {
        long unixTime = DateUtils.getUnixTime(dayOfMonth, monthOfYear, year);
        String date = DateUtils.getDateInString(dayOfMonth, monthOfYear, year);
        String dayOfWeek = DateUtils.getDayOfWeek(dayOfMonth, monthOfYear, year);
        callWeatherApi(unixTime, date, dayOfWeek);
    }

    private void setTemperatureLayoutVisibility(int visibility) {
        activityMainBinding.temperatureCl.setVisibility(visibility);
    }

    private void callWeatherApi(long unixTime, String date, String weekday) {
        String latLongString = "18.520430,73.856743";
        latLongString = latLongString.concat(",").concat(unixTime + "");
        mainActivityViewModel.callWeatherApi(latLongString, date, weekday);
    }
}
