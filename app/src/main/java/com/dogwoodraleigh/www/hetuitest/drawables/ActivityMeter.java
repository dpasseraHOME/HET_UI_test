package com.dogwoodraleigh.www.hetuitest.drawables;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.Log;

import com.dogwoodraleigh.www.hetuitest.R;

/**
 * Created by dantepassera on 5/11/15.
 */
public class ActivityMeter extends ShapeDrawable {

    private static final String LOG_TAG = "ActivityMeter";

    public ActivityMeter(Context context) {
        setShape(getArc(context));
    }

    private Shape getArc(final Context context) {
        Log.d(LOG_TAG, "# getArc");

        return new Shape() {

            @Override
            public void draw(Canvas canvas, Paint paint) {
                Log.d(LOG_TAG, "# getArc.draw");

                paint.setAntiAlias(true);
                paint.setColor(context.getResources().getColor(R.color.low_risk_bkgd));
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5);
                paint.setStrokeCap(Paint.Cap.ROUND);

                RectF rectF = new RectF(0, 0, 300, 300);
                canvas.drawOval(rectF, paint);

                paint.setColor(context.getResources().getColor(R.color.high_risk_bkgd));
                canvas.drawArc(rectF, 0, 45, true, paint);

                /*paint.setStyle(Paint.Style.FILL);
                paint.setColor(context.getResources().getColor(R.color.ozone_max));
                canvas.drawCircle(600, 600, 30, paint);*/
            }
        };
    }

}
