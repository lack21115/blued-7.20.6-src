package a.a.a.a.a.m.b;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1455a = true;
    public static int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f1456c = 10;
    public static float d = 0.85f;
    public static float e = 0.25f;
    public static float f = 0.6f;
    public static float g = 0.4f;
    public static float h = 10.0f;
    public static int i = 4;
    public static int j = 3;
    public b k;
    public b l;
    public float m;
    public List<Float> n;
    public List<Float> o;
    public List<Float> p;
    public float q;
    public float r;
    public float s;
    public List<Float> t;
    public List<Float> u;

    /* renamed from: a.a.a.a.a.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/b/a$a.class */
    public static /* synthetic */ class C0020a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1457a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.values().length];
            f1457a = iArr;
            try {
                iArr[b.PLNetworkQualityShiftTrendingNone.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1457a[b.PLNetworkQualityShiftTrendingUp.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1457a[b.PLNetworkQualityShiftTrendingDown.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/b/a$b.class */
    public enum b {
        PLNetworkQualityShiftTrendingNone,
        PLNetworkQualityShiftTrendingUp,
        PLNetworkQualityShiftTrendingDown
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/b/a$c.class */
    public enum c {
        PLSampleDetectionResultTypeNormal,
        PLSampleDetectionResultTypeLevelShift,
        PLSampleDetectionResultTypeOutlier
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/m/b/a$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1462a = new a();
    }

    public static a a() {
        return d.f1462a;
    }

    public void a(float f2) {
        this.m = f2;
        c();
        List<Float> list = this.t;
        if (list == null) {
            this.t = new ArrayList(2);
        } else {
            list.clear();
        }
        List<Float> list2 = this.u;
        if (list2 == null) {
            this.u = new ArrayList(2);
        } else {
            list2.clear();
        }
        b bVar = b.PLNetworkQualityShiftTrendingNone;
        this.k = bVar;
        this.l = bVar;
        e.k.c("PLTCPSendTimePredictor", "PLTCPSendTimePredictor init!");
    }

    public final void a(List<Float> list) {
        if (list == null) {
            return;
        }
        c();
        for (Float f2 : list) {
            e(f2.floatValue());
        }
        if (list.size() > 0) {
            this.m = list.get(list.size() - 1).floatValue();
        }
        e.k.b("PLTCPSendTimePredictor", "tcp predictor restart");
    }

    public final void a(List<Float> list, float f2) {
        a(list, f2, b);
    }

    public final void a(List<Float> list, float f2, int i2) {
        if (list == null) {
            return;
        }
        list.add(Float.valueOf(f2));
        if (list.size() > i2) {
            list.remove(0);
        }
    }

    public float b(float f2) {
        double d2;
        List<Float> list;
        double d3;
        float f3;
        double d4;
        if (f2 == 0.0f) {
            return f2;
        }
        if (f1455a) {
            c c2 = c(f2);
            if (c2 == c.PLSampleDetectionResultTypeOutlier) {
                return this.m;
            }
            if (c2 == c.PLSampleDetectionResultTypeLevelShift) {
                this.k = this.l;
            } else {
                this.k = b.PLNetworkQualityShiftTrendingNone;
            }
            float f4 = f2 - this.m;
            if (Math.abs(f4) / this.m <= f || Math.abs(f4) <= 15.0f) {
                this.s = 0.0f;
            } else {
                float f5 = this.s + 1.0f;
                this.s = f5;
                if (f5 >= j && f2 > this.m) {
                    this.k = b.PLNetworkQualityShiftTrendingDown;
                    this.s = 0.0f;
                }
            }
        } else {
            e(f2);
        }
        if (this.t.size() == 0 || this.u.size() == 0) {
            d(f2);
        }
        int i2 = 0;
        double floatValue = this.t.get(0).floatValue();
        if (this.t.size() == b) {
            List<Float> list2 = this.t;
            d2 = list2.get(list2.size() - 1).floatValue();
        } else {
            d2 = floatValue;
        }
        if (this.u.size() == f1456c) {
            list = this.u;
            i2 = list.size() - 1;
        } else {
            list = this.u;
        }
        double floatValue2 = list.get(i2).floatValue();
        float f6 = d;
        a(this.t, (int) d3);
        a(this.u, (int) d4);
        float f7 = (int) ((f2 * f6) + ((1.0f - f6) * this.m) + (e * (d2 - floatValue)) + ((1.0f - f3) * floatValue2));
        this.m = f7;
        return f7;
    }

    public b b() {
        return this.k;
    }

    public final c c(float f2) {
        if (this.n.size() < i) {
            e(f2);
            return c.PLSampleDetectionResultTypeNormal;
        }
        float a2 = h.a(this.n);
        float f3 = f2 - a2;
        double abs = Math.abs(f3);
        double d2 = a2;
        if (abs / d2 >= f && Math.abs(f3) > h) {
            e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] discard outlier sample.");
            this.p.add(Float.valueOf(f2));
            if (this.p.size() < j) {
                return c.PLSampleDetectionResultTypeOutlier;
            }
            float a3 = h.a(this.p) - a2;
            if (Math.abs(a3 / d2) < g || Math.abs(a3) <= 10.0f) {
                e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] enqueue outlier sample");
                a(this.p, f2, j);
                return c.PLSampleDetectionResultTypeOutlier;
            }
            a(this.p);
            this.l = a3 > 0.0f ? b.PLNetworkQualityShiftTrendingDown : b.PLNetworkQualityShiftTrendingUp;
            return c.PLSampleDetectionResultTypeLevelShift;
        }
        if (f2 > this.r) {
            int i2 = C0020a.f1457a[this.l.ordinal()];
            if (i2 == 1) {
                this.o.add(Float.valueOf(f2));
                this.l = b.PLNetworkQualityShiftTrendingDown;
            } else if (i2 == 2) {
                ArrayList<Float> arrayList = new ArrayList();
                arrayList.addAll(this.o);
                this.o.clear();
                for (Float f4 : arrayList) {
                    e(f4.floatValue());
                }
                this.l = b.PLNetworkQualityShiftTrendingNone;
            } else if (i2 == 3) {
                this.o.add(Float.valueOf(f2));
                if (this.o.size() >= j) {
                    float a4 = h.a(this.o);
                    float a5 = h.a(this.n);
                    float f5 = a4 - a5;
                    double abs2 = Math.abs(f5) / a5;
                    a(this.o);
                    if (abs2 <= g || Math.abs(f5) <= h) {
                        return c.PLSampleDetectionResultTypeNormal;
                    }
                    e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] network quality trending down");
                    return c.PLSampleDetectionResultTypeLevelShift;
                }
            }
        } else if (f2 < this.q) {
            int i3 = C0020a.f1457a[this.l.ordinal()];
            if (i3 == 1) {
                this.o.add(Float.valueOf(f2));
                this.l = b.PLNetworkQualityShiftTrendingUp;
            } else if (i3 == 2) {
                this.o.add(Float.valueOf(f2));
                if (this.o.size() >= j) {
                    float a6 = h.a(this.o);
                    float a7 = h.a(this.n);
                    float f6 = a6 - a7;
                    double abs3 = Math.abs(f6) / a7;
                    a(this.o);
                    if (abs3 <= g || Math.abs(f6) <= h) {
                        return c.PLSampleDetectionResultTypeLevelShift;
                    }
                    e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] network quality trending up");
                    return c.PLSampleDetectionResultTypeLevelShift;
                }
            } else if (i3 == 3) {
                ArrayList<Float> arrayList2 = new ArrayList();
                arrayList2.addAll(this.o);
                this.o.clear();
                for (Float f7 : arrayList2) {
                    e(f7.floatValue());
                }
                this.l = b.PLNetworkQualityShiftTrendingNone;
            }
        } else {
            e(f2);
        }
        return c.PLSampleDetectionResultTypeNormal;
    }

    public final void c() {
        this.q = 2.14748365E9f;
        this.r = -2.14748365E9f;
        this.s = 0.0f;
        List<Float> list = this.n;
        if (list == null) {
            this.n = new ArrayList();
        } else {
            list.clear();
        }
        List<Float> list2 = this.o;
        if (list2 == null) {
            this.o = new ArrayList();
        } else {
            list2.clear();
        }
        List<Float> list3 = this.p;
        if (list3 == null) {
            this.p = new ArrayList();
        } else {
            list3.clear();
        }
    }

    public final void d(float f2) {
        float f3 = this.m;
        a(this.t, f3);
        a(this.u, f3 - f2);
    }

    public final void e(float f2) {
        a(this.n, f2, f1456c);
        if (!this.n.contains(Float.valueOf(this.q))) {
            this.q = ((Float) Collections.min(this.n)).floatValue();
        } else if (f2 < this.q) {
            this.q = f2;
        }
        if (!this.n.contains(Float.valueOf(this.r))) {
            this.r = ((Float) Collections.max(this.n)).floatValue();
        } else if (f2 > this.r) {
            this.r = f2;
        }
        if (this.p.size() > 0) {
            this.p.clear();
        }
    }
}
