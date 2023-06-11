package com.example.rentxapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import com.example.rentxapplication.fragments.AboutFragment;
import com.example.rentxapplication.fragments.CategoryFragment;
import com.example.rentxapplication.fragments.HomeFragment;
import com.example.rentxapplication.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    FirebaseAuth auth;
    Button button, contactus, about;
    TextView car,bike,property,appliances,clothes,others;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    CategoryFragment categoryFragment = new CategoryFragment();

    AboutFragment aboutFragment = new AboutFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();




        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (item.getItemId()==R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                    return true;
                } else if (item.getItemId()==R.id.profile) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                    return true;

                } else if (item.getItemId()==R.id.category) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,categoryFragment).commit();
                    return true;

                }else if (item.getItemId()==R.id.aboutus) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();
                    return true;

                }

                return false;
            }
        });

        }
    }
