package com.anythink.core.common.d;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/d/c.class */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f6609c;

    private c(Context context) {
        super(context);
        this.b = 1;
    }

    public static c a(Context context) {
        if (f6609c == null) {
            synchronized (c.class) {
                try {
                    if (f6609c == null) {
                        f6609c = new c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6609c;
    }
}
