package com.muzi.support.nightmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;

public class SecondAppCompatActivity extends BaseAppCompatActivity implements View.OnClickListener{

    private Button mBtnToggleGlobalNightMode;
    private Button mBtnToggleLocalNightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        mBtnToggleGlobalNightMode = (Button) findViewById(R.id.btn_toggle_global_night_mode);
        mBtnToggleGlobalNightMode.setOnClickListener(this);

        mBtnToggleLocalNightMode = (Button) findViewById(R.id.btn_toggle_local_night_mode);
        mBtnToggleLocalNightMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mode = getDelegate().getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
                ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES;
        switch (view.getId()) {
            case R.id.btn_toggle_global_night_mode:
                toggleNightModeForAllActivities(mode);
                break;
            case R.id.btn_toggle_local_night_mode:
                toggleLocalNightMode(mode);
                break;
        }
    }
}
