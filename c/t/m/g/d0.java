package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d0.class */
public class d0 extends c2 {
    public f0 h;
    public b0 i;
    public long e = 5000;
    public CopyOnWriteArrayList<q> j = new CopyOnWriteArrayList<>();
    public e0 f = new e0();
    public c0 g = new c0();

    public d0() {
        h();
    }

    public static int a(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                return 2;
            }
            boolean z = true;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
            boolean z2 = (defaultSensor == null || defaultSensor.getName().toLowerCase(Locale.ENGLISH).contains("pseudo")) ? false : true;
            if (defaultSensor2 == null || defaultSensor2.getName().toLowerCase(Locale.ENGLISH).contains("pseudo")) {
                z = false;
            }
            if (z2 && z) {
                if (defaultSensor.getMinDelay() <= 43478) {
                    return defaultSensor2.getMinDelay() > 43478 ? 3 : 0;
                }
                return 3;
            }
            return 2;
        } catch (Throwable th) {
            return 2;
        }
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return 1;
        }
        int a2 = a(context);
        if (a2 != 0) {
            return a2;
        }
        return 0;
    }

    @Override // c.t.m.g.f2
    public int a(Looper looper) {
        try {
            Looper looper2 = e() == null ? null : e().getLooper();
            if (looper2 == null) {
                return -1;
            }
            b0 b0Var = new b0();
            this.i = b0Var;
            b0Var.a(3, 25, 0.8f, k0.f3858a, k0.b, x.d, x.e);
            a(this.f, looper2);
            a(this.g, looper2);
            a(this.h, looper2);
            a(1001, 2000L);
            j0.a("ArMgrImpl", "ar listeners size = " + this.j.size());
            return 0;
        } catch (Throwable th) {
            j0.a("ArMgrImpl", "startupSubPro error.", th);
            return th instanceof UnsatisfiedLinkError ? 5 : -1;
        }
    }

    public final long a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    @Override // c.t.m.g.f2
    public String a() {
        return "ArMgrImpl";
    }

    @Override // c.t.m.g.c2
    public void a(Message message) {
        if (d() != null && message.what == 1001) {
            a(1001, this.e);
            double[] a2 = this.i.a(System.currentTimeMillis());
            if (a2 != null) {
                h0 h0Var = new h0();
                h0Var.b(a2);
                h0Var.c(this.i.a());
                a(h0Var);
            }
        }
    }

    public final void a(d2 d2Var, Looper looper) {
        if (d2Var != null) {
            d2Var.a(looper);
        }
    }

    public final void a(o oVar) {
        Iterator<q> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(oVar);
        }
    }

    public void a(q qVar) {
        if (this.j.contains(qVar)) {
            return;
        }
        this.j.add(qVar);
        j0.a("ArMgrImpl", "addArListener:" + qVar.getClass().getSimpleName() + "@" + Integer.toHexString(qVar.hashCode()));
    }

    public final void a(d2... d2VarArr) {
        int length = d2VarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            d2 d2Var = d2VarArr[i2];
            if (d2Var != null) {
                d2Var.c();
            }
            i = i2 + 1;
        }
    }

    public boolean a(String str, String str2) {
        boolean z = false;
        try {
            j0.a("ArMgrImpl", "setArData:" + str + "," + str2);
            if ("set_is_d".equals(str)) {
                i0.f3836a = Integer.parseInt(str2) == 1;
            } else if ("set_ar_detect_cycle".equals(str)) {
                this.e = a(Long.parseLong(str2), 1000L, 15000L);
            } else if ("set_ar_model_tran_p".equals(str)) {
                return a(k0.f3858a, str2);
            } else {
                if ("set_ar_speed_model".equals(str)) {
                    return a(k0.b, str2);
                }
                if ("set_ar_svm_coefs".equals(str)) {
                    return a(x.d, str2);
                }
                if ("set_ar_svm_bias".equals(str)) {
                    return a(x.e, str2);
                }
                if ("set_ar_lr_coefs".equals(str)) {
                    return a(v.f4016a, str2);
                }
                if ("set_ar_lr_bias".equals(str)) {
                    return a(v.b, str2);
                }
                if (!"set_ar_open_available_checker".equals(str)) {
                    if ("set_ar_register_gps_type".equals(str)) {
                        this.g.a(Integer.parseInt(str2));
                    }
                    return z;
                }
                r.i = Boolean.parseBoolean(str2);
            }
            z = true;
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public final boolean a(double[] dArr, String str) {
        String[] split = str.split(",");
        if (split.length != dArr.length) {
            return false;
        }
        double[] a2 = h2.a().a(dArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.length) {
                System.arraycopy((Object) a2, 0, (Object) dArr, 0, dArr.length);
                h2.a().a(a2);
                return true;
            }
            a2[i2] = Double.parseDouble(split[i2]);
            i = i2 + 1;
        }
    }

    public final boolean a(double[][] dArr, String str) {
        String[] split = str.split(";");
        if (split.length != dArr.length) {
            return false;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, dArr.length, dArr[0].length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                a2.a(dArr, dArr2);
                return true;
            }
            String[] split2 = split[i2].split(",");
            if (split2.length != dArr[i2].length) {
                return false;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < split2.length) {
                    dArr2[i2][i4] = Double.parseDouble(split2[i4]);
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void b(q qVar) {
        if (qVar == null) {
            this.j.clear();
            j0.a("ArMgrImpl", "removeArListener:clear all");
            return;
        }
        this.j.remove(qVar);
        j0.a("ArMgrImpl", "removeArListener:" + qVar.getClass().getSimpleName() + "@" + Integer.toHexString(qVar.hashCode()));
    }

    @Override // c.t.m.g.f2
    public void c() {
        a(this.f, this.g, this.h);
        b0 b0Var = this.i;
        if (b0Var != null) {
            b0Var.d();
        }
        this.i = null;
        j0.a("ArMgrImpl", "status : [shutdown]");
    }

    @Override // c.t.m.g.c2
    public int g() {
        int b = b() ? 4 : b(q2.a());
        int i = b;
        if (b == 0) {
            int g = super.g();
            int i2 = g;
            if (g < 0) {
                i2 = 100;
            }
            i = i2;
            if (i2 != 0) {
                super.a(200L);
                i = i2;
            }
        }
        j0.a("ArMgrImpl", "startup : " + i + ", ar : " + p.a() + ", common lib: " + w1.a());
        return i;
    }

    public final void h() {
        j0.a("ArMgrImpl", "set ar default settings.");
        for (Map.Entry<String, String> entry : k0.a().entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }
}
