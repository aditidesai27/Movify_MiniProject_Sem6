package com.example.movify_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Choice extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private CheckBox checkBox,checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18;
    private ImageButton button;
    private StringBuilder Intrest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        button = (ImageButton) findViewById(R.id.save_btn);

        final CheckBox checkBox = findViewById(R.id.romance);
        final CheckBox checkBox1 = findViewById(R.id.mystery);
        final CheckBox checkBox2 = findViewById(R.id.horror);
        final CheckBox checkBox3 = findViewById(R.id.comedy);
        final CheckBox checkBox4 = findViewById(R.id.thriller);
        final CheckBox checkBox5 = findViewById(R.id.action);
        final CheckBox checkBox6 = findViewById(R.id.fiction);
        final CheckBox checkBox7 = findViewById(R.id.drama);
        final CheckBox checkBox8 = findViewById(R.id.western);
        final CheckBox checkBox9 = findViewById(R.id.fantasy);
        final CheckBox checkBox10 = findViewById(R.id.historical_fiction);
        final CheckBox checkBox11 = findViewById(R.id.darkcomedy);
        final CheckBox checkBox12 = findViewById(R.id.adventure);
        final CheckBox checkBox13 = findViewById(R.id.spy_fiction);
        final CheckBox checkBox14 = findViewById(R.id.biography);
        final CheckBox checkBox15 = findViewById(R.id.comedy_horror);
        final CheckBox checkBox16 = findViewById(R.id.political);
        final CheckBox checkBox17 = findViewById(R.id.romcom);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    private void openHomeActivity(){
        Intent intent = new Intent(this, Registerpage.class);
        startActivity(intent);
    }
}