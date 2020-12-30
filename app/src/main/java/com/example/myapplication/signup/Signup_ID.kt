package com.example.myapplication.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_signup_id.*

class Signup_ID : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_id)
        next_button.setOnClickListener {
            if(id_etv.text.toString() == " "){
                Toast.makeText(applicationContext,"아이디를 입력해주세요",Toast.LENGTH_SHORT)
            }
            else{
                var intent = Intent(applicationContext,Signup_PASSWORD::class.java)
                intent.putExtra("user_id",id_etv.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}