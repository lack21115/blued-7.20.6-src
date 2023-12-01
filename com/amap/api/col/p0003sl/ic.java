package com.amap.api.col.p0003sl;

import android.content.Context;

/* renamed from: com.amap.api.col.3sl.ic  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ic.class */
public class ic {
    private static ic a;
    private final Context b;
    private final String c = ij.a(ib.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private ic(Context context) {
        this.b = context.getApplicationContext();
    }

    public static ic a(Context context) {
        if (a == null) {
            synchronized (ic.class) {
                try {
                    if (a == null) {
                        a = new ic(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public final void a() {
        synchronized (this) {
            try {
                if (hs.c() == null) {
                    hs.a(ig.a());
                }
            } catch (Throwable th) {
            }
        }
    }

    public final void a(String str) {
        id.a(this.b).a(this.c);
        id.a(this.b).b(str);
    }
}
