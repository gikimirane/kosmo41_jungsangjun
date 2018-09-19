package com.study.android.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
        textView = findViewById(R.id.textView1);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.d(TAG, "로그 출력");
                Toast.makeText(getApplicationContext(), "긴 토스트", Toast.LENGTH_LONG).show();
            }
        });

    }
    // 버튼2 : 인텐트 만들어 웹브라우저 띄우기
    public void onBtn2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.daum.net"));
        startActivity(intent);
    }

    // 버튼3 : 인텐트 만들어 전화 걸기
    public void onBtn3Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01022988695"));
        startActivity(intent);
    }

    // 버튼4 : EditText에 입력한 값을 TextView에 보여 주기
    public void onBtn4Clicked(View v){
        textView.setText(editText.getText());
    }

    // 버튼5
    public void onBtn5Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
        intent.putExtra("CustomerName", "홍길동");
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "콜백 함수 호출됨");

        if(requestCode == 1 && resultCode == 10)
        {
            String sData = "";
            String str = "OnActivityReslt() called : " +
                    requestCode + " : " +
                    resultCode;

            sData = data.getStringExtra("BackData");
            str = str + " : " + sData;

            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }
    }
}
