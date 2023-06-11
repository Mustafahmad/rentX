package com.example.rentxapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.rentxapplication.adaptor.bikeAdaptor;
import com.example.rentxapplication.models.bikeModels;
import com.example.rentxapplication.upload.uploadItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rentBike extends AppCompatActivity {


 ArrayList<bikeModels> list = new ArrayList<>();

 FloatingActionButton uploadBtn;
 DatabaseReference databaseReference;
 ValueEventListener eventListener;
 // SearchView searchView;
 bikeAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_bike);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        uploadBtn = findViewById(R.id.uploadBtn);
      /*  searchView = findViewById(R.id.search);
        searchView.clearFocus();*/


        RecyclerView bikeRecycler = findViewById(R.id.bike_recyclerView);
        bikeRecycler.setLayoutManager(new LinearLayoutManager(this));

        AlertDialog.Builder builder = new AlertDialog.Builder(rentBike.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();


        adaptor = new bikeAdaptor(this, list);
        bikeRecycler.setAdapter(adaptor);



        databaseReference = FirebaseDatabase.getInstance().getReference("Bike Category");
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    bikeModels bikeModels = itemSnapshot.getValue(bikeModels.class);

                    bikeModels.setKey(itemSnapshot.getKey());

                    list.add(bikeModels);
                }
                adaptor.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            dialog.dismiss();
            }
        });

        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });*/

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), uploadItem.class);
                startActivity(intent);
            }
        });

    }
   /* public void searchList(String Text){
        ArrayList<bikeModels> searchList = new ArrayList<>();
        for (bikeModels bikeModels : list){
            if(bikeModels.getBike_title().toLowerCase().contains(Text.toLowerCase())){
                searchList.add(bikeModels);
            }
        }
       // adaptor.searchDataList(searchList);
    }*/


}