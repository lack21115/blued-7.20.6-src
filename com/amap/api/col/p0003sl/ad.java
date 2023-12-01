package com.amap.api.col.p0003sl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3sl.ad  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ad.class */
public final class ad implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private Sensor c;
    private Sensor d;
    private Context e;
    private IAMapDelegate f;
    private Marker g;
    private float h;
    private float[] i = new float[3];
    private float[] j = new float[3];
    private float[] k = new float[3];
    private float[] l = new float[9];
    private boolean m = true;

    public ad(Context context, IAMapDelegate iAMapDelegate) {
        this.e = context.getApplicationContext();
        this.f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null && c()) {
                this.b = this.a.getDefaultSensor(3);
                return;
            }
            this.c = this.a.getDefaultSensor(1);
            this.d = this.a.getDefaultSensor(2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private float a(float f) {
        return b(f);
    }

    private float a(float[] fArr, float[] fArr2) {
        if (SensorManager.getRotationMatrix(this.l, null, fArr, fArr2)) {
            SensorManager.getOrientation(this.l, this.k);
            float[] fArr3 = this.k;
            fArr3[0] = (float) Math.toDegrees(fArr3[0]);
            return this.k[0];
        }
        return 0.0f;
    }

    private static int a(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation != 1) {
                if (rotation != 2) {
                    return rotation != 3 ? 0 : -90;
                }
                return 180;
            }
            return 90;
        } catch (Throwable th) {
            return 0;
        }
    }

    private float b(float f) {
        float f2;
        float a = (f + a(this.e)) % 360.0f;
        if (a > 180.0f) {
            f2 = a - 360.0f;
        } else {
            f2 = a;
            if (a < -180.0f) {
                f2 = a + 360.0f;
            }
        }
        float f3 = f2;
        if (Float.isNaN(f2)) {
            f3 = 0.0f;
        }
        return f3;
    }

    private void c(float f) {
        Marker marker = this.g;
        if (marker != null) {
            try {
                if (!this.m) {
                    marker.setRotateAngle(360.0f - f);
                    return;
                }
                this.f.moveCamera(ak.d(f));
                this.g.setRotateAngle(-f);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean c() {
        SensorManager sensorManager = this.a;
        if (sensorManager == null) {
            return false;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            int type = sensor.getType();
            sensor.getStringType();
            if (type == 3) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor2 = this.b) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.a;
        if (sensorManager2 == null || (sensor = this.c) == null || this.d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.a.registerListener(this, this.d, 3);
    }

    public final void a(Marker marker) {
        this.g = marker;
    }

    public final void a(boolean z) {
        this.m = z;
    }

    public final void b() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor2 = this.b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.a;
        if (sensorManager2 == null || (sensor = this.c) == null || this.d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.a.unregisterListener(this, this.d);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f.getGLMapEngine() == null || this.f.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                if (type == 3) {
                    float f = sensorEvent.values[0];
                    float a = a(f);
                    if (Math.abs(this.h - f) < 3.0f) {
                        return;
                    }
                    this.h = a;
                    c(a);
                    return;
                }
                if (type == 1) {
                    this.i = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.j = (float[]) sensorEvent.values.clone();
                }
                float a2 = a(this.i, this.j);
                if (Math.abs(this.h - a2) < 3.0f) {
                    return;
                }
                this.h = a2;
                c(a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
