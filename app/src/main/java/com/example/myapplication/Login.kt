package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.signup.Signup_ID
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*



class Login : AppCompatActivity() {
    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences : SharedPreferences = getSharedPreferences("Login_information",0)
        if(sharedPreferences.getBoolean("auto",false)){
            auto_login(sharedPreferences)
        }

        login_btn.setOnClickListener {
            var id = id_etv.text.toString()
            var password = password_etv.text.toString()

            if (autologin_Check.isChecked){
                auto_save(sharedPreferences,id,password)
                login(id,password)
            }
            else{
                login(id,password)
            }
        }
        gotosignup_tv.setOnClickListener {
            var intent = Intent(applicationContext,Signup_ID::class.java)
            startActivity(intent)
        }
    }

    private fun auto_save(sharedPreferences: SharedPreferences,id : String,password : String){
        if(id != null && password != null) {
            var editor = sharedPreferences.edit()
            editor.putBoolean("auto", true).apply()
            editor.putString("id", id).apply()
            editor.putString("password", password).apply()
            editor.commit()
        }
    }
    private fun auto_login(sharedPreferences: SharedPreferences){
        var id = sharedPreferences.getString("id","")
        var password = sharedPreferences.getString("password","")
        if (id != null) {
            if (password != null) {
                login(id,password)
            }
        }
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
                        Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT)
                    }

                    // ...
                }
    }

}
