package com.study.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    String[] names = {"김지훈", "김철언", "김태형", "김현승", "남궁윤희","노현아","박진수","송상운",
                    "오연주","유민상","윤용백","이건후","이영호","장희성","정상준","정재엽","정석진",
                      "조성준","조윤희","최송이","한동인","한태용"};
    String[] birs = {"00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00",
                     "00", "00", "00", "00", "00","00", "00", "00", "00", "00", "00"};
    String[] adds = {"서울시", "인천시", "서울시", "부천시", "인천시","서울시","고양시","서울시",
                    "부천시","광명시","서울시","인천시","서울시","부천시","서울시","서울시","인천시",
                     "서울시","서울시","인천시","화성시","부천시"};
    String[] sexs ={"남","남","남","남","여","여","남","남","여","남","남",
                      "남","남","남","남","남","남","남","여","여","남","남"};
    String[] phones ={"010","010","010","010","010","010","010","010","010","010","010",
                     "010","010","010","010","010","010","010","010","010","010","010",};
    int[] images = {R.drawable.face1, R.drawable.face3,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3
        final MyAdapter adapter = new MyAdapter();

        ListView listView1 = findViewById(R.id.listView1);

        listView1.setAdapter(adapter);

        // 4단계
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Toast.makeText(getApplicationContext(),
                        "selected : " + phones[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 1단계
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() { return  names.length;}

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // 2
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);



            SingerItemView1 view1 = new SingerItemView1(getApplicationContext());
            SingerItemView2 view2 = new SingerItemView2(getApplicationContext());
            if(sexs[position].toString().equals("남")){
                view1.setName(names[position]);
                view1.setBir(birs[position]);
                view1.setAdd(adds[position]);
                view1.setSex(sexs[position]);
                //view1.setPhone(phones[position]);
                view1.setImage(images[0]);
                layout.addView(view1);

            }else{
                view2.setName(names[position]);
                view2.setBir(birs[position]);
                view2.setAdd(adds[position]);
                view2.setSex(sexs[position]);
                //view2.setPhone(phones[position]);
                view2.setImage(images[1]);
                layout.addView(view2);
            }


            return layout;
        }
    }
}
