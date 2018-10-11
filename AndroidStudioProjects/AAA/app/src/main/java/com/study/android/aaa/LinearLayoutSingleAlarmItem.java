package com.study.android.aaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LinearLayoutSingleAlarmItem extends LinearLayout {
    Context context;
    TextView textView;
    Button btnSingleAlarmItemCancel;

    AlarmData alarmData;
    private int position;

    public LinearLayoutSingleAlarmItem(Context context) {
        super(context);
        context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.single_alarm_data_layout, this);
        textView = (TextView)layout.findViewById(R.id.textView);
        btnSingleAlarmItemCancel = (Button)findViewById(R.id.btnSingleAlarmItemCancel);

        btnSingleAlarmItemCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(onRemoveButtonClickListner != null)
                    onRemoveButtonClickListner.onClicked(alarmData.hh, alarmData.mm, alarmData.reqCode, position);
            }
        });
    }

    public interface OnRemoveButtonClickListner{
        void onClicked(int hh, int mm ,int reqCode, int position);
    }

    OnRemoveButtonClickListner onRemoveButtonClickListner;

    void setOnRemoveButtonClickListner(OnRemoveButtonClickListner onRemoveButtonClickListner){
        this.onRemoveButtonClickListner = onRemoveButtonClickListner;
    }

    public boolean setData(AlarmData alarmData, int position){

        this.alarmData = alarmData;
        this.position = position;

        textView.setText(alarmData.hh+":"+alarmData.mm +" and requestCode : "+alarmData.reqCode);

        return true;
    }



}
