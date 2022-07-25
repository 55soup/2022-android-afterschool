package com.cookandroid.ex_chk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox chkEnabled,  chkVisible, chkRotation;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주");
        chkEnabled = findViewById(R.id.chk);
        chkVisible  = findViewById(R.id.chk2);
        chkRotation = findViewById(R.id.chk3);
        btn = findViewById(R.id.btn);

        //btn.setEnable(true);
        chkEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkEnabled.isChecked()){//true
                    btn.setEnabled(true);
                }else{
                    btn.setEnabled(false);
                }
            }
        });

        //btn.setVisiblility(true)
        chkVisible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setVisibility(View.VISIBLE);
                else btn.setVisibility(View.INVISIBLE);
            }
        });
        //btn.setRotation(45);
        chkRotation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkRotation.isChecked()){
                    btn.setRotation(45);
                }else{
                    btn.setRotation(0);
                }
            }
        });

    }
}