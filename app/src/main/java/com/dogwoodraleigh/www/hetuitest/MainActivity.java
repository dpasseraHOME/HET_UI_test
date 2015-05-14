package com.dogwoodraleigh.www.hetuitest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private static final String LOG_TAG = "MainActivity";

    private static final int[] OZONE_X_COORD = {62, 222, 382, 542, 702, 862, 1022};
    private static final int[] OZONE_Y_COORD = {135, 296, 457, 618};

    private ArrayList<View> mOzoneUnitArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        initFullScreen();
        initCustomTextViews();
        initOzoneDisplay();
        initActivityDisplay();
    }

    private void initFullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void initCustomTextViews() {
        MainApplication app = (MainApplication) getApplication();
        final Typeface tfRobBk = app.getCustomTypeface(MainApplication.TF_ROBOTO_BK);
        final Typeface tfRobLt = app.getCustomTypeface(MainApplication.TF_ROBOTO_LT);

        ((TextView)findViewById(R.id.t_temp)).setTypeface(tfRobBk);
        ((TextView)findViewById(R.id.t_temp_1)).setTypeface(tfRobBk);
        ((TextView)findViewById(R.id.t_temp_2)).setTypeface(tfRobLt);

        ((TextView)findViewById(R.id.t_humidity)).setTypeface(tfRobBk);
        ((TextView)findViewById(R.id.t_humidity_1)).setTypeface(tfRobBk);
        ((TextView)findViewById(R.id.t_humidity_2)).setTypeface(tfRobLt);

        ((TextView)findViewById(R.id.t_bpm)).setTypeface(tfRobBk);
        ((TextView)findViewById(R.id.label_bpm)).setTypeface(tfRobLt);
        ((TextView)findViewById(R.id.t_rr)).setTypeface(tfRobBk);
        ((TextView)findViewById(R.id.label_rr)).setTypeface(tfRobLt);
        ((TextView)findViewById(R.id.t_slash)).setTypeface(tfRobBk);
    }

    private void initOzoneDisplay() {

    }

    private void initActivityDisplay() {

    }

    private void handleNewData() {
        handleSecondaryEnvironmentalData();
        handleOzoneData();
        handleActivityData();
        handleBPMData();
        handleRiskData();
    }

    private void handleSecondaryEnvironmentalData() {

    }

    private void handleOzoneData() {

    }

    private void handleActivityData() {

    }

    private void handleBPMData() {

    }

    private void handleRiskData() {

    }

    public Handler dataProviderHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            handleNewData();
        }
    };

}
