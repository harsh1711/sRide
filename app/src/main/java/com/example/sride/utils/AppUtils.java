package com.example.sride.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.math.BigInteger;

public class AppUtils {

    public static boolean isPrimeNumber(int dayOfMonth) {
        BigInteger bigInteger = new BigInteger(String.valueOf(dayOfMonth));
        return bigInteger.isProbablePrime(1);
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean isNetworkAvailable = true;
        if(context != null){
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectivityManager != null){
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                isNetworkAvailable = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
        }
       return isNetworkAvailable;
    }
}
