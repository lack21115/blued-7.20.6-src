package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cz.class */
public class cz {
    private static volatile cz b;

    /* renamed from: a  reason: collision with root package name */
    private Context f10203a;

    private cz(Context context) {
        this.f10203a = context;
    }

    public static cz a(Context context) {
        if (b == null) {
            synchronized (cz.class) {
                try {
                    if (b == null) {
                        b = new cz(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(final int i, final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(cz.this.f10203a, "re_po_rt");
                    if (a2.b(de.N, 1) == 1) {
                        long a3 = de.a(cz.this.f10203a).a(de.bb);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.P, 1) * 3600000;
                        long b3 = a2.b(de.Q, 5);
                        int b4 = a2.b(de.R, 0);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                dd.a(cz.this.f10203a, bp.f, Integer.valueOf(cj.f10175c).intValue(), ((new Random().nextInt(60) + 1) * 60000) + 3600000, "env://");
                                return;
                            }
                        }
                        long j = currentTimeMillis - a3;
                        if (j < b2 && ((i != 100 || b4 != 1) && i != 106 && (i == 100 || i <= 0 || j < b3 * 60000))) {
                            dd.a(cz.this.f10203a, bp.f, Integer.valueOf(cj.f10175c).intValue(), b2 - j, "env://");
                            return;
                        }
                        co.a(cz.this.f10203a, new ck(cz.this.f10203a, i, i2).a(cj.f10175c), cj.f10175c, true, true);
                        de.a(cz.this.f10203a).a(de.bb, currentTimeMillis);
                        dd.a(cz.this.f10203a, bp.f, Integer.valueOf(cj.f10175c).intValue(), b2, "env://");
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
