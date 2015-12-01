package com.example.hyemi.proj_hwabuhe;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

/**
 * Created by juyeon on 2015-11-21.
 */
public class MainActivity extends Activity {
    Button buttonInmypouch, buttonTrashcan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
