package com.tencent.beacon.a.b;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/f.class */
public class f extends e {
    private static volatile f d;

    private f() {
    }

    public static f e() {
        if (d == null) {
            synchronized (f.class) {
                try {
                    if (d == null) {
                        d = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    @Override // com.tencent.beacon.a.b.e
    String b() {
        return "03300051017";
    }

    @Override // com.tencent.beacon.a.b.e
    String c() {
        return "9462881773";
    }
}
