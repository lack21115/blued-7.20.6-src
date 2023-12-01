package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/da.class */
public class da {
    private static volatile da b;

    /* renamed from: a  reason: collision with root package name */
    private Context f10207a;

    private da(Context context) {
        this.f10207a = context;
    }

    public static da a(Context context) {
        if (b == null) {
            synchronized (da.class) {
                try {
                    if (b == null) {
                        b = new da(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(da.this.f10207a, "re_po_rt");
                    if (a2.b(de.ah, 1) == 1) {
                        long a3 = de.a(da.this.f10207a).a(de.bd);
                        long currentTimeMillis = System.currentTimeMillis();
                        int b2 = a2.b(de.ak, 0);
                        long b3 = a2.b(de.aj, 6);
                        long j = currentTimeMillis - a3;
                        if (j >= b3 * 3600000 || (i == 100 && b2 == 1 && j >= 14400000)) {
                            cf.a(da.this.f10207a, new bv(da.this.f10207a, i, false).a(cj.e), cj.e, true);
                            de.a(da.this.f10207a).a(de.bd, currentTimeMillis);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
