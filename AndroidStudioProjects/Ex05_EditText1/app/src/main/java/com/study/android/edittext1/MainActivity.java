package com.study.android.edittext1;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

    public class MainActivity extends AppCompatActivity {
        private static final String TAG = "lecture";

        TextView textView1;

        EditText etId;
        EditText etPwd;
        EditText etYear;
        EditText etMonth;
        EditText etDay;

        String sId;
        String sPwd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView1 = findViewById(R.id.textView1);

            etId = findViewById(R.id.etId);
            etPwd = findViewById(R.id.etPwd);
            etYear = findViewById(R.id.etYear);
            etMonth = findViewById(R.id.etMonth);
            etDay = findViewById(R.id.etDay);

            //패스워드 입력시 글자수 체크
            etPwd.addTextChangedListener(watcher);
        }
        // inputType과 maxLength가 EditText에 지정되어 있으면 키보드에 [리턴]이 [다음]으로 됨
        // 맨 마지막 입력칸은 자동으로 [완료]가 됨
        // 입력칸이 키보드에 가려지면 자동으로 올라감

        // 키보드 내리키 버튼
        public void onKeydownClicked(View v){
            // IME Hide
            InputMethodManager mgr =
                    (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

        // 로그인 버튼
        public void onLoginClicked(View v) {
            sId = etId.getText().toString();
            sPwd = etPwd.getText().toString();

            if (sId.length() < 3) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("알림")
                        .setMessage("아이디를 입력해주세요")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("닫기", null)
                        .show();
                etId.requestFocus();
                return;
            } else if(sPwd.length() < 5) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("알림")
                        .setMessage("비밀번호를 정확히 입력해 주세요")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("닫기", null)
                        .show();
                etPwd.requestFocus();
                return;
            }
        }

        TextWatcher watcher = new TextWatcher() {
           String beforeText;

           public void onTextChanged(CharSequence str, int start, int before, int count) {
               byte[] bytes = null;
               try {
                   // bytes = str.toString().getBytes("KSC5601");
                   bytes = str.toString().getBytes("8859_1");
                   int strCount = bytes.length;
                   textView1.setText(strCount + " / 8바이트");
                   // 한글 글자를 1바이트 문자로 셀 것이냐? 2바이트 문자로 셀 것이냐?
                   // KSC5601 - 한글 한글자(2byte)가 길이 2로 리턴
                   // 8859_1 (유니코드) - 한글 한글자가 길이 1로 리턴

               } catch (UnsupportedEncodingException ex) {
                   ex.printStackTrace();
               }
           }
           public void beforeTextChanged(CharSequence str, int start, int count, int after) {
               beforeText = str.toString();
               Log.d(TAG, "beforeTextChanged : " + beforeText);
           }

           public void afterTextChanged(Editable strEditable) {
               String str = strEditable.toString();
               Log.d(TAG, "afterTextChanged : " + str);
               try {
                   byte[] strBytes = str.getBytes("8859_1");
                   if(strBytes.length > 8) {
                       etPwd.setText(beforeText);
                       etPwd.setSelection(beforeText.length() - 1, beforeText.length() - 1);
                   }
               } catch(Exception ex) {
                   ex.printStackTrace();
               }
           }
        };

    }

