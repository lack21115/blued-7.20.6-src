package com.danlan.android.cognition.sensor;

import android.hardware.SensorEvent;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/sensor/SensorCoreModel.class */
public abstract class SensorCoreModel {
    private int accuracy;
    private SensorEvent sensorEvent;
    private long timestamp;
    private Float x;
    private Float y;
    private Float z;

    public SensorCoreModel() {
    }

    public SensorCoreModel(SensorEvent sensorEvent) {
        this.sensorEvent = sensorEvent;
        this.timestamp = System.currentTimeMillis();
        this.accuracy = sensorEvent.accuracy;
        this.x = Float.valueOf(sensorEvent.values[0]);
        try {
            this.y = Float.valueOf(sensorEvent.values[1]);
        } catch (Exception e) {
            this.y = null;
        }
        try {
            this.z = Float.valueOf(sensorEvent.values[2]);
        } catch (Exception e2) {
            this.z = null;
        }
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Float getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }

    public Float getZ() {
        return this.z;
    }

    public void setAccuracy(int i) {
        this.accuracy = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setX(float f) {
        this.x = Float.valueOf(f);
    }

    public void setY(float f) {
        this.y = Float.valueOf(f);
    }

    public void setZ(float f) {
        this.z = Float.valueOf(f);
    }
}
