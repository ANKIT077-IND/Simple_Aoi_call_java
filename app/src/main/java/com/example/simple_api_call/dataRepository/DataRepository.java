package com.example.simple_api_call.dataRepository;

import androidx.lifecycle.MutableLiveData;

import com.example.simple_api_call.GetCommentsResponseClass;
import com.example.simple_api_call.network.ApiServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    MutableLiveData<ArrayList<GetCommentsResponseClass>> commentList = new MutableLiveData<>();

    public MutableLiveData<ArrayList<GetCommentsResponseClass>> getComment(){

        ApiServices apiServices = ApiServices.getInstance();
        Call<ArrayList<GetCommentsResponseClass>> call = apiServices.createFactoryApi().getComments();
        call.enqueue(new Callback<ArrayList<GetCommentsResponseClass>>() {
            @Override
            public void onResponse(Call<ArrayList<GetCommentsResponseClass>> call, Response<ArrayList<GetCommentsResponseClass>> response) {
                if (response.body()!=null && response.isSuccessful()){
                    commentList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GetCommentsResponseClass>> call, Throwable t) {
                commentList.setValue(null);
            }
        });
        return commentList;

    }
}
