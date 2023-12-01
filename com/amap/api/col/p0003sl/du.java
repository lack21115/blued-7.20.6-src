package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.du  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/du.class */
public class du {
    private static volatile du b;
    private lb a;

    private du() {
        this.a = null;
        this.a = dv.a("AMapThreadUtil");
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
                if (b.a != null) {
                    b.a.e();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            b.a = null;
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
            this.a.a(lcVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
