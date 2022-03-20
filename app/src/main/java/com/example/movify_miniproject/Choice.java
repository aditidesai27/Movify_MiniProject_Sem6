package com.example.movify_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import com.google.firebase.database.DatabaseReference;


import com.google.firebase.auth.FirebaseAuth;

public class Choice extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String strn;
    private CheckBox ch,ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11,ch12,ch13,ch14,ch15,ch16,ch17,ch18;
    private ImageButton button;
    private DatabaseReference gDatabase;
    private ProgressDialog mProgress;
    private StringBuilder Intrest;
    private String user_id;

    public Choice(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        button = (ImageButton) findViewById(R.id.save_btn);

        ch = (CheckBox)findViewById(R.id.romance);
        ch1 = (CheckBox)findViewById(R.id.mystery);
        ch2 = (CheckBox)findViewById(R.id.horror);
        ch3 = (CheckBox)findViewById(R.id.comedy);
        ch4 = (CheckBox)findViewById(R.id.thriller);
        ch5 = (CheckBox)findViewById(R.id.action);
        ch6 = (CheckBox)findViewById(R.id.fiction);
        ch7 = (CheckBox)findViewById(R.id.drama);
        ch8 = (CheckBox)findViewById(R.id.western);
        ch9 = (CheckBox)findViewById(R.id.fantasy);
        ch10 = (CheckBox)findViewById(R.id.historical_fiction);
        ch11 = (CheckBox)findViewById(R.id.darkcomedy);
        ch12 = (CheckBox)findViewById(R.id.adventure);
        ch13 = (CheckBox)findViewById(R.id.spy_fiction);
        ch14 = (CheckBox)findViewById(R.id.biography);
        ch15 = (CheckBox)findViewById(R.id.comedy_horror);
        ch16 = (CheckBox)findViewById(R.id.political);
        ch17 = (CheckBox)findViewById(R.id.romcom);

        user_id = mAuth.getCurrentUser().getUid();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder Intrest = new StringBuilder();
                Intrest.append(0);
                if(ch1.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch2.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch3.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch4.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch5.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch6.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch7.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch8.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch9.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch10.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch11.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch12.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch13.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch14.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch15.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch16.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                if(ch17.isChecked())
                    Intrest.append(1);
                else
                    Intrest.append(0);
                strn = Intrest.toString();
                uploadData();
            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }
    private void uploadData() {
        mProgress.setMessage("Uploading Data");
        mProgress.show();
        gDatabase.child(user_id).child("Personal_info").child("Intrest").setValue(strn);

        openHomeActivity();
    }

    private void openHomeActivity(){
        Intent intent = new Intent(this, Registerpage.class);
        startActivity(intent);
    }

}