package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h2.class */
public class h2 {
    public static h2 e = new h2();
    public static final Comparator<double[]> f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<double[]> f3827a = new ArrayList(32);
    public final List<double[]> b = new ArrayList(32);

    /* renamed from: c  reason: collision with root package name */
    public int f3828c = 0;
    public int d = 4096;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h2$a.class */
    public static final class a implements Comparator<double[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(double[] dArr, double[] dArr2) {
            return dArr.length - dArr2.length;
        }
    }

    public static h2 a() {
        return e;
    }

    public void a(double[] dArr) {
        synchronized (this) {
            if (dArr != null) {
                if (dArr.length <= this.d) {
                    Arrays.fill(dArr, 0.0d);
                    this.f3827a.add(dArr);
                    int binarySearch = Collections.binarySearch(this.b, dArr, f);
                    int i = binarySearch;
                    if (binarySearch < 0) {
                        i = (-binarySearch) - 1;
                    }
                    this.b.add(i, dArr);
                    this.f3828c += dArr.length;
                    b();
                }
            }
        }
    }

    public double[] a(int i) {
        synchronized (this) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.b.size()) {
                    return new double[i];
                }
                double[] dArr = this.b.get(i3);
                if (dArr.length == i) {
                    this.f3828c -= dArr.length;
                    this.b.remove(i3);
                    this.f3827a.remove(dArr);
                    return dArr;
                }
                i2 = i3 + 1;
            }
        }
    }

    public final void b() {
        synchronized (this) {
            while (this.f3828c > this.d) {
                double[] remove = this.f3827a.remove(0);
                this.b.remove(remove);
                this.f3828c -= remove.length;
            }
        }
    }
}
