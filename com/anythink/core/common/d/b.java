package com.anythink.core.common.d;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/d/b.class */
public final class b extends a {
    protected static volatile a c;

    private b(Context context) {
        super(context);
        this.b = 2;
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }
}
