package com.example.sride.service;

import com.example.sride.model.WeatherDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiUrlService {

    @GET("{str}")
    Call<WeatherDto> getWeather(@Path("str") String str);

}
