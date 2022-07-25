package com.cookandroid.androidpj_20220614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton grade2, grade3;
    Button checkedBtn, cancelBtn, btn;
    RadioGroup radiogroup;
    String getGrade;
    CheckBox btnChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주");

        grade2 = findViewById(R.id.grade2);
        grade3 = findViewById(R.id.grade3);
        checkedBtn = findViewById(R.id.checkedBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        radiogroup = findViewById(R.id.radiogroup);
        btn = findViewById(R.id.btn);
        btnChk = findViewById(R.id.btnChk);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//                switch (checkedId){
//                    case R.id.grade2:
//                        getGrade = "2학년"; break;
//                    case R.id.grade3:
//                        getGrade = "3학년"; break;
//                }
                if(radioGroup.getCheckedRadioButtonId()==R.id.grade2)
                    getGrade = grade2.getText().toString();
                else    getGrade = grade3.getText().toString();

            }
        });

        checkedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "학년: " + getGrade, Toast.LENGTH_SHORT).show();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radiogroup.clearCheck();
                Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
            }
        });

        btnChk.setChecked(true);
        btnChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setEnabled(true);
                else btn.setEnabled(false);
            }
        });
    }
}