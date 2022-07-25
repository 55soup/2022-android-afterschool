package com.cookandroid.project6_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    Button btn1;
    String hakbun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주");

        input1 = findViewById(R.id.input1);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hakbun = input1.getText().toString();
                Toast.makeText(getApplicationContext(), hakbun, Toast.LENGTH_SHORT).show();
            }
        });
    }
}