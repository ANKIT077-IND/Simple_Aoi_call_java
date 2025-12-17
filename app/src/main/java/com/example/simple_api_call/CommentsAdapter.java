package com.example.simple_api_call;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simple_api_call.databinding.CommentListItemBinding;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.DataHolder> {

    ArrayList<GetCommentsResponseClass> getComments;

    void setGetComment(ArrayList<GetCommentsResponseClass> comments){
        this.getComments = comments;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CommentListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.comment_list_item,
                parent,false
                );
        return new DataHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        GetCommentsResponseClass getCommentsResponseClass = getComments.get(position);
         holder.binding.setComment(getCommentsResponseClass);
         holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return getComments.size();
    }

    class  DataHolder extends RecyclerView.ViewHolder {
        CommentListItemBinding binding;
        public DataHolder(CommentListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
