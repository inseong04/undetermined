package com.example.myapplication.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.Login
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup_password.*

class Signup_PASSWORD : AppCompatActivity() {

    var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_password)


        next_button.setOnClickListener {
            if(password_etv.length().toString() == null){
                Toast.makeText(applicationContext,"비밀번호를 입력해주세요",Toast.LENGTH_SHORT)
            }
            else{
                val email = intent.getStringExtra("user_id")
                if (email != null) {
                    val password : String = password_etv.text.toString()
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.e("firebase", "createUserWithEmail:success")
                                    login(email,password)
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.e("firebase", "createUserWithEmail:failure", task.exception)
                                    Toast.makeText(baseContext, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show()
                                }

                                // ...
                            }
                }
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
                        finish()
                    } else {
                        Log.e("firebase", "Firebase : Login failed.", task.exception)
                        // If sign in fails, display a message to the user.
                        // ...
                    }

                    // ...
                }
    }
}