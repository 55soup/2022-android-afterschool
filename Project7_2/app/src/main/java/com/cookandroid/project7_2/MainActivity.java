package com.cookandroid.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtGender;
    Button btnInsert, btnTel, btnGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주 메뉴 정리");
        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        edtGender = findViewById(R.id.edtGender);
        btnInsert = findViewById(R.id.btnInsert);
        btnTel = findViewById(R.id.btnTel);
        btnGender = findViewById(R.id.btnGender);
        registerForContextMenu(btnTel); //전화번호 버튼을 컨텍스트 메뉴로 사용
        btnGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.itemMan:
                                edtGender.setText("남자"); break;
                            case R.id.itemWoman:
                                edtGender.setText("여자"); break;
                        }
                        return false;
                    }
                });
                p.show(); //팝업메뉴 보여주기
            }
        });
        // 가입버튼 클릭하면 이름, 성별 내용 토스트로 출력하기.
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = edtName.getText().toString();
                String getGender = edtGender.getText().toString();
                String getTel = edtTel.getText().toString();
                Toast.makeText(getApplicationContext(),"이름 : " + getName + "\n성별 : " + getGender + "\n" + getTel, Toast.LENGTH_SHORT).show();
                edtName.setText("");  edtGender.setText(""); edtTel.setText("");
            }
        });
    } //onCreate



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch(item.getItemId()) {//초기화시켰을 때
            case R.id.itemReset:
                edtName.setText("");
                edtGender.setText("");
                edtTel.setText("");
                return true;
            case R.id.itemExit: //종료했을 때
                Toast.makeText(getApplicationContext(), "종료합니다~", Toast.LENGTH_SHORT).show();
                finish();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v==btnTel){//컨텍스트 메뉴는 위젯을 롱클릭할 오픈
            menu.setHeaderTitle("전화번호 선택하세요.");
            menuInflater.inflate(R.menu.menu_context, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){
//        switch(item.getItemId()){
//            case R.id.item010:
//                edtTel.getText(item.getTitle().toString()); break;
//            case R.id.item017:
//                edtTel.setText(item.getTitle().toString()); break;
//        }
        edtTel.setText(item.getTitle().toString()); // 간략히
        return true;
    }

}