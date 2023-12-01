package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/db.class */
public class db {
    private static volatile db b;

    /* renamed from: a  reason: collision with root package name */
    private Context f23817a;

    private db(Context context) {
        this.f23817a = context;
    }

    public static db a(Context context) {
        if (b == null) {
            synchronized (db.class) {
                try {
                    if (b == null) {
                        b = new db(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(db.this.f23817a, "re_po_rt");
                    if (a2.b(de.au, 1) == 1) {
                        long a3 = de.a(db.this.f23817a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.aw, 8);
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
                            co.a(db.this.f23817a, new cm(db.this.f23817a, i).a(cj.b), cj.b, true, true);
                            de.a(db.this.f23817a).a(currentTimeMillis);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
