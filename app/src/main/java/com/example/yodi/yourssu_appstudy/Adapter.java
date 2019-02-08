package com.example.yodi.yourssu_appstudy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Fruit> mFruit;

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView id;
        protected TextView eng;
        protected TextView kor;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.id = (TextView)view.findViewById(R.id.textviewId);
            this.eng = (TextView)view.findViewById(R.id.textviewEng);
            this.kor = (TextView)view.findViewById(R.id.textviewKor);
        }
    }

    public Adapter(ArrayList<Fruit> list){
        this.mFruit = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.id.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        viewHolder.eng.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        viewHolder.kor.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);

        viewHolder.id.setGravity(Gravity.CENTER);
        viewHolder.eng.setGravity(Gravity.CENTER);
        viewHolder.kor.setGravity(Gravity.CENTER);

        viewHolder.id.setText(mFruit.get(position).getId());
        viewHolder.eng.setText(mFruit.get(position).getFruit_eng());
        viewHolder.kor.setText(mFruit.get(position).getFruit_kor());
    }

    @Override
    public int getItemCount() {
        return (null != mFruit ? mFruit.size() : 0);
    }
}
