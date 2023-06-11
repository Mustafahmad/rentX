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
import com.example.rentxapplication.Viewpage.AppliancesViewPage;
import com.example.rentxapplication.R;
import com.example.rentxapplication.models.applianceModels;

import java.util.ArrayList;

public class applianceAdaptor extends RecyclerView.Adapter<applianceAdaptor.viewHolder>  {
    ArrayList<applianceModels> list ;
    Context context;
    public applianceAdaptor(Context context, ArrayList<applianceModels> list){
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.change_car,parent,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewHolder vHolder = new viewHolder(view);
        view.setLayoutParams(lp);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Glide.with(context).load(list.get(holder.getAdapterPosition()).getImageURL()).into(holder.appliance_image);
        //bikeModels bike_model = list.get(position);
        //holder.appliance_image.setImageResource(list.get(position).getApplianceImage());
        holder.appliance_title.setText(list.get(position).getAppliance_title());
        holder.appliance_price.setText(list.get(position).getAppliance_price());
        holder.appliance_area.setText(list.get(position).getAppliance_area());


        holder.bike_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AppliancesViewPage.class);
                intent.putExtra("Image",list.get(position).getImageURL());
                intent.putExtra("Title",list.get(position).getAppliance_title());
                intent.putExtra("Price",list.get(position).getAppliance_price());
                intent.putExtra("Area",list.get(position).getAppliance_area());
                intent.putExtra("Number", list.get(position).getAppliNumber());
                intent.putExtra("Description", list.get(position).getAppliDescription());
                intent.putExtra("Key", list.get(position).getKey());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        //we create a view holder class and then declare the variable of data which we want to get from the front end

        ImageView appliance_image;
        TextView appliance_title,appliance_price,appliance_area;
        CardView bike_cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            appliance_image = itemView.findViewById(R.id.profile);
            appliance_title = itemView.findViewById(R.id.title);
            appliance_price = itemView.findViewById(R.id.price);
            appliance_area = itemView.findViewById(R.id.area);
            bike_cardView = itemView.findViewById(R.id.bike_cardView);
        }
    }

}
