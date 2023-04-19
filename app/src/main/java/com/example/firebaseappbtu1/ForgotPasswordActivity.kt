package com.example.firebaseappbtu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPasswordActivity : AppCompatActivity() {
    private val auth = Firebase.auth
    private lateinit var forgotPasswordSubmitButton :Button
    private lateinit var forgotEmailEditText :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        init()
        listeners()
    }

    private fun init(){
        forgotEmailEditText=findViewById(R.id.forgotEmailEditText);
        forgotPasswordSubmitButton=findViewById(R.id.forgotPasswordSubmitButton);

    }

    private fun listeners(){
        forgotPasswordSubmitButton.setOnClickListener{
            val email=forgotEmailEditText.text.toString();
            if (email.isEmpty()||!(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                Toast.makeText(this,"Invalid Email",Toast.LENGTH_LONG).show()
                }
            else{
                auth.sendPasswordResetEmail(email).addOnCompleteListener{
                    task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Email Sent",Toast.LENGTH_LONG).show();
                }
                    else{
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }


    }
}