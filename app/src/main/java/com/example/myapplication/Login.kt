package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.signup.Signup_ID
import kotlinx.android.synthetic.main.activity_login.*



class Login : AppCompatActivity() {

    private val sharedPreferences : SharedPreferences = applicationContext.getSharedPreferences("Login_information",0)
    private var editor = sharedPreferences.edit()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(sharedPreferences.getBoolean("auto",false)){
            auto_login()
        }

        login_btn.setOnClickListener {
            var id = id_etv.text.toString()
            var password = password_etv.text.toString()
            // 로그인 구현하기.
            if (autologin_Check.isChecked){
                auto_save(id,password)
            }
        }
        gotosignup_tv.setOnClickListener {
            var intent = Intent(applicationContext,Signup_ID::class.java)
            startActivity(intent)
        }
    }

    fun auto_save(id : String,password : String){
        editor.putBoolean("auto",true).apply()
        editor.putString("id",id).apply()
        editor.putString("password",password).apply()
        editor.commit()
    }
    fun auto_login(){

    }
}
