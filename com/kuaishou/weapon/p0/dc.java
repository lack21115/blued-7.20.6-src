package com.kuaishou.weapon.p0;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dc.class */
public class dc {
    private static volatile dc b;

    /* renamed from: a  reason: collision with root package name */
    private Context f23819a;

    private dc(Context context) {
        this.f23819a = context;
    }

    public static dc a(Context context) {
        if (b == null) {
            synchronized (dc.class) {
                try {
                    if (b == null) {
                        b = new dc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a() {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(dc.this.f23819a, "re_po_rt");
                    if (a2.b(de.z, 0) == 1) {
                        long a3 = de.a(dc.this.f23819a).a(de.bf);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a3 >= a2.b(de.C, 2) * 3600000) {
                            try {
                                String a4 = new cn(dc.this.f23819a).a(cj.h);
                                int intValue = Integer.valueOf(cj.h).intValue();
                                if (a4 != null && a4.length() > 10) {
                                    new bb(dc.this.f23819a, a4, intValue).a(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable th) {
                            }
                            de.a(dc.this.f23819a).a(de.bf, currentTimeMillis);
                        }
                    }
                } catch (Throwable th2) {
                }
            }
        });
    }
}
