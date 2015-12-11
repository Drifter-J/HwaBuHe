package com.google.zxing.client.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;

/**
 * Created by juyeon on 2015-11-21.
 */
public class MainActivity extends Activity {
    Button buttonInmypouch, buttonTrashcan;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button click eventLister
        buttonInmypouch = (Button) findViewById(R.id.buttonInmypouch);
        buttonTrashcan = (Button) findViewById(R.id.buttonTrashcan);

        View buttonItemContainer1 = findViewById(R.id.buttonItemContainer1);
        View buttonItemContainer2 = findViewById(R.id.buttonItemContainer2);
        final Button buttonItem1 = (Button) buttonItemContainer1.findViewById(R.id.buttonItem);
        final Button buttonItem2 = (Button) buttonItemContainer2.findViewById(R.id.buttonItem);

        buttonItem1.setBackgroundResource(R.drawable.item01);
        buttonItem1.setText("");


        buttonInmypouch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InMyPouchActivity.class);
                startActivity(intent);
            }
        });

        buttonTrashcan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrashMainActivity.class);
                startActivity(intent);
            }
        });

        buttonItem1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View dialogView = (View) View.inflate(MainActivity.this, R.layout.main_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView itemImage = (ImageView) dialogView.findViewById(R.id.itemImage);
                itemImage.setImageResource(R.drawable.item01);

                EditText edittext1 = (EditText) dialogView.findViewById(R.id.edittext1);
                edittext1.setText("아르간 오일 리페어 플러스 히트 세럼 인 오일");
                //Spinner setting
                Spinner spinnerType = (Spinner) dialogView.findViewById(R.id.spinnerType);
                spinnerType.setAdapter(adapter);
                spinnerType.setSelection(6);

                EditText edittext2 = (EditText) dialogView.findViewById(R.id.edittext2);
                edittext2.setText("100");

                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();

            }
        });

        buttonItem2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivity(intent);
                SystemClock.sleep(50);
                buttonItem2.setBackgroundResource(R.drawable.item02);
                buttonItem2.setText("");
            }
        });

        /*
        //juyeon's code
        // item grid setting
        final GridView gv = (GridView) findViewById(R.id.itemGrid);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
        */
        // 제품종류 spinner 선택
        String[] type = {"스킨케어", "페이스 메이크업", "컬러 메이크업", "클렌징", "팩/마스크", "선케어", "바디/헤어", "미용소품","네일", "기타"};

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }
        public int getCount() {
            return imageID.length;
        }
        public Object getItem(int arg0) {
            return null;
        }
        public long getItemId(int arg0) {
            return 0;
        }
        Integer[] imageID = {R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05,R.drawable.item06, R.drawable.item07, R.drawable.item08, R.drawable.item09, R.drawable.item10
                             ,R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05,R.drawable.item06, R.drawable.item07, R.drawable.item08, R.drawable.item09, R.drawable.item10
                             ,R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05,R.drawable.item06, R.drawable.item07, R.drawable.item08, R.drawable.item09, R.drawable.item10};
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 150));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(imageID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.main_dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView itemImage = (ImageView) dialogView.findViewById(R.id.itemImage);
                    itemImage.setImageResource(imageID[pos]);

                    //Spinner setting
                    Spinner spinnerType = (Spinner) dialogView.findViewById(R.id.spinnerType);
                    spinnerType.setAdapter(adapter);

                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();

                }
            });

            return imageView;
        }
    }
}
