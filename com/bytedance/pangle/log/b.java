package com.bytedance.pangle.log;

import com.bytedance.pangle.util.k;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/log/b.class */
public final class b {
    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static int b(Object obj) {
        if (obj == null) {
            return -1;
        }
        return k.a(obj.toString());
    }
}
