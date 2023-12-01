package com.anythink.core.common.res.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/a/c.class */
public class c {
    private static volatile c a;
    private final Map<String, a> b = new HashMap();

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                try {
                    if (a == null) {
                        a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public final a a(String str) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str);
        this.b.put(str, aVar2);
        return aVar2;
    }

    public final void b(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }
}
