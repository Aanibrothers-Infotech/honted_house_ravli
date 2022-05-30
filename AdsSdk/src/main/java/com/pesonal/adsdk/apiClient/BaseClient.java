package com.pesonal.adsdk.apiClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {

    private static Retrofit retrofit = null;

  public   static Retrofit getClient() {



        retrofit = new Retrofit.Builder()
                .baseUrl("https://extreamapps.co.in/AppsManager/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }
}
