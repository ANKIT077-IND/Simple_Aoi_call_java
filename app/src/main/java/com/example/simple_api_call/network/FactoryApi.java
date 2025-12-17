package com.example.simple_api_call.network;

import com.example.simple_api_call.GetCommentsResponseClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FactoryApi {
    @GET("comments")
    Call<ArrayList<GetCommentsResponseClass>> getComments();
}
