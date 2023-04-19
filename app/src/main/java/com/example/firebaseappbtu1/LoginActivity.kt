package com.example.firebaseappbtu1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var loginEmailEditText : EditText
    private lateinit var loginPasswordEditText : EditText
    private lateinit var login : Button
    private lateinit var forgotPasswordButton:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        listeners()
    }

    private fun listeners(){
        login.setOnClickListener {
            val email = loginEmailEditText.text.toString()
            val password = loginPasswordEditText.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this,"email is empty",Toast.LENGTH_LONG).show()
            }
            if(password.isEmpty()){
                Toast.makeText(this,"password field is empty",Toast.LENGTH_LONG).show()
            }
        }
        forgotPasswordButton.setOnClickListener{
            startActivity(Intent(this,ForgotPasswordActivity::class.java))
            finish()


        }


    }
    private fun init(){
        login=findViewById(R.id.loginButton)
        loginEmailEditText = findViewById(R.id.loginEmailEditText)
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText)
        forgotPasswordButton=findViewById(R.id.forgotPasswordButton)

    }
}