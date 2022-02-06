package com.example.movify_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Registerpage extends AppCompatActivity {

    TextInputEditText etRegEmail;
    Button register;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        etRegEmail = findViewById(R.id.etRegEmail);
        register = findViewById(R.id.register);


        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(view ->{
            createUser();
        });


    }

    private void createUser(){
        //String email = etRegEmail.getText().toString()
    }
}