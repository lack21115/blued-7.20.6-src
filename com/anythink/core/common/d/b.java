package com.anythink.core.common.d;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/d/b.class */
public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    protected static volatile a f6608c;

    private b(Context context) {
        super(context);
        this.b = 2;
    }

    public static a a(Context context) {
        if (f6608c == null) {
            synchronized (a.class) {
                try {
                    if (f6608c == null) {
                        f6608c = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6608c;
    }
}
