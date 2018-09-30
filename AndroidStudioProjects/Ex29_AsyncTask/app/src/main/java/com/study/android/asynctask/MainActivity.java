package com.study.android.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    ProgressBar mProgress1;
    int mProgressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress1 = findViewById(R.id.progressBar1);
    }

    public void onBtnClicked(View v) {
        new CounterTask().execute(0);
    }

    class CounterTask extends AsyncTask<Integer, Integer, Integer> {    // Integer3개 쓰는 이유
        protected void onPreExecute(){
        }

        @Override
        protected Integer doInBackground(Integer... value) {    // Integer 1번
            while (mProgressStatus < 100) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                mProgressStatus++;
                publishProgress(mProgressStatus);
            }
            return  mProgressStatus;
        }

        protected  void onProgressUpdate(Integer...value) { // Integer 2번
            mProgress1.setProgress(mProgressStatus);
        }
        protected  void onProgressUpdate(Integer result) {  // Integer 3번
            mProgress1.setProgress(mProgressStatus);
        }
    }
}
