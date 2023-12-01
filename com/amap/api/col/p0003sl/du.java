package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.du  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/du.class */
public class du {
    private static volatile du b;

    /* renamed from: a  reason: collision with root package name */
    private lb f4868a;

    private du() {
        this.f4868a = null;
        this.f4868a = dv.a("AMapThreadUtil");
    }

    public static du a() {
        if (b == null) {
            synchronized (du.class) {
                try {
                    if (b == null) {
                        b = new du();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void b() {
        if (b != null) {
            try {
                if (b.f4868a != null) {
                    b.f4868a.e();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            b.f4868a = null;
            b = null;
        }
    }

    public static void b(lc lcVar) {
        if (lcVar != null) {
            try {
                lcVar.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(lc lcVar) {
        try {
            this.f4868a.a(lcVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
