package com.alipay.apmobilesecuritysdk.b;

import com.alipay.security.mobile.module.http.d;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/b/a.class */
public final class a {
    private static a b = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f4547a = 0;

    public static a a() {
        return b;
    }

    public final void a(int i) {
        this.f4547a = i;
    }

    public final int b() {
        return this.f4547a;
    }

    public final String c() {
        String a2 = d.a();
        if (com.alipay.security.mobile.module.a.a.b(a2)) {
            return a2;
        }
        int i = this.f4547a;
        return i != 1 ? i != 3 ? i != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm" : "http://mobilegw-1-64.test.alipay.net/mgw.htm" : "http://mobilegw.stable.alipay.net/mgw.htm";
    }
}
