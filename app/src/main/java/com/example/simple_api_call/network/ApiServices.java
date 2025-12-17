package com.example.simple_api_call.network;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServices {
    private final  String baseUrl = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;
    private static ApiServices instance;
    Gson gson = new Gson().newBuilder().setLenient().create();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().
            readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .connectTimeout(15,TimeUnit.SECONDS)
            .build();

    public static ApiServices getInstance(){
      if (instance==null){
          instance = new ApiServices();
      }
      return instance;

    }

    public FactoryApi createFactoryApi(){
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(FactoryApi.class);
    }


}
