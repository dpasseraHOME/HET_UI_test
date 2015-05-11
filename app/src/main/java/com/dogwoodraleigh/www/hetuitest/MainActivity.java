package com.dogwoodraleigh.www.hetuitest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dogwoodraleigh.www.hetuitest.drawables.ActivityMeter;
import com.dogwoodraleigh.www.hetuitest.drawables.OzoneUnit;

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

        ((TextView)findViewById(R.id.t_risk)).setTypeface(tfRobBk);
    }

    private void initOzoneDisplay() {
        RelativeLayout ozoneContainer = (RelativeLayout) findViewById(R.id.ozone_container);
        int j;
        View circleView;
        OzoneUnit ozoneUnit;

        for(int i=0; i<OZONE_X_COORD.length; i++) {
            for(j=0; j<OZONE_Y_COORD.length; j++) {
                circleView = new View(this);
                circleView.setLayoutParams(new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                ));

                ozoneContainer.addView(circleView);
                mOzoneUnitArr.add(circleView);

                ozoneUnit = new OzoneUnit(this, OZONE_X_COORD[i], OZONE_Y_COORD[j]);
                circleView.setBackground(ozoneUnit);
            }
        }
    }

    private void initActivityDisplay() {
        Log.d(LOG_TAG, "# initActivityDisplay");

        RelativeLayout activityContainer = (RelativeLayout) findViewById(R.id.activity_container);

        View meterView = new View(this);
        meterView.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ));

        activityContainer.addView(meterView);

        meterView.setBackground(new ActivityMeter(this));
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
