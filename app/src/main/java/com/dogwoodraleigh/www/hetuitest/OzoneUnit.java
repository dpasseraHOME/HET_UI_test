package com.dogwoodraleigh.www.hetuitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Dante on 5/10/2015.
 */
public class OzoneUnit extends ShapeDrawable {

    private static final float START_RADIUS = 18f;

    public OzoneUnit(Context context, float cX, float cY) {
        setShape(getCircle(context, cX, cY));
    }

    public void setLevel(float level) {
        //TODO: animate to new radius based on level
    }

    private Shape getCircle(final Context context, final float cX, final float cY) {
        return new Shape() {

            @Override
            public void draw(Canvas canvas, Paint paint) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(context.getResources().getColor(R.color.ozone_min));
                canvas.drawCircle(cX, cY, START_RADIUS, paint);
            }
        };
    }

}
