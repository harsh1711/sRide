package com.example.sride.service;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private Context context;
    private static ApiUrlService apiUrlService;


    public static void init(Context context, String urlPrefix) {
        new RetrofitInstance(context, urlPrefix);
    }

    public static ApiUrlService getV1Service() {
        if (apiUrlService == null) {
            throw new RuntimeException("Call RetrofitInstance.init() first");
        }
        return apiUrlService;
    }


    private RetrofitInstance(Context context, String urlPrefix) {
        this.context = context;
        Retrofit instance = new Retrofit.Builder().baseUrl(urlPrefix).
                addConverterFactory(GsonConverterFactory.create()).client(provideOkHttpClient()).build();
        apiUrlService = instance.create(ApiUrlService.class);
    }


    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        return okhttpClientBuilder.build();
    }

}
