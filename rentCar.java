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

import com.example.rentxapplication.adaptor.carAdaptor;
import com.example.rentxapplication.models.carModels;
import com.example.rentxapplication.upload.uploadCar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rentCar extends AppCompatActivity {


    ArrayList<carModels> carList = new ArrayList<>();
    FloatingActionButton uploadBtn;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_car);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        uploadBtn = findViewById(R.id.uploadBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), uploadCar.class);
                startActivity(intent);
            }
        });

        RecyclerView carRecycler = findViewById(R.id.car_recyclerView);
        carRecycler.setLayoutManager(new LinearLayoutManager(this));

        AlertDialog.Builder builder = new AlertDialog.Builder(rentCar.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        carAdaptor adaptor = new carAdaptor(this,carList);
        carRecycler.setAdapter(adaptor);
        databaseReference = FirebaseDatabase.getInstance().getReference("Cars Category");
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                carList.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    carModels carModels = itemSnapshot.getValue(carModels.class);
                    carModels.setKey(itemSnapshot.getKey());
                    carList.add(carModels);
                }
                adaptor.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });


    }

}