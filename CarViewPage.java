package com.example.rentxapplication.Viewpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rentxapplication.R;
import com.example.rentxapplication.rentCar;
import com.example.rentxapplication.update.updateCar;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CarViewPage extends AppCompatActivity {
    TextView profileTitle,profilePrice,profileArea,number,desc;
    ImageView profileImg;
    Button callDialer;
    FloatingActionButton deleteButton,editButton;
    String key = "";
    String imageUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_view_page);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        profileImg = findViewById(R.id.profileImage);
        profileTitle = findViewById(R.id.profileTitle);
        profilePrice = findViewById(R.id.profilePrice);
        profileArea = findViewById(R.id.profileArea);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);
        number = findViewById(R.id.carNumber);
        desc = findViewById(R.id.carDescription);
        callDialer = findViewById(R.id.numberDialer);

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
            number.setText(bundle.getString("Number"));
            desc.setText(bundle.getString("Description"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");

            Glide.with(this).load(getIntent().getExtras().getString("Image")).into(profileImg);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Cars Category");
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(CarViewPage.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), rentCar.class));
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarViewPage.this, updateCar.class)
                        .putExtra("Title", profileTitle.getText().toString())
                        .putExtra("Price", profilePrice.getText().toString())
                        .putExtra("Area", profileArea.getText().toString())
                        .putExtra("Number", profileArea.getText().toString())
                        .putExtra("Description", profileArea.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });
        callDialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = number.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+call));
                startActivity(intent);
            }
        });
    }

}