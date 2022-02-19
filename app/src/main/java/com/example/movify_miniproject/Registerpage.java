package com.example.movify_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registerpage extends AppCompatActivity {
    private static final String TAG = "Register";
    private FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userid;
    EditText email1,username1,password1,conpassword1 ;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

         email1 = findViewById(R.id.email2);
         username1 = findViewById(R.id.user_name);
         password1 = findViewById(R.id.Password2);
         conpassword1 = findViewById(R.id.conPassword);
         ImageButton register = findViewById(R.id.register2);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString().trim();
                String password= password1.getText().toString().trim();
                String username = username1.getText().toString().trim();

                if(email.isEmpty())
                {
                    email1.setError("Email is empty");
                    email1.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    email1.setError("Enter the valid email address");
                    email1.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    password1.setError("Enter the password");
                    password1.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    password1.setError("Length of the password should be more than 6");
                    password1.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Registerpage.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();
                            userid = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userid);
                            Map<String,Object> user=new HashMap<>();
                            user.put("fname",username1);
                            user.put("email1",email1);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"on success, user profile is created for "+userid);
                                }
                            });
                            openChoiceActivity();
                        }
                        else
                        {
                            Toast.makeText(Registerpage.this,"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
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

}



