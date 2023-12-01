package com.alipay.security.mobile.module.http.v2;

import android.content.Context;
import com.alipay.security.mobile.module.http.d;
import com.alipay.security.mobile.module.http.model.c;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/http/v2/b.class */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4722a;
    private static com.alipay.security.mobile.module.http.a b;

    public static a a(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f4722a == null) {
            b = d.a(context, str);
            f4722a = new b();
        }
        return f4722a;
    }

    @Override // com.alipay.security.mobile.module.http.v2.a
    public c a(com.alipay.security.mobile.module.http.model.d dVar) {
        return com.alipay.security.mobile.module.http.model.b.a(b.a(com.alipay.security.mobile.module.http.model.b.a(dVar)));
    }

    @Override // com.alipay.security.mobile.module.http.v2.a
    public boolean a(String str) {
        return b.a(str);
    }
}
