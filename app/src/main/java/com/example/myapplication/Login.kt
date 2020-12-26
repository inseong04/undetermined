package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.signup.Signup_ID
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*



class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        val sharedPreferences : SharedPreferences = getSharedPreferences("Login_information",0)
        if(sharedPreferences.getBoolean("auto",false)){
            auto_login()
        }

        login_btn.setOnClickListener {
            var id = id_etv.text.toString()
            var password = password_etv.text.toString()
            // 로그인 구현하기.
            if (autologin_Check.isChecked){
                auto_save(sharedPreferences,id,password)
            }
        }
        gotosignup_tv.setOnClickListener {
            var intent = Intent(applicationContext,Signup_ID::class.java)
            startActivity(intent)
        }
    }

    private fun auto_save(sharedPreferences: SharedPreferences,id : String,password : String){
        var editor = sharedPreferences.edit()
        editor.putBoolean("auto",true).apply()
        editor.putString("id",id).apply()
        editor.putString("password",password).apply()
        editor.commit()
    }
    private fun auto_login(){

    }

    private fun login(email : String,password : String){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        var intent = Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        // ...
                    }

                    // ...
                }
    }

}
