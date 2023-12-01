package c.t.m.g;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h0.class */
public class h0 extends g0 implements o {
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public double f3825c;
    public int d;
    public double e;
    public double[] f = new double[7];
    public Bundle g = new Bundle();

    public h0() {
        h();
    }

    public static final String a(int i) {
        if (i != 100) {
            if (i != 200) {
                if (i != 300) {
                    if (i != 400) {
                        switch (i) {
                            case 0:
                                return "unknown";
                            case 1:
                                return "still";
                            case 2:
                                return "walking";
                            case 3:
                                return "in_vehicle";
                            case 4:
                                return "on_bicycle";
                            case 5:
                                return "running";
                            case 6:
                                return "tilting";
                            default:
                                return "not_support_type";
                        }
                    }
                    return "tilting";
                }
                return "vehicle";
            }
            return "on_foot";
        }
        return "still";
    }

    @Override // c.t.m.g.o
    public int a() {
        return this.d;
    }

    public final boolean a(double[] dArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return false;
            }
            if (Double.isNaN(dArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // c.t.m.g.o
    public double b() {
        return this.d == 0 ? 1.0d - this.e : this.e;
    }

    public void b(double[] dArr) {
        double[] dArr2 = this.f;
        System.arraycopy((Object) dArr, 0, (Object) dArr2, 0, dArr2.length);
        boolean a2 = a(dArr);
        double[] dArr3 = this.f;
        if (dArr3[0] == 1.0d || dArr3[6] == 1.0d || a2) {
            int i = (this.f[0] == 1.0d || a2) ? 0 : 400;
            this.b = i;
            this.f3825c = i == 0 ? 0.0d : 1.0d;
            int i2 = 0;
            if (this.f[0] != 1.0d) {
                i2 = a2 ? 0 : 6;
            }
            this.d = i2;
            double d = 1.0d;
            if (i2 == 0) {
                d = 0.0d;
            }
            this.e = d;
            return;
        }
        int i3 = 1;
        double d2 = dArr3[1];
        double d3 = dArr3[3] + dArr3[4];
        double d4 = dArr3[2] + dArr3[5];
        int i4 = 100;
        double d5 = d2;
        if (d3 > d2) {
            i4 = 300;
            d5 = d3;
        }
        if (d4 > d5) {
            i4 = 200;
            d5 = d4;
        }
        this.f3825c = d5;
        if (d5 < 0.4d) {
            i4 = 0;
        }
        this.b = i4;
        int i5 = 2;
        while (i5 <= 5) {
            double[] dArr4 = this.f;
            int i6 = i3;
            if (dArr4[i5] > dArr4[i3]) {
                i6 = i5;
            }
            i5++;
            i3 = i6;
        }
        double d6 = this.f[i3];
        this.e = d6;
        if (d6 < 0.4d) {
            i3 = 0;
        }
        this.d = i3;
    }

    public void c(double[] dArr) {
        int i;
        if (dArr == null) {
            return;
        }
        boolean a2 = a(dArr);
        int i2 = 6;
        double d = 1.0d;
        if (a2 || dArr[0] == 1.0d || dArr[6] == 1.0d) {
            if (dArr[0] == 1.0d || a2) {
                i2 = 0;
            }
            i = i2;
            if (i2 == 0) {
                d = 0.0d;
                i = i2;
            }
        } else {
            int i3 = 2;
            int i4 = 1;
            while (true) {
                i = i4;
                if (i3 > 5) {
                    break;
                }
                int i5 = i;
                if (dArr[i3] > dArr[i]) {
                    i5 = i3;
                }
                i3++;
                i4 = i5;
            }
            double d2 = dArr[i];
            d = d2;
            if (d2 < 0.4d) {
                d = d2;
                i = 0;
            }
        }
        this.g.putInt("ar_no_gps_type", i);
        this.g.putDouble("ar_no_gps_conf", d);
        this.g.putDoubleArray("ar_no_gps_conf_arr", dArr);
    }

    @Deprecated
    public double d() {
        return this.b == 0 ? 1.0d - this.f3825c : this.f3825c;
    }

    @Deprecated
    public String e() {
        return p.a(this.b);
    }

    @Deprecated
    public int f() {
        return this.b;
    }

    public String g() {
        return p.a(this.d);
    }

    public void h() {
        a(System.currentTimeMillis());
        Arrays.fill(this.f, 0.0d);
        b(this.f);
        this.g.clear();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ArEvent{time=%d, type=%d, conf=%.4f, desc=%s, subType=%d, subConf=%.4f, subDesc=%s}", Long.valueOf(c()), Integer.valueOf(f()), Double.valueOf(d()), e(), Integer.valueOf(a()), Double.valueOf(b()), g());
    }
}
