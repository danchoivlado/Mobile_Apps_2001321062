package com.example.jordanstore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList car_id, car_brand, car_model, car_power;

    CustomAdapter(Activity activity, Context context, ArrayList car_id, ArrayList car_brand, ArrayList car_model,
                  ArrayList car_power){
        this.activity = activity;
        this.context = context;
        this.car_id = car_id;
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.car_power = car_power;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.car_id_txt.setText(String.valueOf(car_id.get(position)));
        holder.car_brand.setText(String.valueOf(car_brand.get(position)));
        holder.car_model.setText(String.valueOf(car_model.get(position)));
        holder.car_power.setText(String.valueOf(car_power.get(position)));
    }

    @Override
    public int getItemCount() {
        return car_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView car_id_txt, car_brand, car_model, car_power;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            car_id_txt = itemView.findViewById(R.id.car_id_txt);
            car_brand = itemView.findViewById(R.id.car_brand_txt);
            car_model = itemView.findViewById(R.id.car_model_txt);
            car_power = itemView.findViewById(R.id.car_power_txt);
        }
    }
}
