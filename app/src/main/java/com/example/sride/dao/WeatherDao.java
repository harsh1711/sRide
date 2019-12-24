package com.example.sride.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.sride.model.WeatherDto;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather_table")
    LiveData<WeatherDto> getWeather();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherDto weatherDto);

    @Query("DELETE FROM weather_table")
    void deleteWeather();
}
