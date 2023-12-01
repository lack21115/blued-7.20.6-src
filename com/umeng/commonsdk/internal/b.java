package com.umeng.commonsdk.internal;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/b.class */
public class b {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27169a;

    /* renamed from: c  reason: collision with root package name */
    private c f27170c;

    private b(Context context) {
        this.f27169a = context;
        this.f27170c = new c(context);
    }

    public static b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (b == null) {
                    b = new b(context.getApplicationContext());
                }
                bVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public c a() {
        return this.f27170c;
    }
}
