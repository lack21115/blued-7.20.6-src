package com.anythink.core.common.d;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/d/c.class */
public class c extends a {
    private static volatile c c;

    private c(Context context) {
        super(context);
        this.b = 1;
    }

    public static c a(Context context) {
        if (c == null) {
            synchronized (c.class) {
                try {
                    if (c == null) {
                        c = new c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }
}
