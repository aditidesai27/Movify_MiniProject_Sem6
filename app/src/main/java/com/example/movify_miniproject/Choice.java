package com.example.movify_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Choice extends AppCompatActivity {
//    private FirebaseAuth mAuth;
    private CheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11,ch12,ch13,ch14,ch15,ch16,ch17,ch18;
    private DatabaseReference mDatabase;
    private ImageButton savebutton;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        ch18 = findViewById(R.id.romance);
        ch1 = findViewById(R.id.mystery);
        ch2 = findViewById(R.id.horror);
        ch3 = findViewById(R.id.comedy);
        ch4 = findViewById(R.id.thriller);
        ch5 = findViewById(R.id.action);
        ch6 = findViewById(R.id.fiction);
        ch7 = findViewById(R.id.drama);
        ch8 = findViewById(R.id.western);
        ch9 = findViewById(R.id.fantasy);
        ch10 = findViewById(R.id.historical_fiction);
        ch11 = findViewById(R.id.darkcomedy);
        ch12 = findViewById(R.id.adventure);
        ch13 = findViewById(R.id.spy_fiction);
        ch14 = findViewById(R.id.biography);
        ch15 = findViewById(R.id.comedy_horror);
        ch16 = findViewById(R.id.political);
        ch17 = findViewById(R.id.romcom);

//        mDatabase = FirebaseDatabase.getInstance().getReference().child("User_Interest");
        Map<String, Object> Preferences = new HashMap<>();
//        city.put("name", "Los Angeles");
//        city.put("state", "CA");
//        city.put("country", "USA");
//        mAuth = FirebaseAuth.getInstance();

        savebutton = findViewById(R.id.save_btn);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("button clicked");
                String user_id = user.getUid();
//                DatabaseReference current_user_db = mDatabase.child(user_id);

                if(ch18.isChecked()) {
//                    current_user_db.child("1").setValue("romance");
                    Preferences.put("1","romance");
                }

                if(ch1.isChecked()) {
//                    current_user_db.child("2").setValue("mystery");
                    Preferences.put("2","mystery");
                }

                if(ch2.isChecked()) {
//                    current_user_db.child("3").setValue("horror")
                    Preferences.put("3","horror");
                }

                if(ch3.isChecked()) {
//                    current_user_db.child("4").setValue("comedy");
                    Preferences.put("4","comedy");
                }

                if(ch4.isChecked()) {
//                    current_user_db.child("5").setValue("thriller");
                    Preferences.put("5","thriller");
                }

                if(ch5.isChecked()) {
//                    current_user_db.child("6").setValue("action");
                    Preferences.put("6","action");}

                if(ch6.isChecked()) {
//                    current_user_db.child("7").setValue("fiction");
                    Preferences.put("7","fiction");}

                if(ch7.isChecked()) {
//                    current_user_db.child("8").setValue("drama");
                    Preferences.put("8","drama");}

                if(ch8.isChecked()) {
//                    current_user_db.child("9").setValue("western");
                    Preferences.put("9","western");}

                if(ch9.isChecked()) {
//                    current_user_db.child("10").setValue("fantasy");
                    Preferences.put("10","fantasy");}

                if(ch10.isChecked()) {
//                    current_user_db.child("11").setValue("historical_fiction");
                    Preferences.put("11","historical_fiction");}

                if(ch11.isChecked()) {
//                    current_user_db.child("12").setValue("darkcomedy");
                    Preferences.put("12","darkcomedy");
                }

                if(ch12.isChecked()) {
//                    current_user_db.child("13").setValue("adventure");
                    Preferences.put("13","adventure");
                }

                if(ch13.isChecked()) {
//                    current_user_db.child("14").setValue("spy_fiction");
                    Preferences.put("14","spy_fiction");
                }

                if(ch14.isChecked()) {
//                    current_user_db.child("15").setValue("biography");
                    Preferences.put("15","biography");
                }

                if(ch15.isChecked()) {
//                    current_user_db.child("16").setValue("comedy_horror");
                    Preferences.put("16","comedy_horror");
                }

                if(ch16.isChecked()) {
//                    current_user_db.child("17").setValue("political");
                    Preferences.put("17","political");}

                if(ch17.isChecked()) {
//                    current_user_db.child("18").setValue("romcom");
                    Preferences.put("18","romcom");}

                try {
                    db.collection("users").document(user.getUid()).collection("Preferences").document("Preferred Genre")
                            .set(Preferences)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
//                                    Log.d(TAG, "DocumentSnapshot successfully written!");
                                    System.out.println("Preferences Added");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
//                                    Log.w(TAG, "Error writing document", e);
                                    System.out.println("Failed to add");
                                }
                            });
                }catch(Exception e){
                    System.out.println(e.toString());
                }

                Intent interestIntent = new Intent(Choice.this, HomeActivity.class);
                interestIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(interestIntent);
            }
        });



    }
}