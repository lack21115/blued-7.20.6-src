package com.opos.cmn.h.a.a;

import com.tencent.mm.opensdk.openapi.IWXAPI;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/h/a/a/b.class */
public class b {
    public static boolean a() {
        try {
            com.opos.cmn.an.f.a.b("Utils", "wx openSdk check class:" + IWXAPI.class.getCanonicalName());
            return true;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("Utils", "Not find wx openSdk!", th);
            return false;
        }
    }
}
