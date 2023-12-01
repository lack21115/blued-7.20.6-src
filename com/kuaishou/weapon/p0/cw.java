package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cw.class */
public class cw {
    private static volatile cw b;

    /* renamed from: a  reason: collision with root package name */
    private Context f10196a;

    private cw(Context context) {
        this.f10196a = context;
    }

    public static cw a(Context context) {
        if (b == null) {
            synchronized (cw.class) {
                try {
                    if (b == null) {
                        b = new cw(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(cw.this.f10196a, "re_po_rt");
                    if (a2.b(de.w, 0) == 1) {
                        long a3 = de.a(cw.this.f10196a).a(de.aZ);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.x, 8);
                        int b3 = a2.b(de.o, 0);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a3 >= b2 * 3600000 || i == 106 || (i == 100 && b3 == 1)) {
                            co.a(cw.this.f10196a, new cg(cw.this.f10196a, i).a(cj.i), cj.i, false, true);
                            de.a(cw.this.f10196a).a(de.aZ, currentTimeMillis);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
