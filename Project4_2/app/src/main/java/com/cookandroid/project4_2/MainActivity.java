package com.cookandroid.project4_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtPet;    CheckBox chk;   RadioGroup rg;
    Button btnOK;   ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이름 넣기");
        chk = findViewById(R.id.chk);
        txtPet = findViewById(R.id.txtPet);
        rg = findViewById(R.id.rg);
        btnOK = findViewById(R.id.btnOK);
        img = findViewById(R.id.img);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()){//true
                    txtPet.setVisibility(View.VISIBLE); //텍스트뷰 보이기
                    rg.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    txtPet.setVisibility(View.INVISIBLE); //텍스트뷰 안보이기
                    rg.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    rg.clearCheck();  //체크박스 모두 비우기
                    img.setImageDrawable(null);  //이미지 그림 지우기
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    finish();  //종료
                }
            });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdoCat:
                        img.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdoFox:
                        img.setImageResource(R.drawable.fox);
                        break;
                    case R.id.rdoHorse:
                        img.setImageResource(R.drawable.horse1);
                        break;
                }
            }
        });
    }
}