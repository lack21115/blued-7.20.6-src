package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n6.class */
public class n6 {

    /* renamed from: a  reason: collision with root package name */
    public b f3850a;
    public SensorManager b;

    /* renamed from: c  reason: collision with root package name */
    public o6 f3851c;
    public p d;
    public p6 e;
    public boolean g;
    public boolean f = false;
    public final p1 h = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n6$a.class */
    public class a extends p1 {
        public a() {
        }

        @Override // c.t.m.g.p1
        public void a(o1 o1Var) {
            q1 q1Var;
            if (o1Var.a() == 10001 && (q1Var = (q1) o1Var) != null) {
                c3.b(n6.this.f3850a, 4005, 0, 0, q1Var.f3895a);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n6$b.class */
    public static class b extends Handler implements SensorEventListener, q {
        public static final String i = b.class.getSimpleName();

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<SensorEvent> f3853a;
        public WeakReference<n6> b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f3854c;
        public final float[] d;
        public final float[] e;
        public double f;
        public double g;
        public double h;

        public b(Looper looper, n6 n6Var) {
            super(looper);
            this.f3853a = new SparseArray<>();
            this.f3854c = new float[16];
            this.d = new float[16];
            this.e = new float[]{0.0f, 0.0f, 0.0f};
            this.f = 0.0d;
            this.g = 0.0d;
            this.h = 0.0d;
            this.b = new WeakReference<>(n6Var);
        }

        public final void a() {
            synchronized (this.f3853a) {
                this.f3853a.clear();
            }
        }

        public final void a(Message message) {
            switch (message.what) {
                case 4001:
                    removeMessages(4001);
                    sendEmptyMessageDelayed(4001, 40L);
                    SensorEvent sensorEvent = this.f3853a.get(1);
                    SensorEvent sensorEvent2 = this.f3853a.get(4);
                    SensorEvent sensorEvent3 = this.f3853a.get(2);
                    SensorEvent sensorEvent4 = this.f3853a.get(11);
                    SensorEvent sensorEvent5 = this.f3853a.get(9);
                    if (sensorEvent4 != null) {
                        SensorManager.getRotationMatrixFromVector(this.f3854c, sensorEvent4.values);
                        boolean a2 = a(sensorEvent5);
                        if (a2) {
                            SensorManager.remapCoordinateSystem(this.f3854c, 1, 3, this.d);
                        }
                        SensorManager.getOrientation(a2 ? this.d : this.f3854c, this.e);
                    }
                    if (sensorEvent == null || sensorEvent2 == null || sensorEvent3 == null || sensorEvent4 == null) {
                        return;
                    }
                    o6 o6Var = this.b.get().f3851c;
                    long j = sensorEvent.timestamp;
                    float[] fArr = sensorEvent.values;
                    float f = fArr[0];
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    long j2 = sensorEvent2.timestamp;
                    float[] fArr2 = sensorEvent2.values;
                    float f4 = fArr2[0];
                    float f5 = fArr2[1];
                    float f6 = fArr2[2];
                    long j3 = sensorEvent3.timestamp;
                    float[] fArr3 = sensorEvent3.values;
                    float f7 = fArr3[0];
                    float f8 = fArr3[1];
                    float f9 = fArr3[2];
                    long j4 = sensorEvent4.timestamp;
                    float[] fArr4 = this.e;
                    o6Var.a(j, f, f2, f3, j2, f4, f5, f6, j3, f7, f8, f9, j4, fArr4[0], fArr4[1], fArr4[2]);
                    return;
                case 4002:
                    this.b.get().f3851c.a();
                    a();
                    removeCallbacksAndMessages(null);
                    a3.a("tc_pdr_thread");
                    return;
                case 4003:
                default:
                    return;
                case 4004:
                    int i2 = message.arg1;
                    this.b.get().f3851c.d();
                    this.b.get().f3851c.a((double[][]) null, i2);
                    c3.b(this, 4001);
                    return;
                case 4005:
                    Object obj = message.obj;
                    Location location = null;
                    if (obj != null) {
                        location = (Location) obj;
                    }
                    if (location != null) {
                        this.b.get().f3851c.a(System.currentTimeMillis() / 1000.0d, location.getTime() / 1000.0d, location.getLatitude(), location.getLongitude(), location.hasAltitude() ? location.getAltitude() : 9999.0d, location.hasAccuracy() ? location.getAccuracy() : 9999.0d, location.hasSpeed() ? location.getSpeed() : 9999.0d, location.hasBearing() ? location.getBearing() : 9999.0d);
                        return;
                    }
                    return;
                case 4006:
                    Object obj2 = message.obj;
                    o oVar = null;
                    if (obj2 != null) {
                        oVar = (o) obj2;
                    }
                    if (oVar != null) {
                        g3.b("AR", oVar.a() + "," + oVar.b());
                        this.b.get().f3851c.a(oVar.a(), oVar.b());
                        return;
                    }
                    return;
            }
        }

        @Override // c.t.m.g.q
        public void a(o oVar) {
            Message obtainMessage = obtainMessage();
            obtainMessage.what = 4006;
            obtainMessage.obj = oVar;
            c3.a(this, obtainMessage);
        }

        public final boolean a(SensorEvent sensorEvent) {
            boolean z = false;
            if (sensorEvent == null) {
                return false;
            }
            float[] fArr = sensorEvent.values;
            double d = fArr[0] * fArr[0];
            double d2 = fArr[1] * fArr[1];
            double d3 = fArr[2] * fArr[2];
            double d4 = this.f;
            if (d4 != 0.0d) {
                d = (d * 0.1d) + (d4 * 0.9d);
            }
            this.f = d;
            double d5 = this.g;
            this.g = d5 == 0.0d ? d2 : (d2 * 0.1d) + (d5 * 0.9d);
            double d6 = this.h;
            double d7 = d6 == 0.0d ? d3 : (d3 * 0.1d) + (d6 * 0.9d);
            this.h = d7;
            if (this.f + d7 < 25.0d || this.g + d7 < 25.0d) {
                z = true;
            }
            return z;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (this.f3853a) {
                sensorEvent.timestamp = System.currentTimeMillis();
                this.f3853a.put(sensorEvent.sensor.getType(), sensorEvent);
            }
        }
    }

    public n6(Context context) {
        this.g = true;
        try {
            p6 p6Var = new p6();
            this.e = p6Var;
            p6Var.a(context);
            this.b = (SensorManager) context.getSystemService("sensor");
            this.d = p.a(context);
            this.f3851c = o6.b();
        } catch (Throwable th) {
            th.printStackTrace();
            this.g = false;
        }
    }

    public int a(int i) {
        if (this.f) {
            return -2;
        }
        boolean e = e();
        this.g = e;
        if (e) {
            this.f3850a = new b(a3.b("tc_pdr_thread").getLooper(), this);
            if (!h()) {
                a();
                return -3;
            }
            int g = g();
            if (g != 0) {
                a();
                return g;
            }
            g3.b("DR", "startup," + i);
            f();
            c3.b(this.f3850a, 4004, i, 0, null);
            this.f = true;
            return 0;
        }
        return -1;
    }

    public final void a() {
        c3.b(this.f3850a);
        c3.b(this.f3850a, 4002);
        this.f3850a = null;
    }

    public double[] b() {
        if (this.f) {
            return this.f3851c.c();
        }
        return null;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.g;
    }

    public final boolean e() {
        SensorManager sensorManager = this.b;
        boolean z = true;
        boolean z2 = true;
        if (sensorManager == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("sen:");
            if (this.b != null) {
                z2 = false;
            }
            sb.append(z2);
            g3.b("DR", sb.toString());
            return false;
        }
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(11);
            Sensor defaultSensor2 = this.b.getDefaultSensor(1);
            Sensor defaultSensor3 = this.b.getDefaultSensor(4);
            Sensor defaultSensor4 = this.b.getDefaultSensor(2);
            Sensor defaultSensor5 = this.b.getDefaultSensor(9);
            Locale locale = Locale.ENGLISH;
            boolean z3 = defaultSensor == null;
            boolean z4 = defaultSensor2 == null;
            boolean z5 = defaultSensor3 == null;
            boolean z6 = defaultSensor4 == null;
            if (defaultSensor5 != null) {
                z = false;
            }
            g3.b("SEN", String.format(locale, "has:%.1b,%.1b,%.1b,%.1b,%.1b", Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z)));
            if (defaultSensor == null || defaultSensor2 == null || defaultSensor3 == null || defaultSensor4 == null) {
                this.g = false;
            }
        } catch (Throwable th) {
            this.g = false;
        }
        return this.g;
    }

    public final void f() {
        this.d.c();
        this.d.a(this.f3850a);
        this.d.a("set_ar_detect_cycle", Constants.DEFAULT_UIN);
    }

    public final int g() {
        n1.a().a(this.h);
        return 0;
    }

    public final boolean h() {
        try {
            boolean registerListener = this.b.registerListener(this.f3850a, this.b.getDefaultSensor(11), 10000, this.f3850a);
            boolean registerListener2 = this.b.registerListener(this.f3850a, this.b.getDefaultSensor(1), 10000, this.f3850a);
            boolean registerListener3 = this.b.registerListener(this.f3850a, this.b.getDefaultSensor(4), 10000, this.f3850a);
            boolean registerListener4 = this.b.registerListener(this.f3850a, this.b.getDefaultSensor(2), 10000, this.f3850a);
            boolean registerListener5 = this.b.registerListener(this.f3850a, this.b.getDefaultSensor(9), 10000, this.f3850a);
            g3.b("Sen", String.format(Locale.ENGLISH, "register:%.1b,%.1b,%.1b,%.1b,%.1b", Boolean.valueOf(registerListener), Boolean.valueOf(registerListener2), Boolean.valueOf(registerListener3), Boolean.valueOf(registerListener4), Boolean.valueOf(registerListener5)));
            return true;
        } catch (Throwable th) {
            g3.a("SEN_E", "REGISTER ERR");
            return false;
        }
    }

    public void i() {
        if (this.f) {
            g3.b("DR", "shutdown");
            this.b.unregisterListener(this.f3850a);
            n1.a().b(this.h);
            this.d.b(this.f3850a);
            this.d.b();
            a();
            this.f = false;
            this.e.a();
        }
    }
}
