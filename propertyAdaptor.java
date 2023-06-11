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
import com.example.rentxapplication.Viewpage.PropertyViewPage;
import com.example.rentxapplication.R;
import com.example.rentxapplication.models.propertyModels;

import java.util.ArrayList;

public class propertyAdaptor extends RecyclerView.Adapter<propertyAdaptor.viewHolder>  {
    ArrayList<propertyModels> list ;
    Context context;
    public propertyAdaptor(Context context, ArrayList<propertyModels> list){
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
        Glide.with(context).load(list.get(holder.getAdapterPosition()).getImageURL()).into(holder.property_image);
        //bikeModels bike_model = list.get(position);
        //holder.property_image.setImageResource(list.get(holder.getAdapterPosition()).getImage());
        holder.property_title.setText(list.get(holder.getAdapterPosition()).getProperty_title());
        holder.property_price.setText(list.get(holder.getAdapterPosition()).getProperty_price());
        holder.property_area.setText(list.get(holder.getAdapterPosition()).getProperty_area());

        holder.property_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PropertyViewPage.class);
                intent.putExtra("Image",list.get(position).getImageURL());
                intent.putExtra("Title",list.get(position).getProperty_title());
                intent.putExtra("Price",list.get(position).getProperty_price());
                intent.putExtra("Number", list.get(position).getNumber());
                intent.putExtra("Description", list.get(position).getDescription());
                intent.putExtra("Area",list.get(position).getProperty_area());
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

        ImageView property_image;
        TextView property_title,property_price,property_area;
        CardView property_cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            property_image = itemView.findViewById(R.id.profile);
            property_title = itemView.findViewById(R.id.title);
            property_price = itemView.findViewById(R.id.price);
            property_area = itemView.findViewById(R.id.area);
            property_cardView = itemView.findViewById(R.id.bike_cardView);
        }
    }

}
