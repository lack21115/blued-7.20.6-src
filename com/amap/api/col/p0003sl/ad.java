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

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f4732a;
    private Sensor b;

    /* renamed from: c  reason: collision with root package name */
    private Sensor f4733c;
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
            this.f4732a = sensorManager;
            if (sensorManager != null && c()) {
                this.b = this.f4732a.getDefaultSensor(3);
                return;
            }
            this.f4733c = this.f4732a.getDefaultSensor(1);
            this.d = this.f4732a.getDefaultSensor(2);
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
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE)) == null) {
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
        float a2 = (f + a(this.e)) % 360.0f;
        if (a2 > 180.0f) {
            f2 = a2 - 360.0f;
        } else {
            f2 = a2;
            if (a2 < -180.0f) {
                f2 = a2 + 360.0f;
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
        SensorManager sensorManager = this.f4732a;
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
        SensorManager sensorManager = this.f4732a;
        if (sensorManager != null && (sensor2 = this.b) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.f4732a;
        if (sensorManager2 == null || (sensor = this.f4733c) == null || this.d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.f4732a.registerListener(this, this.d, 3);
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
        SensorManager sensorManager = this.f4732a;
        if (sensorManager != null && (sensor2 = this.b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f4732a;
        if (sensorManager2 == null || (sensor = this.f4733c) == null || this.d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f4732a.unregisterListener(this, this.d);
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
                    float a2 = a(f);
                    if (Math.abs(this.h - f) < 3.0f) {
                        return;
                    }
                    this.h = a2;
                    c(a2);
                    return;
                }
                if (type == 1) {
                    this.i = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.j = (float[]) sensorEvent.values.clone();
                }
                float a3 = a(this.i, this.j);
                if (Math.abs(this.h - a3) < 3.0f) {
                    return;
                }
                this.h = a3;
                c(a3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
