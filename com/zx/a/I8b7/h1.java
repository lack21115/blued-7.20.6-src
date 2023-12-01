package com.zx.a.I8b7;

import android.util.Base64;
import com.zx.a.I8b7.b1;
import com.zx.module.annotation.Java2C;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/h1.class */
public class h1 extends e {
    @Java2C.Method2C
    private static native String a(JSONObject jSONObject, String str, String str2) throws Exception;

    public static String b(JSONObject jSONObject, String str, String str2) throws Exception {
        b1.a aVar = new b1.a();
        HashMap<String, String> b = a0.b(e.a());
        aVar.f28416c.clear();
        aVar.f28416c.putAll(b);
        b1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/uaid/get");
        a2.b = "POST";
        a2.d = d1.a(n0.b("application/json; charset=utf-8"), a(jSONObject, str, str2));
        a2.e = "said get api";
        w1 w1Var = a0.f28407a;
        b1 b1Var = new b1(aVar);
        w1Var.getClass();
        e1 a3 = new u0(w1Var, b1Var).a();
        if (a3.b == 200) {
            return new JSONObject(k.a(Base64.decode(new JSONObject(a3.e.b()).getString("data"), 2), e.f28427a, "UDID_ENC_AUTHTAG")).getString("uaid");
        }
        String a4 = a3.a("Udid-Error-Code");
        String a5 = a3.a("Udid-Error-Message");
        throw new RuntimeException("response errCode: " + a4 + ", errMsg: " + a5);
    }
}
