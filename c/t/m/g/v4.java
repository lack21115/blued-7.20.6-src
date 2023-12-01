package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v4.class */
public class v4 {

    /* renamed from: a  reason: collision with root package name */
    public int f4024a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<a> f4025c;
    public j4 d;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v4$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public double f4026a;
        public double b;

        /* renamed from: c  reason: collision with root package name */
        public long f4027c;
        public int d;

        public static a a(TencentLocation tencentLocation) {
            a aVar = new a();
            aVar.f4026a = tencentLocation.getLatitude();
            aVar.b = tencentLocation.getLongitude();
            aVar.f4027c = tencentLocation.getTime();
            tencentLocation.getSpeed();
            int i = 2;
            if (TencentLocationUtils.isFromGps(tencentLocation)) {
                if (tencentLocation.getAccuracy() < 100.0f) {
                    i = 3;
                }
                aVar.d = i;
                return aVar;
            }
            if (tencentLocation.getAccuracy() >= 500.0f) {
                i = 1;
            }
            aVar.d = i;
            return aVar;
        }

        public boolean a(a aVar) {
            return f6.a(this.f4026a, this.b, aVar.f4026a, aVar.b) / (((double) (Math.abs(this.f4027c - aVar.f4027c) + 1)) / 1000.0d) <= 100.0d;
        }

        public String toString() {
            return "[" + this.f4026a + "," + this.b + "]";
        }
    }

    public v4(int i, int i2) {
        if (i < i2) {
            throw new IllegalArgumentException("maxSize should >= coreSize");
        }
        if (i2 < 3) {
            throw new IllegalArgumentException("coreSize should >= 3");
        }
        this.f4025c = new LinkedList<>();
        this.f4024a = i;
        this.b = i2;
        this.d = new j4();
    }

    public void a(q5 q5Var) {
        synchronized (this) {
            if (!q5Var.getProvider().equalsIgnoreCase("gps") || n0.b().b("gps_kalman")) {
                if (this.f4025c.size() == 0) {
                    return;
                }
                this.d.a(q5Var.getLatitude(), q5Var.getLongitude(), q5Var.getAccuracy(), q5Var.getTime());
                q5Var.a(this.d.a(), this.d.b());
            }
        }
    }

    public void a(TencentLocation tencentLocation) {
        synchronized (this) {
            this.f4025c.add(a.a(tencentLocation));
            if (this.f4025c.size() > this.f4024a) {
                this.f4025c.removeFirst();
            }
        }
    }

    public final boolean a() {
        return this.f4025c.size() >= this.b;
    }

    public final boolean a(a aVar, t3 t3Var, boolean z) {
        int i;
        int i2;
        synchronized (this) {
            if (t3Var != null) {
                LinkedList<a> linkedList = this.f4025c;
                if (linkedList != null && linkedList.size() != 0) {
                    int i3 = aVar.d;
                    if (i3 == 3) {
                        return true;
                    }
                    if (i3 != 1 || h6.b(t3Var) || h6.c(t3Var) || z) {
                        if (aVar.f4027c - this.f4025c.getLast().f4027c > com.igexin.push.config.c.l) {
                            this.f4025c.clear();
                            return true;
                        }
                        if (a()) {
                            LinkedList<a> linkedList2 = this.f4025c;
                            ListIterator<a> listIterator = linkedList2.listIterator(linkedList2.size());
                            int i4 = 0;
                            int i5 = 0;
                            do {
                                i = i4;
                                if (!listIterator.hasPrevious()) {
                                    break;
                                }
                                i = i4;
                                if (!listIterator.previous().a(aVar)) {
                                    i = i4 + 1;
                                }
                                i2 = i5 + 1;
                                i4 = i;
                                i5 = i2;
                            } while (i2 <= this.b);
                            if (i > 1) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }
    }

    public boolean a(TencentLocation tencentLocation, t3 t3Var, boolean z) {
        return a(a.a(tencentLocation), t3Var, z);
    }

    public void b() {
        synchronized (this) {
            this.f4025c.clear();
            this.d.c();
        }
    }
}
