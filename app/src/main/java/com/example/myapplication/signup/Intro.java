package com.example.myapplication.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Login;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class Intro extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        SharedPreferences sharedPreferences = getSharedPreferences("Login_information",0);

        splash();

    }

    protected void splash(){
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView logo = findViewById(R.id.logo);

        handler.postDelayed(new Runnable() {
            public void run() {
                tv1.setVisibility(View.VISIBLE);
            }
        }, 1000);
        handler.postDelayed(new Runnable() {
            public void run() {
                tv2.setVisibility(View.VISIBLE);
            }
        }, 2000);
        handler.postDelayed(new Runnable() {
            public void run() {
                logo.setVisibility(View.VISIBLE);
            }
        }, 3000);
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
    }

}