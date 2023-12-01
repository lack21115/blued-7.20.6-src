package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cx.class */
public class cx {
    private static volatile cx b;

    /* renamed from: a  reason: collision with root package name */
    private Context f10198a;

    private cx(Context context) {
        this.f10198a = context;
    }

    public static cx a(Context context) {
        if (b == null) {
            synchronized (cx.class) {
                try {
                    if (b == null) {
                        b = new cx(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        try {
            h a2 = h.a(this.f10198a, "re_po_rt");
            final boolean e = a2.e("a1_p_s_p_s");
            final boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if ((e || e2) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            h a3 = h.a(cx.this.f10198a, "re_po_rt");
                            if (a3.b(de.m, 1) == 1) {
                                if (e || e2) {
                                    long a4 = de.a(cx.this.f10198a).a(de.ba);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b2 = a3.b(de.n, 8);
                                    int b3 = a3.b(de.o, 0);
                                    long b4 = a3.b(de.q, 20);
                                    if (a4 > 0 && currentTimeMillis - a4 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(hours);
                                        if (list.contains(sb.toString())) {
                                            return;
                                        }
                                    }
                                    long j = currentTimeMillis - a4;
                                    if (j < b2 * 3600000 && (i != 100 || b3 != 1)) {
                                        if (i != 101 && i != 102) {
                                            return;
                                        }
                                        if (j < b4 * 60000) {
                                            return;
                                        }
                                    }
                                    co.a(cx.this.f10198a, new ch(cx.this.f10198a, i).a(cj.d), cj.d, true, true);
                                    de.a(cx.this.f10198a).a(de.ba, currentTimeMillis);
                                }
                            }
                        } catch (Throwable th) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }
}
