package com.zx.a.I8b7;

import com.zx.a.I8b7.b1;
import com.zx.module.annotation.Java2C;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/g1.class */
public class g1 extends e {
    @Java2C.Method2C
    private static native String a(String str, String str2) throws Exception;

    public static void b(String str, String str2) throws Exception {
        b1.a aVar = new b1.a();
        HashMap<String, String> b = a0.b(e.a());
        aVar.f28416c.clear();
        aVar.f28416c.putAll(b);
        b1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/uaid/reportAuthToken");
        a2.b = "POST";
        a2.d = d1.a(n0.b("application/json; charset=utf-8"), a(str, str2));
        a2.e = "SAIDCodeRequest get api";
        w1 w1Var = a0.f28407a;
        b1 b1Var = new b1(aVar);
        w1Var.getClass();
        new u0(w1Var, b1Var).a();
    }
}
