package com.example.loginpageveuygulama;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginpageveuygulama.databinding.ActivityMain3Binding;

import java.net.Inet4Address;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.signinUsername.getText().toString();
                String password=binding.signinPassword.getText().toString();
                
                if (name.equals("")||password.equals(""))
                    Toast.makeText(MainActivity3.this, "All field are mandatory.", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUserName=databaseHelper.checkName(name);
                    if(checkUserName==false){
                        Boolean insert =databaseHelper.insertData(name,password);
                        if (insert==true){
                            Toast.makeText(MainActivity3.this, "Signup Successfully.", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity3.this, "Signup Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity3.this, "User already exist,Please login.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}