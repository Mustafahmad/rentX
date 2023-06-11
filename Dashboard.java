package com.example.rentxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.rentxapplication.fragments.CategoryFragment;
import com.example.rentxapplication.fragments.HomeFragment;
import com.example.rentxapplication.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Dashboard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    CategoryFragment categoryFragment = new CategoryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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

                }

                return false;
            }
        });
    }
}