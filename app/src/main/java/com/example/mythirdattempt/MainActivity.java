package com.example.mythirdattempt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseRef;
    private TextView mNameView;
    private TextView mAgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameView = (TextView) findViewById(R.id.nameTV);
        mAgeView = (TextView) findViewById(R.id.ageTV);

        mDatabase = FirebaseDatabase.getInstance("https://testforc-7b1f7-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabaseRef = mDatabase.getReference("Name");

//        I am not quite happy about having to use two different event listeners to get the name and age. But this exercise meets the purpose it was intended for and that is to grab data from the database.
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                mNameView.setText("Name: "+ name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mDatabaseRef = mDatabase.getReference("Age");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String age = snapshot.getValue().toString();
                mAgeView.setText("Age: "+age);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}