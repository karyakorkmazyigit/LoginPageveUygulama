package com.example.loginpageveuygulama;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginpageveuygulama.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper= new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent2);
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.usernameEditTextInLoginPage.getText().toString();
                String password = binding.passwordEditTextInLoginPage.getText().toString();

                if(name.equals("")||password.equals(""))
                    Toast.makeText(MainActivity.this, "All fields are mandatory.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials= databaseHelper.checkNamePassword(name,password);
                    if(checkCredentials==true){
                        Toast.makeText(MainActivity.this, "Login Successfully.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(intent);
                    } else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

}