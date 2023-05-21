package com.example.loginpageveuygulama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavim=findViewById(R.id.bnavim);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new PersonFrag()).commit();
        bottomNavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.person:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new PersonFrag()).commit();
                       break;
                   case R.id.cosmetics:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new CosmeticsFrag()).commit();
                       break;
                   case R.id.haircaresupplies:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new HairCareFragment()).commit();
                       break;
                   case R.id.skincaresupplies:
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragments,new SkinCareFragment()).commit();
                       break;
               }
                return true;
            }
        });



    }
}