package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cy.class */
public class cy {
    private static volatile cy b;

    /* renamed from: a  reason: collision with root package name */
    private Context f10201a;

    private cy(Context context) {
        this.f10201a = context;
    }

    public static cy a(Context context) {
        if (b == null) {
            synchronized (cy.class) {
                try {
                    if (b == null) {
                        b = new cy(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a() {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(cy.this.f10201a, "re_po_rt");
                    if (a2.b(de.E, 1) == 1) {
                        long a3 = de.a(cy.this.f10201a).a(de.be);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.G, 12);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a3 >= b2 * 3600000) {
                            co.a(cy.this.f10201a, new ci(cy.this.f10201a).a(cj.g), cj.g, true, true);
                            de.a(cy.this.f10201a).a(de.be, currentTimeMillis);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
