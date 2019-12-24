package com.example.sride.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sride.model.WeatherDto;
import com.example.sride.repository.WeatherRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private WeatherRepository weatherRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = new WeatherRepository(application);
    }

    public LiveData<WeatherDto> getWeather(){
        return weatherRepository.getMutableLiveDrugData();
    }

    public void callAPI(String str, String date, String weekday) {
        weatherRepository.callAPI(str,date,weekday);
    }
}
