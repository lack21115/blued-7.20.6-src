package com.opos.cmn.func.b.a.a;

import com.heytap.nearx.okhttp.extension.HeyConfig;
import com.heytap.okhttp.extension.HeyConfig;
import com.opos.cmn.func.b.a.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a/a.class */
public class a {
    public static f a() {
        f fVar;
        try {
            com.opos.cmn.an.f.a.b("HttpImplUtils", new HeyConfig.Builder().toString());
            fVar = new com.opos.cmn.func.b.a.c();
        } catch (Throwable th) {
            fVar = null;
        }
        f fVar2 = fVar;
        if (fVar == null) {
            try {
                com.opos.cmn.an.f.a.b("HttpImplUtils", new HeyConfig.Builder().toString());
                fVar2 = new com.opos.cmn.func.b.a.b();
            } catch (Throwable th2) {
                fVar2 = fVar;
            }
        }
        f fVar3 = fVar2;
        if (fVar2 == null) {
            fVar3 = new com.opos.cmn.func.b.a.a();
        }
        return fVar3;
    }
}
