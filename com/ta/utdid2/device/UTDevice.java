package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/device/UTDevice.class */
public class UTDevice {
    private static String d(Context context) {
        a b = b.b(context);
        return (b == null || g.m9885a(b.f())) ? "ffffffffffffffffffffffff" : b.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (com.ta.utdid2.a.a.g.m9885a(r0) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(android.content.Context r2) {
        /*
            r0 = r2
            com.ta.utdid2.device.c r0 = com.ta.utdid2.device.c.a(r0)
            java.lang.String r0 = r0.h()
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L15
            r0 = r3
            r2 = r0
            r0 = r3
            boolean r0 = com.ta.utdid2.a.a.g.m9885a(r0)
            if (r0 == 0) goto L18
        L15:
            java.lang.String r0 = "ffffffffffffffffffffffff"
            r2 = r0
        L18:
            r0 = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.UTDevice.e(android.content.Context):java.lang.String");
    }

    @Deprecated
    public static String getUtdid(Context context) {
        return d(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return e(context);
    }
}
