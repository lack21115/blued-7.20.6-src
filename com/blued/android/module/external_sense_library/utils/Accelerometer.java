package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/Accelerometer.class */
public class Accelerometer {
    private static SensorEvent b;
    private static CLOCKWISE_ANGLE d;
    private SensorManager a;
    private boolean c = false;
    private SensorEventListener e = new SensorEventListener() { // from class: com.blued.android.module.external_sense_library.utils.Accelerometer.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            SensorEvent unused = Accelerometer.b = sensorEvent;
            if (sensorEvent.sensor.getType() == 1) {
                float f = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                float f3 = sensorEvent.values[2];
                if (Math.abs(f) > 3.0f || Math.abs(f2) > 3.0f) {
                    if (Math.abs(f) > Math.abs(f2)) {
                        if (f > 0.0f) {
                            CLOCKWISE_ANGLE unused2 = Accelerometer.d = CLOCKWISE_ANGLE.Deg0;
                            Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg0");
                            return;
                        }
                        CLOCKWISE_ANGLE unused3 = Accelerometer.d = CLOCKWISE_ANGLE.Deg180;
                        Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg180");
                    } else if (f2 > 0.0f) {
                        CLOCKWISE_ANGLE unused4 = Accelerometer.d = CLOCKWISE_ANGLE.Deg90;
                        Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg90");
                    } else {
                        CLOCKWISE_ANGLE unused5 = Accelerometer.d = CLOCKWISE_ANGLE.Deg270;
                        Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg270");
                    }
                }
            }
        }
    };

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/Accelerometer$CLOCKWISE_ANGLE.class */
    public enum CLOCKWISE_ANGLE {
        Deg0(0),
        Deg90(1),
        Deg180(2),
        Deg270(3);
        
        private int e;

        CLOCKWISE_ANGLE(int i) {
            this.e = i;
        }

        public int a() {
            return this.e;
        }
    }

    public Accelerometer(Context context) {
        this.a = null;
        this.a = (SensorManager) context.getSystemService("sensor");
        d = CLOCKWISE_ANGLE.Deg90;
    }

    public static int c() {
        return d.a();
    }

    public void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        d = CLOCKWISE_ANGLE.Deg90;
        SensorManager sensorManager = this.a;
        sensorManager.registerListener(this.e, sensorManager.getDefaultSensor(1), 3);
    }

    public void b() {
        if (this.c) {
            this.c = false;
            this.a.unregisterListener(this.e);
        }
    }
}
