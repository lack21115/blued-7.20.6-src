package com.amap.api.col.p0003sl;

import android.content.Context;

/* renamed from: com.amap.api.col.3sl.ic  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ic.class */
public class ic {

    /* renamed from: a  reason: collision with root package name */
    private static ic f5140a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5141c = ij.a(ib.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private ic(Context context) {
        this.b = context.getApplicationContext();
    }

    public static ic a(Context context) {
        if (f5140a == null) {
            synchronized (ic.class) {
                try {
                    if (f5140a == null) {
                        f5140a = new ic(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5140a;
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
        id.a(this.b).a(this.f5141c);
        id.a(this.b).b(str);
    }
}
