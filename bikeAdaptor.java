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
import com.example.rentxapplication.Viewpage.ItemViewPage;
import com.example.rentxapplication.R;
import com.example.rentxapplication.models.bikeModels;

import java.util.ArrayList;

public class bikeAdaptor extends RecyclerView.Adapter<bikeAdaptor.viewHolder> {
    ArrayList<bikeModels> list;
    Context context;

    public bikeAdaptor(Context context, ArrayList<bikeModels> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.change_car, parent, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewHolder vHolder = new viewHolder(view);
        view.setLayoutParams(lp);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Glide.with(context).load(list.get(holder.getAdapterPosition()).getImageURl()).into(holder.bike_image);
        // holder.bike_image.setImageResource(list.get(holder.getAdapterPosition()).getImage());
        holder.bike_title.setText(list.get(holder.getAdapterPosition()).getBike_title());
        holder.bike_price.setText(list.get(holder.getAdapterPosition()).getBike_price());
        holder.bike_area.setText(list.get(holder.getAdapterPosition()).getBike_area());

        holder.bike_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemViewPage.class);
                intent.putExtra("Image", list.get(position).getImageURl());
                intent.putExtra("Title", list.get(position).getBike_title());
                intent.putExtra("Price", list.get(position).getBike_price());
                intent.putExtra("Area", list.get(position).getBike_area());
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

   /* public void searchDataList(ArrayList<bikeModels> searchList) {
        list = searchList;
        notifyDataSetChanged();
    }*/


    public class viewHolder extends RecyclerView.ViewHolder{

        //we create a view holder class and then declare the variable of data which we want to get from the front end

        ImageView bike_image;
        TextView bike_title,bike_price,bike_area;
        CardView bike_cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            bike_image = itemView.findViewById(R.id.profile);
            bike_title = itemView.findViewById(R.id.title);
            bike_price = itemView.findViewById(R.id.price);
            bike_area = itemView.findViewById(R.id.area);
            bike_cardView = itemView.findViewById(R.id.bike_cardView);
        }
    }

}
