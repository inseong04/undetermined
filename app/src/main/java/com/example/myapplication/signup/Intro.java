package com.example.myapplication.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Login;
import com.example.myapplication.R;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView logo = findViewById(R.id.logo);

        Handler handler = new Handler();
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