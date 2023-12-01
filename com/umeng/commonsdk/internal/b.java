package com.umeng.commonsdk.internal;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/b.class */
public class b {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    private Context f40860a;

    /* renamed from: c  reason: collision with root package name */
    private c f40861c;

    private b(Context context) {
        this.f40860a = context;
        this.f40861c = new c(context);
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
        return this.f40861c;
    }
}
