package com.study.android.aaa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmTestForHaruActivity extends Activity {

    AlarmManager alarmManager;
    Context context;
    public static final int DEFAULT_ALARM_REQUEST = 800;
    TimePicker timePicker;
    Button btnAddAlarm;
    ListView listView;
    ArrayList<AlarmData> arrayListAlarmTimeItem = new ArrayList<AlarmData>();

    GregorianCalendar currentCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+09:00"));

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor sharedEditor;

    AdapterAlarm arrayAdapterAlarmList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        context = getApplicationContext();

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        btnAddAlarm = (Button)findViewById(R.id.btnAddAlarm);
        listView	= (ListView)findViewById(R.id.listView);

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        sharedEditor = sharedPref.edit();

        timePicker.setIs24HourView(false);

        arrayAdapterAlarmList = new AdapterAlarm(context, arrayListAlarmTimeItem);
        listView.setAdapter(arrayAdapterAlarmList);

        alarmManager = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);




        btnAddAlarm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                int hh = timePicker.getCurrentHour();
                int mm = timePicker.getCurrentMinute();
                int reqCode = DEFAULT_ALARM_REQUEST+arrayListAlarmTimeItem.size();
                int i =arrayListAlarmTimeItem.size();

                arrayListAlarmTimeItem.add(new AlarmData(hh, mm, reqCode));
                arrayAdapterAlarmList.notifyDataSetChanged();

                sharedEditor.putInt("list"+i+"hh", hh);
                sharedEditor.putInt("list"+i+"mm", mm);
                sharedEditor.putInt("list"+i+"reqCode", reqCode);
                sharedEditor.putInt("size", i);
                sharedEditor.commit();

                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+09:00"));

                int currentYY = currentCalendar.get(Calendar.YEAR);
                int currentMM = currentCalendar.get(Calendar.MONTH);
                int currentDD = currentCalendar.get(Calendar.DAY_OF_MONTH);

                gregorianCalendar.set(currentYY, currentMM, currentDD, hh, mm,00);

                if(gregorianCalendar.getTimeInMillis() < currentCalendar.getTimeInMillis()){
                    gregorianCalendar.set(currentYY, currentMM, currentDD+1, hh, mm,00);
                    Log.i("TAG",gregorianCalendar.getTimeInMillis()+":");
                }


                Intent intent = new Intent(AlarmTestForHaruActivity.this, ActivityAlarmedTimeShow.class);
                intent.putExtra("time", hh+":"+mm);
                intent.putExtra("data", "알람: " + currentCalendar.getTime().toLocaleString());
                intent.putExtra("reqCode", reqCode);

                Toast.makeText(context, "reqCode : "+reqCode, Toast.LENGTH_SHORT).show();

                PendingIntent pi = PendingIntent.getActivity(AlarmTestForHaruActivity.this, reqCode, intent,PendingIntent.FLAG_UPDATE_CURRENT );
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gregorianCalendar.getTimeInMillis() ,AlarmManager.INTERVAL_DAY, pi);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        arrayListAlarmTimeItem.clear();
        int size = sharedPref.getInt("size", 0);
        if(size !=0)
            for(int i = 0 ; i < size+1; i ++ ){
                int hh = sharedPref.getInt("list"+i+"hh", 0);
                int mm = sharedPref.getInt("list"+i+"mm", 0);
                int reqCode = sharedPref.getInt("list"+i+"reqCode", 0);

                arrayListAlarmTimeItem.add(new AlarmData(hh, mm, reqCode));
            }
        arrayAdapterAlarmList.notifyDataSetChanged();
    }

}