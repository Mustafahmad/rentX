package com.example.rentxapplication.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rentxapplication.R;
import com.example.rentxapplication.rentAppliances;
import com.example.rentxapplication.rentBike;
import com.example.rentxapplication.rentCar;
import com.example.rentxapplication.rentClothes;
import com.example.rentxapplication.rentProperty;


public class CategoryFragment extends Fragment {

    CardView carView,bikeView,applianceView,clothesView,propertyView;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        // Inflate the layout for this fragment
        carView = view.findViewById(R.id.Car);
        carView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentCar.class);
                startActivity(intent);
            }
        });

        bikeView =view.findViewById(R.id.bike);
        bikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentBike.class);
                startActivity(intent);
            }
        });
        applianceView =view.findViewById(R.id.appliances);
        applianceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentAppliances.class);
                startActivity(intent);
            }
        });
        clothesView =view.findViewById(R.id.clothes);
        clothesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentClothes.class);
                startActivity(intent);
            }
        });
        propertyView =view.findViewById(R.id.property);
        propertyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentProperty.class);
                startActivity(intent);
            }
        });

        
       return view;
    }
}