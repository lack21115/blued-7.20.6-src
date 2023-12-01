package com.tencent.beacon.a.b;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/g.class */
public class g extends e {
    private static volatile g d;

    private g() {
    }

    public static g e() {
        if (d == null) {
            synchronized (g.class) {
                try {
                    if (d == null) {
                        d = new g();
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
        return "00400014144";
    }

    @Override // com.tencent.beacon.a.b.e
    String c() {
        return "6478159937";
    }
}
