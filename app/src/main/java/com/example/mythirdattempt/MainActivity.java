package com.example.mythirdattempt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private TextView mNameView;
//    private ListView mUserList;
//    private ArrayAdapter<String> mUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance("https://testforc-7b1f7-default-rtdb.europe-west1.firebasedatabase.app/").getReference("message");;
//        mDatabase.setValue("Hello, World!");
//        mUserList = (ListView) findViewById(R.id.user_List);
        mNameView = (TextView) findViewById(R.id.nameTV);



    }
}