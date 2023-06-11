package com.example.rentxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.rentxapplication.login_register.MainActivity;

public class SplashScreen extends AppCompatActivity {
    ImageView image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        image = findViewById(R.id.imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class );
                /* startActivity(intent);
                finish(); */
                Pair[] pairs = new Pair[1];
                pairs[0] =new Pair<View,String>(image, "logo_image");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);
                startActivity(intent,options.toBundle());
                finish();
            }
        },3000);
    }
}