package com.example.firebaserealtimedbexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText EditTextName, EditTextCourse, EditTextDuration, EditTextRollno;
    String name, course, duration, rollno;
    FirebaseDatabase db;
    DatabaseReference node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTextName = findViewById(R.id.EditTextName);
        EditTextCourse = findViewById(R.id.EditTextCourse);
        EditTextDuration = findViewById(R.id.EditTextDuration);
        EditTextRollno = findViewById(R.id.EditTextRollno);

        db = FirebaseDatabase.getInstance();
        node = db.getReference("students");

    }

    public void SendData(View view) {

        name = EditTextName.getText().toString();
        course = EditTextCourse.getText().toString();
        duration = EditTextDuration.getText().toString();
        rollno = EditTextRollno.getText().toString();;

        dataHolder obj = new dataHolder(name, course, duration);

//        db = FirebaseDatabase.getInstance();
//        node = db.getReference("students");

        node.child(rollno).setValue(obj);

        EditTextName.setText("");
        EditTextCourse.setText("");
        EditTextDuration.setText("");
        EditTextRollno.setText("");
        Toast.makeText(getApplicationContext(), "Sent", Toast.LENGTH_SHORT).show();
    }

    public void ReceiveData(View view) {

        node.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.child("1").child("name").getValue(String.class);
                Toast.makeText(MainActivity.this, "Data Received: " + value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}