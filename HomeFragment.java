package com.example.rentxapplication.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rentxapplication.HomePage;
import com.example.rentxapplication.R;
import com.example.rentxapplication.rentAppliances;
import com.example.rentxapplication.rentBike;
import com.example.rentxapplication.rentCar;


public class HomeFragment extends Fragment {

    private String mParam1;
    private String mParam2;
    CategoryFragment categoryFragment = new CategoryFragment();
    CardView moreView,carView,bikeView,applianceView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        moreView = view.findViewById(R.id.moreCard);
                moreView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction fr = getFragmentManager().beginTransaction();
                        fr.replace(R.id.container,new CategoryFragment());
                        fr.commit();
                    }
                });
        bikeView = view.findViewById(R.id.bikeCard);
        bikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentBike.class);
                startActivity(intent);
            }
        });
        carView = view.findViewById(R.id.carCard);
        carView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentCar.class);
                startActivity(intent);
            }
        });
        applianceView = view.findViewById(R.id.electronicsCard);
        applianceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), rentAppliances.class);
                startActivity(intent);
            }
        });


        return  view;
    }
}