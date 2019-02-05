package com.example.yodi.yourssu_appstudy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView tvTitle;
        TextView tvDescription;

        MyViewHolder(View view) {
            super(view);
            ivPicture = view.findViewById(R.id.imageView);
            tvTitle = view.findViewById(R.id.textView);
            tvDescription = view.findViewById(R.id.textView2);
        }
    }

    private ArrayList<MyItem> myItemArrayList;

    MyAdapter(ArrayList<MyItem> myItemArrayList) {
        this.myItemArrayList = myItemArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.ivPicture.setImageResource(myItemArrayList.get(position).getDrawableId());
        myViewHolder.tvTitle.setText(myItemArrayList.get(position).getTitle());
        myViewHolder.tvDescription.setText(myItemArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return myItemArrayList.size();
    }
}