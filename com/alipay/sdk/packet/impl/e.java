package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.net.a;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/packet/impl/e.class */
public class e extends com.alipay.sdk.packet.e {
    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "mdap post");
        byte[] a2 = com.alipay.sdk.encrypt.c.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put("utdId", com.alipay.sdk.sys.b.a().e());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", "alipaysdk");
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put("Content-Encoding", "Gzip");
        hashMap.put("productVersion", "15.7.4");
        a.b a3 = com.alipay.sdk.net.a.a(context, new a.C0049a(com.alipay.sdk.cons.a.d, hashMap, a2));
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "mdap got " + a3);
        if (a3 != null) {
            boolean a4 = a(a3);
            try {
                byte[] bArr = a3.f4637c;
                byte[] bArr2 = bArr;
                if (a4) {
                    bArr2 = com.alipay.sdk.encrypt.c.b(bArr);
                }
                return new com.alipay.sdk.packet.b("", new String(bArr2, Charset.forName("UTF-8")));
            } catch (Exception e) {
                com.alipay.sdk.util.c.a(e);
                return null;
            }
        }
        throw new RuntimeException("Response is null");
    }

    @Override // com.alipay.sdk.packet.e
    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        return new HashMap();
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() {
        return null;
    }
}
