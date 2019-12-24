package com.example.sride;

import android.app.Application;

import com.example.sride.db.RoomDBHelper;
import com.example.sride.service.RetrofitInstance;

public class SRideApplication extends Application {

    private static final String APP_NAME = "sRide";
    private static final String BASE_URL = "https://api.darksky.net/forecast/ac78e232a83a3d82efed1a66d3d7165b/";

    @Override
    public void onCreate() {

        // Initialize Database object. Use a singleton object to provide access to
        // the database helper
        RoomDBHelper.init(getApplicationContext(),APP_NAME);

        // Initialize Retrofit object. Use a singleton object to provide access to
        // the network calls
        RetrofitInstance.init(getApplicationContext(),BASE_URL);
        super.onCreate();
    }
}
