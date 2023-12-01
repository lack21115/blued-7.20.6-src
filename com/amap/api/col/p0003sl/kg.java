package com.amap.api.col.p0003sl;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3sl.kg  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kg.class */
public class kg {
    static WeakReference<ke> a;

    public static void a(final String str, final Context context) {
        iw.d().submit(new Runnable() { // from class: com.amap.api.col.3sl.kg.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (kg.class) {
                    try {
                        String a2 = hw.a(ib.a(String.this));
                        ke a3 = kl.a(kg.a);
                        kl.a(context, a3, iu.j, 50, 102400, "10");
                        if (a3.e == null) {
                            a3.e = new jm(new jp(new jo()));
                        }
                        String a4 = ib.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                        kf.a(a2, ib.a(" \"timestamp\":\"" + a4 + "\",\"details\":" + String.this), a3);
                    }
                }
            }
        });
    }
}
