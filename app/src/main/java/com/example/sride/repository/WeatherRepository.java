package com.example.sride.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.sride.dao.WeatherDao;
import com.example.sride.db.RoomDBHelper;
import com.example.sride.model.WeatherDataDto;
import com.example.sride.model.WeatherDto;
import com.example.sride.service.RetrofitInstance;
import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private final WeatherDao weatherDto;
    private final ExecutorService executor;
    private Application application;
    private RoomDBHelper roomDBHelper;

    public WeatherRepository(Application application) {
        this.application = application;

        roomDBHelper = RoomDBHelper.get();
        weatherDto = roomDBHelper.weatherDao();
        executor = Executors.newFixedThreadPool(1);
    }

    public LiveData<WeatherDto> getMutableLiveDrugData() {
        return weatherDto.getWeather();
    }

    public void callAPI(String str, final String date, final String weekday) {
        RetrofitInstance.getV1Service().getWeather(str).enqueue(new Callback<WeatherDto>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<WeatherDto> call, Response<WeatherDto> response) {
                if (response.isSuccessful()) {
                    WeatherDto weatherDto = response.body();
                    if (weatherDto != null) {
                        WeatherDataDto weatherDtoCurrently = weatherDto.getCurrently();
                        weatherDtoCurrently.setDate(date);
                        weatherDtoCurrently.setDay(weekday);
                        insertIntoDB(weatherDto);
                    }
                }
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<WeatherDto> call, Throwable t) {
                Toast.makeText(application, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void insertIntoDB(final WeatherDto weatherDto) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                roomDBHelper.weatherDao().deleteWeather();
                roomDBHelper.weatherDao().insert(weatherDto);
            }
        });
    }
}
