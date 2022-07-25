package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button[] btnNums = new Button[10];
    Integer[] btnIDs = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button btnadd, btnminus, btnmult;
    TextView txresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주");
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        //////////////////////////////////////////////////////////////////////////////////////////////
        for(int i = 0; i<btnNums.length; i++){
            btnNums[i] = findViewById(btnIDs[i]);
            final int index = i;

            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edt1.isFocused()){
                        String s = edt1.getText().toString()+index;
                        edt1.setText(s);
                    }else if(edt2.isFocused()){
                        String s = edt2.getText().toString()+index;
                        edt2.setText(s);
                    }else{
                        Toast.makeText(getApplicationContext(), "에디터부터 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        //////////////////////////////////////////////////////////////////////////////////////////////

        btnadd = findViewById(R.id.btnadd);
        btnminus = findViewById(R.id.btnminus);
        btnmult = findViewById(R.id.btnmult);
        txresult = findViewById(R.id.txresult);
        
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edt1.getText().toString());
                int y = Integer.parseInt(edt2.getText().toString());
                txresult.setText("계산결과 : " + (x+y));
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edt1.getText().toString());
                int y = Integer.parseInt(edt2.getText().toString());
                txresult.setText("계산결과 : " + (x-y));
            }
        });
        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edt1.getText().toString());
                int y = Integer.parseInt(edt2.getText().toString());
                txresult.setText("계산결과 : " + (x*y));
            }
        });

    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu); //xml을 메뉴로 생성
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x = Integer.parseInt(edt1.getText().toString());
        int y = Integer.parseInt(edt2.getText().toString());
        switch (item.getItemId()){
            case R.id.itemAdd:
                txresult.setText("계산결과 : " + (x+y));
                break;
            case R.id.itemMul:
                txresult.setText("계산결과 : " + (x*y));
                break;
            case R.id.itemExit:
                finish();
        }
        return true;
    }
}