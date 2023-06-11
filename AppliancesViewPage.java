package com.example.rentxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AppliancesViewPage extends AppCompatActivity {
    TextView profileTitle,profilePrice,profileArea;
    ImageView profileImg;
    FloatingActionButton deleteButton,editButton;
    String key = "";
    String imageUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances_view_page);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        profileImg = findViewById(R.id.profileImage);
        profileTitle = findViewById(R.id.profileTitle);
        profilePrice = findViewById(R.id.profilePrice);
        profileArea = findViewById(R.id.profileArea);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);

        int int_profileImage =getIntent().getIntExtra("Image",0);
        profileImg.setImageResource(int_profileImage);
        profileTitle.setText(getIntent().getExtras().getString("Title"));
        profilePrice.setText(getIntent().getExtras().getString("Price"));
        profileArea.setText(getIntent().getExtras().getString("Area"));

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            profileTitle.setText(bundle.getString("Title"));
            profilePrice.setText(bundle.getString("Price"));
            profileArea.setText(bundle.getString("Area"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");

            Glide.with(this).load(getIntent().getExtras().getString("Image")).into(profileImg);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Appliances Category");
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(AppliancesViewPage.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), rentAppliances.class));
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppliancesViewPage.this, updateAppliance.class)
                        .putExtra("Title", profileTitle.getText().toString())
                        .putExtra("Price", profilePrice.getText().toString())
                        .putExtra("Area", profileArea.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });
    }
}