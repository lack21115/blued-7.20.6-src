package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/a.class */
public final class a implements c {
    @Override // com.efs.sdk.base.core.c.c
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        HttpResponse a2;
        com.efs.sdk.base.core.a.c a3 = com.efs.sdk.base.core.a.c.a();
        a3.d = bVar.f21764a.d;
        a3.e = bVar.f21764a.e;
        a3.g = bVar.f21764a.b;
        a3.h = bVar.f21764a.f21762a;
        a3.m = bVar.a();
        String a4 = com.efs.sdk.base.core.config.a.c.a().a(false);
        if (bVar.f21764a.f21763c == 0) {
            com.efs.sdk.base.core.a.a a5 = com.efs.sdk.base.core.a.a.a();
            byte[] bArr = bVar.f21765c;
            boolean z2 = bVar.b.b;
            String b = a3.b();
            String a6 = com.efs.sdk.base.core.a.a.a(a4, a3);
            if (a5.f21719a) {
                Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(a6)));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("wpk-header", b);
            com.efs.sdk.base.core.util.a.d a7 = new com.efs.sdk.base.core.util.a.d(a6).a(hashMap);
            a7.f21791a.f21789c = bArr;
            a7.f21791a.g = true;
            com.efs.sdk.base.core.util.a.d a8 = a7.a("type", a3.h);
            StringBuilder sb = new StringBuilder();
            sb.append(a3.m);
            a2 = a8.a("size", sb.toString()).a("flow_limit", Boolean.toString(z2)).a(com.efs.sdk.base.core.a.d.a()).a().b();
        } else {
            a2 = 1 == bVar.f21764a.f21763c ? com.efs.sdk.base.core.a.a.a().a(a4, a3, bVar.d, bVar.b.b) : new HttpResponse();
        }
        if (a2.succ && z) {
            com.efs.sdk.base.core.util.b.b(bVar.d);
        }
        return a2;
    }
}
