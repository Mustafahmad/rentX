package com.example.rentxapplication.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rentxapplication.Viewpage.CarViewPage;
import com.example.rentxapplication.R;
import com.example.rentxapplication.models.carModels;

import java.util.ArrayList;

public class carAdaptor extends RecyclerView.Adapter<carAdaptor.viewHolder>  {
    ArrayList<carModels> carlist ;
    Context context;
    public carAdaptor(Context context, ArrayList<carModels> carlist){
        this.context = context;
        this.carlist = carlist;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.change_car2,parent,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewHolder vHolder = new viewHolder(view);
        view.setLayoutParams(lp);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int Position) {
        //bikeModels bike_model = list.get(position);
        Glide.with(context).load(carlist.get(holder.getAdapterPosition()).getImageURL()).into(holder.car_image);
       // holder.car_image.setImageResource(carlist.get(Position).getCar_image());
        holder.car_title.setText(carlist.get(Position).getCar_title());
        holder.car_price.setText(carlist.get(Position).getCar_price());
        holder.car_area.setText(carlist.get(Position).getCar_area());

        holder.car_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CarViewPage.class);
                intent.putExtra("Image",carlist.get(Position).getImageURL());
                intent.putExtra("Title",carlist.get(Position).getCar_title());
                intent.putExtra("Price",carlist.get(Position).getCar_price());
                intent.putExtra("Area",carlist.get(Position).getCar_area());
                intent.putExtra("Number", carlist.get(Position).getCar_number());
                intent.putExtra("Description", carlist.get(Position).getCar_description());
                intent.putExtra("Key", carlist.get(Position).getKey());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        //we create a view holder class and then declare the variable of data which we want to get from the front end

        ImageView car_image;
        TextView car_title,car_price,car_area;
        CardView car_cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            car_image = itemView.findViewById(R.id.profile_car);
            car_title = itemView.findViewById(R.id.title_car);
            car_price = itemView.findViewById(R.id.price_car);
            car_area = itemView.findViewById(R.id.area_car);
            car_cardView = itemView.findViewById(R.id.car_cardView);
        }
    }

}
