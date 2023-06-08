package com.example.moneywiseu

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var Btnlogin : Button
    private lateinit var BtnRegister : Button
    private lateinit var EdtEmail : EditText
    private lateinit var EdtPassword : EditText
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BtnRegister.setOnClickListener {
            var gotoreg = Intent(this,RegisterActivity::class.java)
            startActivity(gotoreg)
        }
        Btnlogin.setOnClickListener {
            var email = EdtEmail.text.toString().trim()
            var password = EdtPassword.text.toString().trim()
            if (email.isEmpty()||password.isEmpty())
                Toast.makeText(this, "Can't submit an Empty Field", Toast.LENGTH_SHORT).show()
            else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)


                    }   else {
                        Toast.makeText(this, "Failed to create an Account", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}