package com.example.hyemi.proj_hwabuhe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by juyeon on 2015-11-21.
 */
public class MainActivity extends Activity {
    Button buttonInmypouch, buttonTrashcan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button click eventLister
        buttonInmypouch = (Button) findViewById(R.id.buttonInmypouch);
        buttonTrashcan = (Button) findViewById(R.id.buttonTrashcan);

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

        // item grid setting

        final GridView gv = (GridView) findViewById(R.id.itemGrid);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

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
        Integer[] imageID = {R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05,R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05, R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05};
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
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();

                }
            });

            return imageView;
        }
    }
}
