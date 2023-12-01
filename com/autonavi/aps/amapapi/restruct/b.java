package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/restruct/b.class */
public final class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    SensorManager f6404a;
    Sensor b;

    /* renamed from: c  reason: collision with root package name */
    Sensor f6405c;
    Sensor d;
    private Context s;
    public boolean e = false;
    public double f = 0.0d;
    public float g = 0.0f;
    private float t = 1013.25f;
    private float u = 0.0f;
    Handler h = new Handler();
    double i = 0.0d;
    double j = 0.0d;
    double k = 0.0d;
    double l = 0.0d;
    double[] m = new double[3];
    volatile double n = 0.0d;
    long o = 0;
    long p = 0;
    final int q = 100;
    final int r = 30;

    public b(Context context) {
        this.s = null;
        this.f6404a = null;
        this.b = null;
        this.f6405c = null;
        this.d = null;
        try {
            this.s = context;
            if (this.f6404a == null) {
                this.f6404a = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.b = this.f6404a.getDefaultSensor(6);
            } catch (Throwable th) {
            }
            try {
                this.f6405c = this.f6404a.getDefaultSensor(11);
            } catch (Throwable th2) {
            }
            try {
                this.d = this.f6404a.getDefaultSensor(1);
            } catch (Throwable th3) {
            }
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "AMapSensorManager", "<init>");
        }
    }

    private void a(float[] fArr) {
        double[] dArr = this.m;
        dArr[0] = (dArr[0] * 0.800000011920929d) + (fArr[0] * 0.19999999f);
        dArr[1] = (dArr[1] * 0.800000011920929d) + (fArr[1] * 0.19999999f);
        dArr[2] = (dArr[2] * 0.800000011920929d) + (fArr[2] * 0.19999999f);
        this.i = fArr[0] - dArr[0];
        this.j = fArr[1] - dArr[1];
        this.k = fArr[2] - dArr[2];
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.o < 100) {
            return;
        }
        double d = this.i;
        double d2 = this.j;
        double d3 = this.k;
        double sqrt = Math.sqrt((d * d) + (d2 * d2) + (d3 * d3));
        this.p++;
        this.o = currentTimeMillis;
        this.n += sqrt;
        if (this.p >= 30) {
            this.l = this.n / this.p;
            this.n = 0.0d;
            this.p = 0L;
        }
    }

    private void b(float[] fArr) {
        if (fArr != null) {
            this.f = com.autonavi.aps.amapapi.utils.i.a(SensorManager.getAltitude(this.t, fArr[0]));
        }
    }

    private void c(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            float[] fArr3 = new float[3];
            SensorManager.getOrientation(fArr2, fArr3);
            float degrees = (float) Math.toDegrees(fArr3[0]);
            this.u = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.u = (float) Math.floor(degrees);
        }
    }

    public final void a() {
        SensorManager sensorManager = this.f6404a;
        if (sensorManager == null || this.e) {
            return;
        }
        this.e = true;
        try {
            if (this.b != null) {
                sensorManager.registerListener(this, this.b, 3, this.h);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            if (this.f6405c != null) {
                this.f6404a.registerListener(this, this.f6405c, 3, this.h);
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            if (this.d != null) {
                this.f6404a.registerListener(this, this.d, 3, this.h);
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public final void b() {
        SensorManager sensorManager = this.f6404a;
        if (sensorManager == null || !this.e) {
            return;
        }
        this.e = false;
        try {
            if (this.b != null) {
                sensorManager.unregisterListener(this, this.b);
            }
        } catch (Throwable th) {
        }
        try {
            if (this.f6405c != null) {
                this.f6404a.unregisterListener(this, this.f6405c);
            }
        } catch (Throwable th2) {
        }
        try {
            if (this.d != null) {
                this.f6404a.unregisterListener(this, this.d);
            }
        } catch (Throwable th3) {
        }
    }

    public final double c() {
        return this.f;
    }

    public final float d() {
        return this.u;
    }

    public final double e() {
        return this.l;
    }

    public final void f() {
        try {
            b();
            this.b = null;
            this.f6405c = null;
            this.f6404a = null;
            this.d = null;
            this.e = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "destroy");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.d != null) {
                    a((float[]) sensorEvent.values.clone());
                }
            } else if (type != 6) {
                if (type != 11) {
                    return;
                }
                try {
                    if (this.f6405c != null) {
                        c((float[]) sensorEvent.values.clone());
                    }
                } catch (Throwable th) {
                }
            } else {
                try {
                    if (this.b != null) {
                        float[] fArr = (float[]) sensorEvent.values.clone();
                        if (fArr != null) {
                            this.g = fArr[0];
                        }
                        b(fArr);
                    }
                } catch (Throwable th2) {
                }
            }
        } catch (Throwable th3) {
        }
    }
}
