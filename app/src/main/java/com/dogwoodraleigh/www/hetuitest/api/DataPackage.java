package com.dogwoodraleigh.www.hetuitest.api;

/**
 * Created by dantepassera on 5/13/15.
 */
public class DataPackage {

    public float time;
    public float accX;
    public float accY;
    public float accZ;
    public float activity;
    public float rri;
    public float ecg;
    public float ozone;
    public float risk;

    public DataPackage(
        float time,
        float accX, float accY, float accZ,
        float activity,
        float rri, float ecg,
        float ozone,
        float risk
    ) {
        this.time = time;
        this.accX = accX;
        this.accY = accY;
        this.accZ = accZ;
        this.activity = activity;
        this.rri = rri;
        this.ecg = ecg;
        this.ozone = ozone;
        this.risk = risk;
    }

    public static DataPackage clone(DataPackage src) {
        return new DataPackage(
                src.time,
                src.accX, src.accY, src.accZ,
                src.activity,
                src.rri, src.ecg,
                src.ozone,
                src.risk
        );
    }

}
