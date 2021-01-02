package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle bundle = new Bundle();
        TextView person_t = findViewById(R.id.person);

            new Thread() {
                @Override
                public void run() {
                    try {
                        Document document = null;
                        document = Jsoup.connect("https://www.bloodinfo.net/bloodstats_statistics.do").get();
                        Elements elements = document.select("#area_blood_stock_numbers");
                        String person = elements.select(".txt").toString();
                        Log.e("test","person : "+person);
                        bundle.putString("person",person);
                        Message msg = handler.obtainMessage();
                        msg.setData(bundle);
                        handler.sendMessage(msg);
/*                        Document document = null;
                        document = (Document) Jsoup.connect("https://www.bloodinfo.net/bloodstats_statistics.do").get();
                        Elements elements = document.select("#txt");*/
                    }catch(IOException e){
                        Log.e("error","error ouccured");
                    }
                }
            }.start();


    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            TextView person_t = findViewById(R.id.person);
            Bundle bundle = msg.getData();
            person_t.setText(bundle.getString("person"));
        }
    };
}