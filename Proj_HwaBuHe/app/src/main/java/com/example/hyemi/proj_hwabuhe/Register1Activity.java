package com.example.hyemi.proj_hwabuhe;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;

/**
 * Created by juyeon on 2015-11-21.
 */
public class Register1Activity extends Activity {
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        /*
        float scale = getContext().getResources().getDisplayMetrics().density;
        int dp = (int)(650/DEFAULT_HDIP_DENSITY_SCALE * scale);

        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setLayoutParams(new LinearLayout.LayoutParams(dp, LinearLayout.LayoutParams.WRAP_CONTENT));
        */

        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register2Activity.class);
                startActivity(intent);
            }
        });
    }
}
