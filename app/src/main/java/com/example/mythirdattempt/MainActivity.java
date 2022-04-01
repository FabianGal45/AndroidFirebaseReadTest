package com.example.mythirdattempt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private TextView mNameView;
//    private ListView mUserList;
//    private ArrayAdapter<String> mUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance("https://testforc-7b1f7-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Name");;
//        mDatabase.setValue("Hello, World!");
//        mUserList = (ListView) findViewById(R.id.user_List);
        mNameView = (TextView) findViewById(R.id.nameTV);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                mNameView.setText("Name: "+ name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}