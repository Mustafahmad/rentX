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

import com.example.rentxapplication.adaptor.propertyAdaptor;
import com.example.rentxapplication.models.propertyModels;
import com.example.rentxapplication.upload.uploadProperty;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rentProperty extends AppCompatActivity {


    ArrayList<propertyModels> list = new ArrayList<>();
    FloatingActionButton uploadBtn;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_property);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        uploadBtn = findViewById(R.id.uploadBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), uploadProperty.class);
                startActivity(intent);
            }
        });

        RecyclerView propertyRecycler = findViewById(R.id.property_recyclerView);
        propertyRecycler.setLayoutManager(new LinearLayoutManager(this));

        AlertDialog.Builder builder = new AlertDialog.Builder(rentProperty.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();


        propertyAdaptor adapter = new propertyAdaptor(this, list);
        propertyRecycler.setAdapter(adapter);




        databaseReference = FirebaseDatabase.getInstance().getReference("Property Category");
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    propertyModels propertyModels = itemSnapshot.getValue(propertyModels.class);
                    propertyModels.setKey(itemSnapshot.getKey());
                    list.add(propertyModels);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });


    }

}