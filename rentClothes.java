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

import com.example.rentxapplication.adaptor.clothesAdaptor;
import com.example.rentxapplication.models.clothesModels;
import com.example.rentxapplication.upload.uploadClothes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rentClothes extends AppCompatActivity {


    ArrayList<clothesModels> list = new ArrayList<>();
    FloatingActionButton uploadBtn;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_clothes);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        uploadBtn = findViewById(R.id.uploadBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), uploadClothes.class);
                startActivity(intent);
            }
        });

        RecyclerView clothesRecycler = findViewById(R.id.clothes_recyclerView);
        clothesRecycler.setLayoutManager(new LinearLayoutManager(this));

        AlertDialog.Builder builder = new AlertDialog.Builder(rentClothes.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();


        clothesAdaptor adapter = new clothesAdaptor(this, list);
        clothesRecycler.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Clothes Category");
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    clothesModels clothesModels = itemSnapshot.getValue(clothesModels.class);

                    clothesModels.setKey(itemSnapshot.getKey());

                    list.add(clothesModels);
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