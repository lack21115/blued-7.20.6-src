package c.t.m.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e0.class */
public class e0 extends d2 {
    public a d = null;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f3747c = (SensorManager) q2.a().getSystemService("sensor");

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e0$a.class */
    public static class a extends Handler implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public volatile SensorEvent f3748a;
        public volatile SensorEvent b;

        /* renamed from: c  reason: collision with root package name */
        public volatile long f3749c;
        public long d;
        public long e;
        public long f;
        public int g;
        public volatile double h;

        public a(Looper looper) {
            super(looper);
            this.f3749c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.g = 0;
            this.h = 50.0d;
            this.d = 40L;
        }

        public final void a(Message message) {
            if (message.what != 2001) {
                return;
            }
            removeMessages(2001);
            sendEmptyMessageDelayed(2001, 20L);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f3748a == null || this.b == null) {
                if (Math.abs(currentTimeMillis - this.f) >= 30000) {
                    g3.a("AR", "acc or gyr is null.");
                    this.f = currentTimeMillis;
                    return;
                }
                return;
            }
            float[] fArr = this.f3748a.values;
            float[] fArr2 = this.b.values;
            if (currentTimeMillis - this.e < this.d) {
                return;
            }
            if (Math.abs(currentTimeMillis - this.f) >= 30000) {
                g3.a("AR", "accuracy:acc=" + this.f3748a.accuracy + ", gyr=" + this.b.accuracy);
                this.f = currentTimeMillis;
            }
            this.e = currentTimeMillis;
            if (b0.b() != null) {
                b0.b().a(currentTimeMillis, fArr, fArr2);
            }
            if (currentTimeMillis - this.f3749c > 2500 || this.h < 20.0d) {
                j0.a("SensorHandler", "Ar reset by sensor:" + (currentTimeMillis - this.f3749c) + "," + k3.a(this.h, 2));
                if (b0.b() != null) {
                    b0.b().c();
                }
                this.b = null;
                this.f3748a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Throwable th) {
                j0.a("SensorHandler", Thread.currentThread().getName() + " error.", th);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            g3.a("AR", "sensor accuracy changed," + sensor.getType() + "," + i + "," + sensor.getName());
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 4) {
                    return;
                }
                this.b = sensorEvent;
                return;
            }
            this.f3748a = sensorEvent;
            int i = this.g + 1;
            this.g = i;
            if (i == 25 || this.f3749c == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                double d = 50.0d;
                if (this.f3749c != 0) {
                    if (currentTimeMillis != this.f3749c) {
                        d = 1000.0d / ((currentTimeMillis - this.f3749c) / 25.0d);
                    }
                    this.h = d;
                } else {
                    this.h = 50.0d;
                }
                this.f3749c = currentTimeMillis;
                this.g = 0;
            }
        }
    }

    @Override // c.t.m.g.e2
    public String a() {
        return "ArSensorPro";
    }

    @Override // c.t.m.g.d2
    public int b(Looper looper) {
        if (this.f3747c == null) {
            return -1;
        }
        a aVar = new a(looper);
        this.d = aVar;
        SensorManager sensorManager = this.f3747c;
        sensorManager.registerListener(aVar, sensorManager.getDefaultSensor(1), 1, this.d);
        SensorManager sensorManager2 = this.f3747c;
        sensorManager2.registerListener(this.d, sensorManager2.getDefaultSensor(4), 1, this.d);
        this.d.sendEmptyMessageDelayed(2001, 100L);
        j0.a("ArSensorPro", "status:[start]");
        return 0;
    }

    @Override // c.t.m.g.e2
    public void d() {
        this.f3747c.unregisterListener(this.d);
        a aVar = this.d;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
        this.d = null;
        j0.a("ArSensorPro", "status:[shutdown]");
    }
}
