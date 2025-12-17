package com.example.simple_api_call.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.simple_api_call.GetCommentsResponseClass;
import com.example.simple_api_call.dataRepository.DataRepository;

import java.util.ArrayList;

public class DataViewModel extends ViewModel {
   private  DataRepository dataRepository;

    public DataViewModel() {
        this.dataRepository = new DataRepository();
    }

    public MutableLiveData<ArrayList<GetCommentsResponseClass>> getComment(){
        return dataRepository.getComment();
    }
}
