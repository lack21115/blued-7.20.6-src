package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m4.class */
public class m4 implements SensorEventListener {
    public static volatile m4 e;

    /* renamed from: a  reason: collision with root package name */
    public final SensorManager f3882a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3883c;
    public double d;

    public m4(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f3882a = sensorManager;
        this.b = sensorManager != null;
    }

    public static m4 a(Context context) {
        if (e == null) {
            e = new m4(context);
        }
        return e;
    }

    public double a() {
        double d;
        if (this.f3883c) {
            synchronized (this) {
                d = this.d;
            }
            return d;
        }
        return Double.NaN;
    }

    public void a(Handler handler) {
        if (this.b && !this.f3883c) {
            try {
                Sensor defaultSensor = this.f3882a.getDefaultSensor(11);
                if (defaultSensor == null || handler == null) {
                    return;
                }
                this.f3882a.registerListener(this, defaultSensor, 3, handler);
                this.f3883c = true;
            } catch (Throwable th) {
            }
        }
    }

    public void b() {
        if (this.b && this.f3883c) {
            this.f3883c = false;
            synchronized (this) {
                this.d = Double.NaN;
            }
            this.f3882a.unregisterListener(this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 11) {
                float[] fArr = new float[16];
                float[] fArr2 = new float[3];
                SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
                SensorManager.getOrientation(fArr, fArr2);
                double d = fArr2[0];
                synchronized (this) {
                    this.d = (d * 180.0d) / 3.1415926d;
                }
            }
        } catch (Throwable th) {
        }
    }
}
