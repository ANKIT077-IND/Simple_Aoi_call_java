package com.example.simple_api_call;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.simple_api_call.databinding.ActivityMainBinding;
import com.example.simple_api_call.viewModel.DataViewModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DataViewModel dataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        binding.pb.setVisibility(View.VISIBLE);
        getData();
    }

    private void getData() {
        dataViewModel.getComment().observe(this, new Observer<ArrayList<GetCommentsResponseClass>>() {
            @Override
            public void onChanged(ArrayList<GetCommentsResponseClass> getCommentsResponseClasses) {
                binding.pb.setVisibility(View.GONE);
                try{
                    if (getCommentsResponseClasses!=null){
                       binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                       CommentsAdapter commentsAdapter = new CommentsAdapter();
                       binding.recyclerView.setAdapter(commentsAdapter);
                        commentsAdapter.setGetComment(getCommentsResponseClasses);
                    }
                }
                catch (Exception e){

                }
            }
        });
    }
}