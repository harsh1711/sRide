package com.example.sride.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.sride.dao.WeatherDao;
import com.example.sride.model.WeatherDto;

@Database(entities = {WeatherDto.class} , version = 1)
@TypeConverters(DataConverter.class)
public abstract class RoomDBHelper extends RoomDatabase {

    public abstract WeatherDao weatherDao();
    private static RoomDBHelper ourInstance = null;

    public static void init(Context context, String appName) {
        if(ourInstance == null) {
            ourInstance = Room.databaseBuilder(context,
                    RoomDBHelper.class, appName).build();
        }
    }

    public static RoomDBHelper get() {
        if(ourInstance == null) {
            throw new IllegalStateException("Call init to initialize the room database before using it.");
        }
        return ourInstance;
    }
}
