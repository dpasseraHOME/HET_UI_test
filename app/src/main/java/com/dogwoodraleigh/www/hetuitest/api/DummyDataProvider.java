package com.dogwoodraleigh.www.hetuitest.api;

import android.os.Handler;
import android.util.Log;

import java.util.Random;

/**
 * Created by dantepassera on 5/14/15.
 */
public class DummyDataProvider {

    public static DataPackage currentData = new DataPackage(
            0f,
            0f, 0f , 0f,
            0f,
            0f, 0f,
            0f,
            0f
    );

    public static DataPackage previousData = new DataPackage(
            0f,
            0f, 0f , 0f,
            0f,
            0f, 0f,
            0f,
            0f
    );

    private static final int INTERVAL = 150; // ms
    private static int mIntervalCount = 0;

    private static int mRRIReturnAtInterval = 35;

    private static float mOzone = 0;
    private static float[] mOzoneRng = {0f, 100f};
    private static float mOzoneInc = 0.25f;
    private static boolean mIsOzoneInc = true;

    public static void startData(final Handler handler) {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                previousData = DataPackage.clone(currentData);
                currentData = getNewCurrentData();

                handler.sendEmptyMessage(0);
                handler.postDelayed(this, INTERVAL);
            }
        };

        handler.postDelayed(runnable, INTERVAL);
    }

    private static DataPackage getNewCurrentData() {
        DataPackage dp = DataPackage.clone(currentData);

        mIntervalCount ++;

        // rri and activity - returns every # instances of INTERVAL
        if(mIntervalCount == mRRIReturnAtInterval-1) {
            dp.rri += getRRI(dp.rri);
            dp.activity = getActivity(dp.rri);
        } else if(mIntervalCount == mRRIReturnAtInterval) {
            mIntervalCount = 0;
        }

        dp.ozone = getOzone();

        return dp;
    }

    private static float getRRI(float rri) {
        Random random = new Random();
        float rand = random.nextFloat();
        float scaled = rand * 0.2f;
        float shifted = scaled - 0.1f;
        float summed = rri + shifted;

        if(summed >= 0.3f && summed <= 1.2) {
            return shifted;
        } else {
            return 0f;
        }
    }

    private static float getActivity(float rri) {
        return 1/rri*0.33f;
    }

    private static float getOzone() {
        if(mIsOzoneInc) {
            if (mOzone + mOzoneInc <= mOzoneRng[1]) {
                mOzone += mOzoneInc;
            } else {
                mIsOzoneInc = false;
            }
        } else {
            if(mOzone - mOzoneInc >= mOzoneRng[0]) {
                mOzone -= mOzoneInc;
            } else {
                mIsOzoneInc = true;
            }
        }

        return mOzone;
    }


}
