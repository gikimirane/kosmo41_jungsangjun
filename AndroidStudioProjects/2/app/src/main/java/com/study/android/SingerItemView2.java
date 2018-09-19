package com.study.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView2 extends LinearLayout {
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    //TextView textView10;
    ImageView imageView2;


    public SingerItemView2(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view2, this, true);

        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        //textView10 = findViewById(R.id.textView10);
        imageView2 = findViewById(R.id.imageView2);
    }

    public void setName(String name) {
        textView6.setText(name);
    }

    public void setBir(String bir) {
        textView7.setText(bir);
    }

    public void setAdd(String add) {
        textView8.setText(add);
    }

    public void setSex(String sex) {
        textView9.setText(sex);
    }

    //public void setPhone(String Phone) {
    //    textView10.setText(Phone);
   // }

    public void setImage(int imgNum) {
        imageView2.setImageResource(imgNum);
    }

    public TextView getTextView6() {
        return textView6;
    }

    public void setTextView6(TextView textView6) {
        this.textView6 = textView6;
    }

    public TextView getTextView7() {
        return textView7;
    }

    public void setTextView7(TextView textView7) {
        this.textView7 = textView7;
    }

    public TextView getTextView8() {
        return textView8;
    }

    public void setTextView8(TextView textView8) {
        this.textView8 = textView8;
    }

    public TextView getTextView9() {
        return textView9;
    }

    public void setTextView9(TextView textView9) {
        this.textView9 = textView9;
    }

//    public TextView getTextView10() {
//        return textView10;
//    }
//
//    public void setTextView10(TextView textView10) {
//        this.textView10 = textView10;
//    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }
}
