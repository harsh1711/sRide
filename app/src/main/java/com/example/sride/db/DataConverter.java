package com.example.sride.db;

import androidx.room.TypeConverter;

import com.example.sride.model.HourlyDto;
import com.example.sride.model.WeatherDataDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class DataConverter {

    @TypeConverter
    public static List<WeatherDataDto> getWeatherDataDtoList(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<List<WeatherDataDto>>() {}.getType());
    }

    @TypeConverter
    public static String saveWeatherDataDtoList(List<WeatherDataDto>listOfString) {
        return new Gson().toJson(listOfString);
    }


    @TypeConverter
    public static WeatherDataDto getWeatherDataDto(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<WeatherDataDto>() {}.getType());
    }

    @TypeConverter
    public static String saveWeatherDataDto(WeatherDataDto listOfString) {
        return new Gson().toJson(listOfString);
    }

    @TypeConverter
    public static HourlyDto getHourlyDto(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<HourlyDto>() {}.getType());
    }

    @TypeConverter
    public static String saveHourlyDto(HourlyDto listOfString) {
        return new Gson().toJson(listOfString);
    }
}
