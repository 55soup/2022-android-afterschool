package com.cookandroid.project7_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtId, edtPwd;
    Button btnlog;
    TextView tvprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtId = findViewById(R.id.edtId);
        edtPwd = findViewById(R.id.edtPwd);
        btnlog = findViewById(R.id.btnlog);
        tvprint = findViewById(R.id.tvprint);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getId = edtId.getText().toString();
                String getPwd = edtPwd.getText().toString();
                Toast.makeText(getApplicationContext(),"id:  " + getId + "  pw: " + getPwd, Toast.LENGTH_SHORT).show();
                tvprint.setText("입력결과 : 아이디(" + getId + "), 비밀번호(" + getPwd + ")");
            }
        });
    }
}