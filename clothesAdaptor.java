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
import com.example.rentxapplication.Viewpage.ClothesViewPage;
import com.example.rentxapplication.R;
import com.example.rentxapplication.models.clothesModels;

import java.util.ArrayList;

public class clothesAdaptor extends RecyclerView.Adapter<clothesAdaptor.viewHolder>  {
    ArrayList<clothesModels> list ;
    Context context;
    public clothesAdaptor(Context context, ArrayList<clothesModels> list){
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
        Glide.with(context).load(list.get(holder.getAdapterPosition()).getImageURL()).into(holder.clothes_image);
        //bikeModels bike_model = list.get(position);
       // holder.clothes_image.setImageResource(list.get(position).getImage());
        holder.clothes_title.setText(list.get(position).getClothes_title());
        holder.clothes_price.setText(list.get(position).getClothes_price());
        holder.clothes_area.setText(list.get(position).getClothes_area());

        holder.clothes_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ClothesViewPage.class);
                intent.putExtra("Image",list.get(position).getImageURL());
                intent.putExtra("Title",list.get(position).getClothes_title());
                intent.putExtra("Price",list.get(position).getClothes_price());
                intent.putExtra("Area",list.get(position).getClothes_area());
                intent.putExtra("Number", list.get(position).getNumber());
                intent.putExtra("Description", list.get(position).getDescription());
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

        ImageView clothes_image;
        TextView clothes_title,clothes_price,clothes_area;
        CardView clothes_cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            clothes_image = itemView.findViewById(R.id.profile);
            clothes_title = itemView.findViewById(R.id.title);
            clothes_price = itemView.findViewById(R.id.price);
            clothes_area = itemView.findViewById(R.id.area);
            clothes_cardView = itemView.findViewById(R.id.bike_cardView);
        }
    }

}
