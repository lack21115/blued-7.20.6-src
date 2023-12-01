package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n4.class */
public class n4 {
    public static n4 e = new n4();

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<b5> f3891a;
    public LinkedList<a> b;

    /* renamed from: c  reason: collision with root package name */
    public int f3892c;
    public double[] d;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n4$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f3893a;
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n4$b.class */
    public enum b {
        UNKNOW,
        MOVE,
        STATIC
    }

    public n4() {
        b bVar = b.UNKNOW;
        this.f3891a = new LinkedList<>();
        this.b = new LinkedList<>();
        this.f3892c = -1;
        this.d = new double[]{0.0d, 0.0d};
    }

    public static n4 b() {
        return e;
    }

    public final boolean a(Location location, Location location2) {
        if (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) {
            return false;
        }
        return Math.abs(location.getLatitude() - location2.getLatitude()) >= 1.0E-7d || Math.abs(location.getLongitude() - location2.getLongitude()) >= 1.0E-7d;
    }

    public final boolean a(b5 b5Var) {
        int i;
        while (this.f3891a.size() > 9) {
            this.f3891a.remove(0);
        }
        while (this.f3891a.size() > 0) {
            b5 first = this.f3891a.getFirst();
            long j = b5Var.b;
            long j2 = first.b;
            double a2 = f6.a(first.f3763a.getLatitude(), first.f3763a.getLongitude(), b5Var.f3763a.getLatitude(), b5Var.f3763a.getLongitude());
            if (j - j2 <= 180000 || a2 <= 500.0d) {
                break;
            }
            this.f3891a.remove(0);
        }
        int size = this.f3891a.size();
        if (size >= 5) {
            int i2 = size - 2;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 < 0) {
                    break;
                }
                int i4 = i;
                if (!a(b5Var.f3763a, this.f3891a.get(i2).f3763a)) {
                    i4 = i + 1;
                }
                i2--;
                i3 = i4;
            }
            return i < 4 || b5Var.f3763a.getAccuracy() >= 20.0f;
        }
        return true;
    }

    public double[] a() {
        double[] dArr = this.d;
        double d = 0.0d;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        if (this.f3891a.size() < 2) {
            return this.d;
        }
        int size = this.f3891a.size();
        double d2 = 0.0d;
        long j = 0;
        for (int i = 1; i < size; i++) {
            b5 b5Var = this.f3891a.get(i);
            b5 b5Var2 = this.f3891a.get(i - 1);
            d2 += f6.a(b5Var2.f3763a.getLatitude(), b5Var2.f3763a.getLongitude(), b5Var.f3763a.getLatitude(), b5Var.f3763a.getLongitude());
            j += b5Var.b - b5Var2.b;
            d += b5Var2.f3763a.getSpeed();
        }
        double speed = this.f3891a.getLast().f3763a.getSpeed();
        if (j > 0) {
            double[] dArr2 = this.d;
            dArr2[0] = (d + speed) / size;
            dArr2[1] = (d2 / j) * 1000.0d;
        }
        return this.d;
    }

    public int b(b5 b5Var) {
        synchronized (this) {
            if (b5Var != null) {
                b5 b5Var2 = new b5(b5Var);
                this.f3891a.add(b5Var2);
                if (!a(b5Var2)) {
                    return -1;
                }
                if (!c()) {
                    return -2;
                }
            }
            return this.f3891a.size();
        }
    }

    public final boolean c() {
        if (this.b.isEmpty()) {
            return true;
        }
        double[] a2 = a();
        if (System.currentTimeMillis() - this.b.getLast().f3893a >= 5000 || this.f3892c != 1) {
            return true;
        }
        return a2[0] <= 5.0d && a2[1] <= 5.0d;
    }
}
