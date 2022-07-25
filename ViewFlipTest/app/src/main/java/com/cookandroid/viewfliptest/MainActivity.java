package com.cookandroid.viewfliptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlip;
    Button btnPre, btnStart, btnStop, btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주 뷰플리퍼 실습");
        viewFlip = findViewById(R.id.viewFlip);
        btnPre = findViewById(R.id.btnPre);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnNext = findViewById(R.id.btnNext);

         btnPre.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 viewFlip.showPrevious();
             }
         });

         btnNext.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 viewFlip.showNext();
             }
         });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.setFlipInterval(200);
                viewFlip.startFlipping();
            }
        });
         btnStop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 viewFlip.stopFlipping();
             }
         });
    }
}