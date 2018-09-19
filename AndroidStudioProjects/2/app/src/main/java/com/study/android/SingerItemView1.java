package com.study.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView1 extends LinearLayout {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    //TextView textView5;
    ImageView imageView1;


    public SingerItemView1(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view1, this, true);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        //textView5 = findViewById(R.id.textView5);
        imageView1 = findViewById(R.id.imageView1);
    }

    public void setName(String name) {
        textView1.setText(name);
    }

    public void setBir(String bir) {
        textView2.setText(bir);
    }

    public void setAdd(String add) {
        textView3.setText(add);
    }

    public void setSex(String sex) {
        textView4.setText(sex);
    }

//    public void setPhone(String Phone) {
//        textView5.setText(Phone);
//    }

    public void setImage(int imgNum) {
        imageView1.setImageResource(imgNum);
    }

    public TextView getTextView1() {
        return textView1;
    }

    public void setTextView1(TextView textView1) {
        this.textView1 = textView1;
    }

    public TextView getTextView2() {
        return textView2;
    }

    public void setTextView2(TextView textView2) {
        this.textView2 = textView2;
    }

    public TextView getTextView3() {
        return textView3;
    }

    public void setTextView3(TextView textView3) {
        this.textView3 = textView3;
    }

    public TextView getTextView4() {
        return textView4;
    }

    public void setTextView4(TextView textView4) {
        this.textView4 = textView4;
    }

//    public TextView getTextView5() {
//        return textView5;
//    }
//
//    public void setTextView5(TextView textView5) {
//        this.textView5 = textView5;
//    }

    public ImageView getImageView1() {
        return imageView1;
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
    }
}
