package com.example.movify_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    private FirebaseAuth mAuth;
    private ImageButton button;
    //private static final String TAG="";
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.Password);

        button = (ImageButton) findViewById(R.id.gotoregistert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterActivity();
            }
        });

        ImageButton login = findViewById(R.id.login2_btn);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_value = email.getText().toString().trim();
                String password_value = password.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(email_value, password_value).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                            openChoiceActivity();
                        } else {
                            Toast.makeText(Login.this, "Login Failed! Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    private void openChoiceActivity(){
        Intent intent = new Intent(this, Choice.class);
        startActivity(intent);
    }
    private void openRegisterActivity(){
        Intent intent = new Intent(this, Registerpage.class);
        startActivity(intent);
    }
}



