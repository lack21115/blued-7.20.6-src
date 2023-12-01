package com.anythink.basead.d.b.a;

import android.net.Uri;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b/a/a.class */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:65:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.basead.c.d a(com.anythink.core.common.e.j r7, com.anythink.core.common.e.i r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.b.a.a.a(com.anythink.core.common.e.j, com.anythink.core.common.e.i, java.lang.String):com.anythink.basead.c.d");
    }

    public static String a(String str) {
        try {
            return Uri.parse(str).getQueryParameter("qz_gdt");
        } catch (Throwable th) {
            return null;
        }
    }
}
