package com.sdk.tencent.s;

import com.sdk.tencent.f.c;
import com.sdk.tencent.p.b;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/s/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14389a;
    public static Boolean b;

    static {
        new TreeMap();
        f14389a = a.class.getSimpleName();
        b = Boolean.valueOf(c.b);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x007b -> B:7:0x0051). Please submit an issue!!! */
    public static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a2 = b.a(jSONObject.optString("aesKey"), com.sdk.tencent.t.a.b);
            return com.sdk.tencent.q.a.a(jSONObject.optString("data"), a2.substring(0, 16), a2.substring(16));
        } catch (Throwable th) {
            String th2 = th.toString();
            try {
                List<String> list = com.sdk.tencent.n.c.f14376a.b.b;
                list.add(th2);
                com.sdk.tencent.n.c.f14376a.b.b = list;
            } catch (Throwable th3) {
            }
            String str2 = f14389a;
            com.sdk.tencent.n.b.a(str2, "SDK解密异常：" + th.toString(), b);
            return null;
        }
    }
}
