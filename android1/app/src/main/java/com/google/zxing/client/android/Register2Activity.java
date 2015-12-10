package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by juyeon on 2015-11-21.
 */
public class Register2Activity extends Activity {
    Button buttonRegister;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // 성별 spinner 선택
        final String[] gender = {"남자", "여자"};

        Spinner spinnerGender = (Spinner) findViewById(R.id.spinnerGender);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        spinnerGender.setAdapter(adapter);


        // Register 버튼을 클릭시
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
