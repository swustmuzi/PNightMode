package com.muzi.support.nightmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainAppCompatActivity extends BaseAppCompatActivity implements View.OnClickListener{
    private final static String TAG = MainAppCompatActivity.class.getName();

    private Button mBtnToggleNightMode;
    private Button mBtnSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mBtnToggleNightMode = (Button) findViewById(R.id.btn_toggle_night_mode);
        mBtnToggleNightMode.setOnClickListener(this);

        mBtnSecondActivity = (Button) findViewById(R.id.btn_second_activity);
        mBtnSecondActivity.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        int mode = AppCompatDelegate.getDefaultNightMode();
        Log.d(TAG, "onResume mode:" + mode);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_second_activity:
                Intent intent = new Intent();
                intent.setClass(this, SecondAppCompatActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_toggle_night_mode:
                int mode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
                        ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES;
                toggleGlobalNightMode(mode);
                break;
        }
    }
}
