package com.dogwoodraleigh.www.hetuitest;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by Dante on 5/10/2015.
 */
public class MainApplication extends Application {

    public static int TF_ROBOTO = 0;
    public static int TF_ROBOTO_LT = 1;
    public static int TF_ROBOTO_BK = 2;

    private static final String LOG_TAG = "MainApplication";

    private static Typeface mRoboto;
    private static Typeface mRobotoLight;
    private static Typeface mRobotoBlack;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "! MainApplication created");
    }

    public Typeface getCustomTypeface(int which) {
        switch (which) {
            case 1:
                if(mRobotoLight == null) {
                    mRobotoLight = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
                    return mRobotoLight;
                }
                break;
            case 2:
                if(mRobotoBlack == null) {
                    mRobotoBlack = Typeface.createFromAsset(getAssets(), "Roboto-Black.ttf");
                    return mRobotoBlack;
                }
                break;
            default:
                if(mRoboto == null) {
                    mRoboto = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
                    return mRoboto;
                }
        }

        return null;
    }

}
