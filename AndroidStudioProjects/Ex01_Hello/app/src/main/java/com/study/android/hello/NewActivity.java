package com.study.android.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    String sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName");
    }

    public void onBtn1Clicked(View v) {
        //토스트로 전달된 데이터 보내주기
        Toast.makeText(getApplicationContext(),
                "CustomerName : " + sName, Toast.LENGTH_SHORT).show();

    }

    public void onBtn2Clicked(View v) {
        Intent intent = new Intent();
        intent.putExtra("BackData", "강감찬");
        setResult(10, intent);
        finish();
    }
}
