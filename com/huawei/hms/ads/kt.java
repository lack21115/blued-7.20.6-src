package com.huawei.hms.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kt.class */
public class kt implements SensorEventListener {
    private static final String Code = "PhoneAccelerometerDetec";
    private static final float V = 9.80665f;
    private a B;
    private SensorManager I;
    private Sensor Z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kt$a.class */
    public interface a {
        void Code(float f, float f2, float f3);
    }

    public kt(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.I = sensorManager;
        this.Z = sensorManager.getDefaultSensor(1);
    }

    public void Code() {
        Sensor sensor = this.Z;
        if (sensor != null) {
            this.I.registerListener(this, sensor, 2);
        }
    }

    public void Code(a aVar) {
        this.B = aVar;
    }

    public void V() {
        try {
            this.I.unregisterListener(this, this.Z);
        } catch (Throwable th) {
            ge.I(Code, "unregister err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (1 == sensorEvent.sensor.getType()) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            ge.Code(Code, "onSensorChanged x:" + f + " y:" + f2 + " z:" + f3);
            a aVar = this.B;
            if (aVar != null) {
                aVar.Code(f, f2, f3);
            }
        }
    }
}
