package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.android.internal.http.multipart.FilePart;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/packet/impl/d.class */
public class d extends com.alipay.sdk.packet.e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, com.alipay.sdk.cons.a.c, true);
    }

    @Override // com.alipay.sdk.packet.e
    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.alipay.sdk.packet.e.a, String.valueOf(z));
        hashMap.put(com.alipay.sdk.packet.e.d, FilePart.DEFAULT_CONTENT_TYPE);
        hashMap.put(com.alipay.sdk.packet.e.g, "CBC");
        return hashMap;
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    public String c() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.alipay.sdk.packet.e.i, "/sdk/log");
        hashMap.put(com.alipay.sdk.packet.e.j, "1.0.0");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(t, "1.0");
        return a(hashMap, hashMap2);
    }
}
